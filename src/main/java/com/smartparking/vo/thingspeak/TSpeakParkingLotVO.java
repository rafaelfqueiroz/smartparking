package com.smartparking.vo.thingspeak;

import java.util.Map;

import com.smartparking.domain.ParkingLot;
import com.smartparking.vo.ParkingLotVO;

public class TSpeakParkingLotVO extends ParkingLotVO {

	private static final long serialVersionUID = -7448559073067032191L;
	
	private String apiKey;
	
	public TSpeakParkingLotVO(Integer number, Integer state) {
		super(number, state);
	}
	
	
	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = super.parseToMap();
		map.put("field1", getNumber());
		map.put("field2", getState());
		map.put("api_key", apiKey);
		return map;
	}
}
