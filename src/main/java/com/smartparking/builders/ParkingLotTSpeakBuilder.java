package com.smartparking.builders;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.smartparking.decorators.MapDecorator;
import com.smartparking.domain.ParkingLot;

public class ParkingLotTSpeakBuilder extends MapBuilder<ParkingLot>{
	
	public ParkingLotTSpeakBuilder() {}
	
	public ParkingLotTSpeakBuilder(MapDecorator<String> decorator) {
		super(decorator);
	}

	@Override
	public Map<String, ?> build(ParkingLot feed) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", String.valueOf(feed.getId()));
		map.put("field1", String.valueOf(feed.getNumber()));
		map.put("field2", String.valueOf(feed.getState()));
		if (decorator != null) {
			decorator.decorate(map);
		}
		return map;
	}
	
	

}
