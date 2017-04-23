package com.smartparking.decorators;

import java.util.Map;

public interface MapDecorator<T> {

	void decorate(Map<String, T> map);
}
