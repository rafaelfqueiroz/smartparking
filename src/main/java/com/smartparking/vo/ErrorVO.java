package com.smartparking.vo;

import java.util.HashMap;
import java.util.Map;

public class ErrorVO implements VO {

	private static final long serialVersionUID = 5026629646574167471L;

	private String error;
	
	public ErrorVO() {}
	
	public ErrorVO(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", error);
		return map;
	}
}
