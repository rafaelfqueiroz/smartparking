package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.domain.Feed;
import com.smartparking.domain.ParkingLot;
import com.smartparking.publishers.GCMPublisher;
import com.smartparking.publishers.ThingSpeakPublisher;
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
	
	@Override
	public void notify(Feed feed) {
		ParkingLot lot = (ParkingLot) feed;
		
		//VO cpVO = new CarParkingVO(car.getTagValue());
		VO lotVO = new ParkingLotVO(lot.getNumber(), lot.getState());
		GCMPublisher gcmP = new GCMPublisher(DEFAULT_GCM_URL);
		gcmP.publish(lotVO);
		//gcmP.setClientKey(userService.findUserTokenFromCar(car));
		//gcmP.publish(cpVO);
		
		VO tsVO = new TSpeakParkingLotVO(lot.getNumber(), lot.getState()); 
		//new TSpeakCarParkingVO(car.getTagValue());
		new ThingSpeakPublisher(DEFAULT_THINSPEAK_URL + "/update").publish(new TSpeakApiKeyVODecorator(tsVO));
	}
}
