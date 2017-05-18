package com.smartparking.vo.thingspeak;

import com.smartparking.domain.CarParking;
import com.smartparking.vo.CarParkingVO;

/**
 *  Representa um ValueObject (VO) para transferenecia de dados do carro contento a chave da api.
 * @author rafaelfdequeiroz
 */
public class TSpeakCarParkingVO extends CarParkingVO {

	private String apiKey;
	
	public TSpeakCarParkingVO() {}
	
	public TSpeakCarParkingVO(String tagValue) {
		super(tagValue);
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public static TSpeakCarParkingVO of(CarParking feed) {
		return new TSpeakCarParkingVO(feed.getTagValue()); 
	}
	
}
