package com.smartparking.consumers;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.smartparking.interfaces.Feed;

public abstract class Publisher {

	private RestTemplate restTemplate;
	
	public Publisher(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public abstract void publish(Feed feed, URI urlToPublish);
	
	protected RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
}
