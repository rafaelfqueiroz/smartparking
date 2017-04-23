package com.smartparking.builders;

import java.util.Map;

import com.smartparking.decorators.MapDecorator;
import com.smartparking.interfaces.Feed;

public abstract class MapBuilder<T extends Feed> {

	protected MapDecorator decorator;
	
	public MapBuilder() {}
	
	public MapBuilder(MapDecorator decorator) {
		this.decorator = decorator;
	}
	
	public abstract Map<String, ?> build(T feed);
}
