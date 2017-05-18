package com.smartparking.publishers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.smartparking.vo.thingspeak.TSpeakCarParkingVO;

@Component
public class GCMPublisher extends Publisher<TSpeakCarParkingVO> {
	
	private static final String APY_KEY = "key=AIzaSyCZy2efY1j8A3QmTm79OjJFcVyUfcqN9GM";
	private static final String CLIENT_KEY = "c5RnO00EqV0:APA91bF1RKmyoPmouKHyg400V8JymPf2xEkdHDjl2gnUcHTwizMC9zqCDmsXO_XSceUSEt-zqHk0e9bEeAPgneCfAZuhvLnSz_U96vJRKfbkxhvvruqSvKX7kDp7X1CzAyUFqz17yeMu";
	
	@Autowired
	private AsyncRestTemplate asyncRestTemplate;
	
	
	public GCMPublisher(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
	public void publish(TSpeakCarParkingVO vo, String urlToPublish) {
		
		HttpHeaders header = new HttpHeaders();
		header.set("Content-Type", "application/json");
		header.set("Authorization", APY_KEY);
		
		/*HttpEntity<String> requestEntity = new HttpEntity<String>(
				"{  \"to\": \"c5RnO00EqV0:APA91bF1RKmyoPmouKHyg400V8JymPf2xEkdHDjl2gnUcHTwizMC9zqCDmsXO_XSceUSEt-zqHk0e9bEeAPgneCfAZuhvLnSz_U96vJRKfbkxhvvruqSvKX7kDp7X1CzAyUFqz17yeMu\",  \"data\": {    \"message\": \"Teste 4\"   }}", header);
		*/
		//ResponseEntity<String> responseEntity = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("to", CLIENT_KEY);
		map.put("data", "Teste de envio de mensagem.");
		HttpEntity<Map<String, String>> requestEntity = 
				new HttpEntity<Map<String, String>>(map, header);
		try {
			asyncRestTemplate.postForLocation(new URI(urlToPublish), requestEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//responseEntity = getRestTemplate().exchange(urlToPublish, HttpMethod.POST, requestEntity, String.class);
		//header.set("data", "Teste de envio de mensagem.");
		//try {
		//getRestTemplate().postForLocation(new URI(urlToPublish), requestEntity);
		//} catch (Exception e) {
		//e.printStackTrace();
		//}
	}

}
