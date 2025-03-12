package com.radish.frontController;

import java.util.HashMap;

import com.radish.controller.user.InsertUserController;


public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUser.do", new InsertUserController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
