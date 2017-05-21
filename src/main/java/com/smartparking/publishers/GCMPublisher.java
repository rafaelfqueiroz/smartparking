package com.smartparking.publishers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.smartparking.vo.VO;

public class GCMPublisher extends Publisher {
	
	private static final String APY_KEY = "key=AIzaSyCZy2efY1j8A3QmTm79OjJFcVyUfcqN9GM";
	private static final String CLIENT_KEY = "c5RnO00EqV0:APA91bF1RKmyoPmouKHyg400V8JymPf2xEkdHDjl2gnUcHTwizMC9zqCDmsXO_XSceUSEt-zqHk0e9bEeAPgneCfAZuhvLnSz_U96vJRKfbkxhvvruqSvKX7kDp7X1CzAyUFqz17yeMu";
	
	public GCMPublisher(String urlToPublish) {
		super(urlToPublish);
	}

	@Override
	public void publish(VO vo, String urlToPublish) {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.set("Authorization", APY_KEY);
		
		/*HttpEntity<String> requestEntity = new HttpEntity<String>(
				"{  \"to\": \"c5RnO00EqV0:APA91bF1RKmyoPmouKHyg400V8JymPf2xEkdHDjl2gnUcHTwizMC9zqCDmsXO_XSceUSEt-zqHk0e9bEeAPgneCfAZuhvLnSz_U96vJRKfbkxhvvruqSvKX7kDp7X1CzAyUFqz17yeMu\",  \"data\": {    \"message\": \"Teste 4\"   }}", header);
		*/
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("to", CLIENT_KEY);
		map.put("data", vo.parseToMap());
		HttpEntity<Map<String, Object>> requestEntity = 
				new HttpEntity<Map<String, Object>>(map, header);
		try {
			getAsyncRestTemplate().postForLocation(new URI(urlToPublish), requestEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
