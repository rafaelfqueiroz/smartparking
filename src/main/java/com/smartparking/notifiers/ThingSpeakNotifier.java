package com.smartparking.notifiers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartparking.interfaces.Feed;
import com.smartparking.publishers.ThingSpeakPublisher;

@Component
public class ThingSpeakNotifier implements Notifier {
	
	private static final String DEFAULT_THINSPEAK_URL = "https://api.thingspeak.com/";

	@Autowired
	private  ThingSpeakPublisher publisher;
	
	@Override
	public void notifyEntrance(Feed feed) {
		//notify(feed, "/channel_id");
	}
	
	@Override
	public void notify(Feed feed, String routeURI) {
		try {
			publisher.publish(feed, new URI(DEFAULT_THINSPEAK_URL + routeURI));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
