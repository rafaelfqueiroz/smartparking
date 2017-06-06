package com.smartparking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.smartparking.enums.StateTypes;

@Entity
@Table(name="parking_lot")
public class ParkingLot implements Feed {
	
	private static final long serialVersionUID = -7878268966987387608L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer number;
	private boolean active;
	
	/**
	 * 0 - FREE
	 * 1 - RESERVED
	 * 2 - OCCUPIED
	 * @see StateTypes
	 */
	private Integer state;
	
	public ParkingLot() {}
	
	public ParkingLot(Integer number, Integer state) {
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
	
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
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
	
	public boolean isFree() {
		return getState() == StateTypes.FREE.ordinal();
	}
	
	public boolean isReserved() {
		return getState() == StateTypes.RESERVED.ordinal();
	}
	
	public boolean isOccupied() {
		return getState() == StateTypes.OCCUPIED.ordinal();
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
