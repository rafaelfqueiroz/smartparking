package com.smartparking.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartparking.builders.ParkingLotTSpeakBuilder;
import com.smartparking.decorators.ApiKeyDecorator;
import com.smartparking.interfaces.Feed;
import com.smartparking.publishers.ThingSpeakPublisher;

@Component
public class ThingSpeakNotifier implements Notifier {
	
	private static final String DEFAULT_THINSPEAK_URL = "https://api.thingspeak.com";

	@Autowired
	private  ThingSpeakPublisher publisher;
	
	@Override
	public void notifyEntrance(Feed feed) {
		publisher.setMapBuilder(new ParkingLotTSpeakBuilder(new ApiKeyDecorator()));
		notify(feed, "/update");
	}
	
	@Override
	public void notify(Feed feed, String routeURI) {
		publisher.publish(feed, DEFAULT_THINSPEAK_URL + routeURI);
	}
}
