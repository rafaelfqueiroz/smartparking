package com.smartparking.vo;

import java.util.HashMap;
import java.util.Map;

public class CarVO implements VO {

	private static final long serialVersionUID = -2759988804162040146L;
	
	private String tagValue;
	
	public CarVO() {}
	
	public CarVO(String tagValue) {
		this.tagValue = tagValue;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	
	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("tagValue", tagValue);
		return map;
	}
	
}
