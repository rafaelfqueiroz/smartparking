package com.smartparking.vo.thingspeak;

import java.util.HashMap;
import java.util.Map;

import com.smartparking.vo.CarVO;

/**
 *  Representa um ValueObject (VO) para transferenecia de dados do carro contento a chave da api.
 * @author rafaelfdequeiroz
 */
public class TSpeakCarParkingVO extends CarVO {

	private static final long serialVersionUID = -752564064267374059L;

	public TSpeakCarParkingVO() {}
	
	public TSpeakCarParkingVO(String tagValue) {
		super(tagValue);
	}

	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("field1", getTagValue());
		return map;
	}
	
}
