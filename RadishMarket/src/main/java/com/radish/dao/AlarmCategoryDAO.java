package com.radish.dao;

public class AlarmCategoryDAO {
	private static AlarmCategoryDAO instance;
	private AlarmCategoryDAO() {}
	public static AlarmCategoryDAO getInstance() {
		if(instance == null) instance = new AlarmCategoryDAO();
		return instance;
	}
}
