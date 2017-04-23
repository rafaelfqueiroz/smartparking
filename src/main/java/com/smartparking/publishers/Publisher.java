package com.smartparking.publishers;

import org.springframework.web.client.RestTemplate;

import com.smartparking.builders.MapBuilder;
import com.smartparking.interfaces.Feed;

public abstract class Publisher {

	private RestTemplate restTemplate;
	private MapBuilder builder;
	
	public Publisher(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public abstract void publish(Feed feed, String urlToPublish);
	
	protected RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public MapBuilder getMapBuilder() {
		return builder;
	}

	public void setMapBuilder(MapBuilder builder) {
		this.builder = builder;
	}
	
}
