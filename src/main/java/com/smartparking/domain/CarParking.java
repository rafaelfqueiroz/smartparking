package com.smartparking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="car_parking")
public class CarParking implements Feed {

	private static final long serialVersionUID = -2579237975586078331L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String tagValue;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private User user;
	
	public CarParking() {}
	
	public CarParking(String tagValue) {
		this.tagValue = tagValue;
	}
	
	public CarParking(String tagValue, User user) {
		this.tagValue = tagValue;
		this.user = user;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagValue() {
		return this.tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
