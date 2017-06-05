package com.smartparking.domain;

import java.io.Serializable;

public interface Feed extends Serializable{
	
	Integer getId();
	void setId(Integer id);
	
	boolean isActive();
	void setActive(boolean active);
	
}
