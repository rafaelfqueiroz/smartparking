package com.smartparking.consumers;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.smartparking.interfaces.Feed;

@Component
public class ThingSpeakPublisher extends Publisher {

	public ThingSpeakPublisher(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
	public void publish(Feed feed, URI urlToPublish) {
			getRestTemplate().postForLocation(urlToPublish, feed);
	}
}
