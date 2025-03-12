package com.radish.dao;

public class MeetDAO {
	private static MeetDAO instance;
	private MeetDAO() {}
	public static MeetDAO getInstance() {
		if(instance == null) instance = new MeetDAO();
		return instance;
	}
}
