package com.smartparking.decorators;

import java.util.Map;

public class ApiKeyDecorator implements MapDecorator<String> {

	@Override
	public void decorate(Map<String, String> map) {
		map.put("api_key", "OD0IXUH4S8CFALM4");
	}

}
