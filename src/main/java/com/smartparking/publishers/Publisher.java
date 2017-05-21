package com.smartparking.publishers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.smartparking.vo.VO;

public abstract class Publisher {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	
	private String urlToPublish;
	
	public Publisher() {}
	
	public Publisher(String urlToPublish) {
		this.setUrlToPublish(urlToPublish);
	}
	
	public void publish(VO vo) {
		publish(vo, getUrlToPublish());
	}
	
	public abstract void publish(VO feed, String urlToPublish);
	
	protected RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	protected AsyncRestTemplate getAsyncRestTemplate() {
		return asyncRestTemplate;
	}

	public String getUrlToPublish() {
		return urlToPublish;
	}

	public void setUrlToPublish(String urlToPublish) {
		this.urlToPublish = urlToPublish;
	}
	
}
