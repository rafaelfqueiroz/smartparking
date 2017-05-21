package com.smartparking.vo;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotVO implements VO {

	private static final long serialVersionUID = -1337638533409653999L;

	private Integer number;
	
	private Integer state;
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("number", number);
		map.put("state", state);
		return map;
	}

}
