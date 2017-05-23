package com.smartparking.vo.thingspeak;

import java.util.Map;

import com.smartparking.vo.VO;

/**
 * Decorate a VO with the api key of ThingSpeak.
 * @author rafaelfdequeiroz
 *
 */
public class TSpeakApiKeyVODecorator implements VO {

	private static final long serialVersionUID = -638330977820622588L;

	private VO decorateVO;
	
	private String apiKey = "EXA9HEOBB27FV1HN";
	
	public TSpeakApiKeyVODecorator(VO decorateVO) {
		this.decorateVO = decorateVO;
	}
	
	@Override
	public Map<String, Object> parseToMap() {
		Map<String, Object> map = decorateVO.parseToMap();
		map.put("api_key", apiKey);
		return map;
	}

}
