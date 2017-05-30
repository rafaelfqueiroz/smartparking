package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.domain.CarParking;
import com.smartparking.domain.Feed;
import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;
import com.smartparking.exceptions.CarNotRegisteredException;
import com.smartparking.publishers.GCMPublisher;
import com.smartparking.publishers.ThingSpeakPublisher;
import com.smartparking.repositories.CarParkingRepository;
import com.smartparking.repositories.ParkingLotRepository;
import com.smartparking.services.UserService;
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
	private CarParkingRepository carParkingRepository;
	
	@Override
	public void notify(Feed feed) throws CarNotRegisteredException {

		CarParking car = (CarParking) feed;
		car = carParkingRepository.findByTagValue(car.getTagValue());
		
		if (car == null) {
			throw new CarNotRegisteredException();
		}
		
		String userToken = userService.findUserTokenFromCar(car);
		
		ParkingLot lot = parkingRepository.findFirstByState(StateTypes.FREE.ordinal());
		lot.setState(StateTypes.RESERVED.ordinal());
		parkingRepository.save(lot);
		
		VO lotVO = null;
		if (lot != null) {
			lotVO = new ParkingLotVO(lot.getNumber(), lot.getState());
			
			VO tsVO = new TSpeakParkingLotVO(lot.getNumber(), lot.getState()); 
			new ThingSpeakPublisher(DEFAULT_THINSPEAK_URL + "/update").publish(new TSpeakApiKeyVODecorator(tsVO));
		}

		GCMPublisher gcmP = new GCMPublisher(DEFAULT_GCM_URL);
		gcmP.setClientKey(userToken);
		gcmP.publish(lotVO);
	}
}
