package com.smartparking.vo;

public class CarParkingVO implements VO {

	private String tagValue;
	
	public CarParkingVO() {}
	
	public CarParkingVO(String tagValue) {
		this.tagValue = tagValue;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}
	
}
