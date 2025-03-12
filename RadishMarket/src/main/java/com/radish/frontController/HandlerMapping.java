package com.radish.frontController;

import java.util.HashMap;


public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
