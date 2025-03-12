package com.radish.dao;

public class MeetJoinDAO {
	private static MeetJoinDAO instance;
	private MeetJoinDAO() {}
	public static MeetJoinDAO getInstance() {
		if(instance == null) instance = new MeetJoinDAO();
		return instance;
	}
}
