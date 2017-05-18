package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.smartparking.builders.ParkingLotTSpeakBuilder;
import com.smartparking.decorators.ApiKeyDecorator;
import com.smartparking.domain.CarParking;
import com.smartparking.interfaces.Feed;
import com.smartparking.publishers.GCMPublisher;
import com.smartparking.publishers.ThingSpeakPublisher;
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
	private  ThingSpeakPublisher publisher;
	
	@Autowired
	private GCMPublisher gcmPublisher;
	
	@Override
	public void notify(Feed feed) {
		publisher.setMapBuilder(new ParkingLotTSpeakBuilder(new ApiKeyDecorator()));
		publisher.publish(TSpeakCarParkingVO.of((CarParking)feed), DEFAULT_THINSPEAK_URL + "/update");
		gcmPublisher.publish(null, DEFAULT_GCM_URL);
	}
}
