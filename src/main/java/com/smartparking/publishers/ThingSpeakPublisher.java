package com.smartparking.publishers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.smartparking.vo.thingspeak.TSpeakCarParkingVO;

@Component
public class ThingSpeakPublisher extends Publisher<TSpeakCarParkingVO> {
	
	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	

	public ThingSpeakPublisher(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
	public void publish(TSpeakCarParkingVO vo, String urlToPublish) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<TSpeakCarParkingVO> requestEntity = 
				new HttpEntity<TSpeakCarParkingVO>(vo, header);
		try {
			asyncRestTemplate.postForLocation(new URI(urlToPublish), requestEntity);
			//getRestTemplate().postForLocation(new URI(urlToPublish), requestEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
