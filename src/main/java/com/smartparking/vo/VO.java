package com.smartparking.vo;

import java.io.Serializable;
import java.util.Map;

public interface VO extends Serializable {

	Map<String, Object> parseToMap();
}
