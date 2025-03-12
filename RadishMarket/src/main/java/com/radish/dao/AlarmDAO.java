package com.radish.dao;

public class AlarmDAO {
	private static AlarmDAO instance;
	private AlarmDAO() {}
	public static AlarmDAO getInstance() {
		if(instance == null) instance = new AlarmDAO();
		return instance;
	}
}
