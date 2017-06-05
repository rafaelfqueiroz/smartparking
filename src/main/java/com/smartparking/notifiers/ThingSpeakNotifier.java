package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.domain.Car;
import com.smartparking.domain.Feed;
import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;
import com.smartparking.exceptions.CarNotRegisteredException;
import com.smartparking.publishers.GCMPublisher;
import com.smartparking.publishers.Publisher;
import com.smartparking.publishers.ThingSpeakPublisher;
import com.smartparking.repositories.CarRepository;
import com.smartparking.repositories.ParkingLotRepository;
import com.smartparking.services.UserService;
import com.smartparking.vo.ErrorVO;
import com.smartparking.vo.ParkingLotVO;
import com.smartparking.vo.VO;
import com.smartparking.vo.thingspeak.TSpeakApiKeyVODecorator;
import com.smartparking.vo.thingspeak.TSpeakParkingLotVO;

/**
 * Notification service for ThingSpeak IoT platform.
 * @author rafaelfdequeiroz
 *
 */
@Service
public class ThingSpeakNotifier implements Notifier {
	
	private static final String DEFAULT_THINSPEAK_URL = "https://api.thingspeak.com";
	private static final String DEFAULT_GCM_URL = "https://fcm.googleapis.com/fcm/send";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ParkingLotRepository parkingRepository;
	
	@Autowired
	private CarRepository carParkingRepository;
	
	@Override
	public void notify(Feed feed) throws CarNotRegisteredException {

		Car car = (Car) feed;
		car = carParkingRepository.findByTagValue(car.getTagValue());
		
		if (car == null) {
			throw new CarNotRegisteredException();
		}
		
		String userToken = userService.findUserTokenFromCar(car);
		
		ParkingLot lot = parkingRepository.findFirstByState(StateTypes.FREE.ordinal());
		
		GCMPublisher gcmPublisher = new GCMPublisher(DEFAULT_GCM_URL);
		gcmPublisher.setClientKey(userToken);
		
		VO vo = null;
		
		if (lot == null) {
			vo = new ErrorVO("Não existe uma vaga vazia");
			gcmPublisher.publish(vo);
			return;
		}
		
		lot.setState(StateTypes.RESERVED.ordinal());
		parkingRepository.save(lot);
		
		vo = new ParkingLotVO(lot.getNumber(), lot.getState());
		
		VO tsVO = new TSpeakParkingLotVO(lot.getNumber(), lot.getState()); 
		
		Publisher tsPublisher = new ThingSpeakPublisher(DEFAULT_THINSPEAK_URL + "/update");
		tsPublisher.publish(new TSpeakApiKeyVODecorator(tsVO));
		
		gcmPublisher.publish(vo);
	}
}
