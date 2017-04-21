package com.smartparking.domain;

import com.smartparking.interfaces.Feed;

public class ParkingLot implements Feed {
	
	private static final long serialVersionUID = -7878268966987387608L;
	private Integer id;
	private Integer number;
	private Boolean state;
	
	public ParkingLot(Integer number, Boolean state) {
		this.number = number;
		this.state = state;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Boolean getState() {
		return this.state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingLot other = (ParkingLot) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}
	
	
	
}
