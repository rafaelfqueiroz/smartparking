package com.smartparking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.smartparking.interfaces.Car;

@Entity
@Table(name="car_parking")
public class CarParking implements Car {

	private static final long serialVersionUID = -2579237975586078331L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
