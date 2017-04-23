package com.smartparking.builders;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.smartparking.decorators.MapDecorator;
import com.smartparking.domain.CarParking;

public class CarParkingTSpeakBuilder extends MapBuilder<CarParking> {
	
	public CarParkingTSpeakBuilder() {}
	
	public CarParkingTSpeakBuilder(MapDecorator<String> decorator) {
		super(decorator);
	}

	@Override
	public Map<String, ?> build(CarParking feed) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", String.valueOf(feed.getId()));
		map.put("field1", String.valueOf(feed.getTagValue()));
		if (decorator != null) {
			decorator.decorate(map);
		}
		return map;
	}

}
