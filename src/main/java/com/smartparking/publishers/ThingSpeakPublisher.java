package com.smartparking.publishers;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.smartparking.builders.MapBuilder;
import com.smartparking.interfaces.Feed;

@Component
@SuppressWarnings("rawtypes")
public class ThingSpeakPublisher extends Publisher {

	public ThingSpeakPublisher(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void publish(Feed feed, String urlToPublish) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> requestEntity = 
				new HttpEntity<Map<String, String>>(getMapBuilder().build(feed), header);
		try {
			getRestTemplate().postForLocation(new URI(urlToPublish), requestEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
