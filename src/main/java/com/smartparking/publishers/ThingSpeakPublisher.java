package com.smartparking.publishers;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.smartparking.vo.VO;

public class ThingSpeakPublisher extends Publisher {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
	
	public ThingSpeakPublisher() {}
	
	public ThingSpeakPublisher(String urlToPublish) {
		super(urlToPublish);
	}

	@Override
	public void publish(VO vo, String urlToPublish) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> requestEntity = 
				new HttpEntity<Map<String, Object>>(vo.parseToMap(), header);
		try {
			asyncRestTemplate.postForLocation(new URI(urlToPublish), requestEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
