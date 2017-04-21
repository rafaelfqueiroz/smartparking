package com.smartparking.domain;

import com.smartparking.interfaces.Car;

public class CarParking implements Car{

	private static final long serialVersionUID = -2579237975586078331L;
	private Integer id;
	private Long tagValue;
	
	public CarParking() {}
	
	public CarParking(Integer id, Long tagValue) {
		this.id = id;
		this.tagValue = tagValue;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Long getTagValue() {
		return this.tagValue;
	}

	@Override
	public void setTagValue(Long tagValue) {
		this.tagValue = tagValue;
	}

}
