package com.radish.dao;

public class AlramDAO {
	private static AlramDAO instance;
	private AlramDAO() {}
	public static AlramDAO getInstance() {
		if(instance == null) instance = new AlramDAO();
		return instance;
	}
}
