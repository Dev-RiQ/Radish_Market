package com.radish.dao;

public class CalendarDAO {
	private static CalendarDAO instance;
	private CalendarDAO() {}
	public static CalendarDAO getInstance() {
		if(instance == null) instance = new CalendarDAO();
		return instance;
	}
}
