package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.domain.CarParking;
import com.smartparking.domain.Feed;
import com.smartparking.publishers.GCMPublisher;
import com.smartparking.publishers.ThingSpeakPublisher;
import com.smartparking.services.UserService;
import com.smartparking.vo.CarParkingVO;
import com.smartparking.vo.VO;
import com.smartparking.vo.thingspeak.TSpeakApiKeyVODecorator;
import com.smartparking.vo.thingspeak.TSpeakCarParkingVO;

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
		CarParking car = (CarParking) feed;
		
		VO cpVO = new CarParkingVO(car.getTagValue());
		GCMPublisher gcmP = new GCMPublisher(DEFAULT_GCM_URL);
		gcmP.setClientKey(userService.findUserTokenFromCar(car));
		gcmP.publish(cpVO);
		
		VO tsVO = new TSpeakCarParkingVO(car.getTagValue());
		new ThingSpeakPublisher(DEFAULT_THINSPEAK_URL + "/update").publish(new TSpeakApiKeyVODecorator(tsVO));
	}
}
