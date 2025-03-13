package com.radish.dao;

public class MeetCategoryDAO {
	private static MeetCategoryDAO instance;
	private MeetCategoryDAO() {}
	public static MeetCategoryDAO getInstance() {
		if(instance == null) instance = new MeetCategoryDAO();
		return instance;
	}
}
