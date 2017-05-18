package com.smartparking.publishers;

import org.springframework.web.client.RestTemplate;

import com.smartparking.builders.MapBuilder;
import com.smartparking.interfaces.Feed;
import com.smartparking.vo.VO;

public abstract class Publisher<T extends VO> {

	private RestTemplate restTemplate;
	private MapBuilder builder;
	
	public Publisher(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public abstract void publish(T feed, String urlToPublish);
	
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
