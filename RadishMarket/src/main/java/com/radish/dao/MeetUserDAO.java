package com.radish.dao;

public class MeetUserDAO {
	private static MeetUserDAO instance;
	private MeetUserDAO() {}
	public static MeetUserDAO getInstance() {
		if(instance == null) instance = new MeetUserDAO();
		return instance;
	}
}
