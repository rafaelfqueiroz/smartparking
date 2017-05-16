package com.smartparking.publishers;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.google.android.gcm.server.InvalidRequestException;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.smartparking.interfaces.Feed;

public class GCMPublisher extends Publisher {
	
	private static final String APY_KEY = "AIzaSyAOX_Df01I4BHEVFF90wJ4o-2eHRroc400";
	private static final String CLIENT_KEY = "";

	public GCMPublisher(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
	public void publish(Feed feed, String urlToPublish) {
		Sender sender = new Sender(APY_KEY);
		Message msg = new Message.Builder().addData("message", "Mensagem de teste enviada!").build();
		try {
			Result result = sender.send(msg, CLIENT_KEY, 2);
		
			if (StringUtils.isEmpty(result.getErrorCodeName())) {
				System.out.println("GCM Notification is sent successfully" + result.toString());
			}
		} catch (InvalidRequestException e) {
			System.out.println("Invalid Request");
		} catch (IOException e) {
		System.out.println("IO Exception");
		}
	}

}
