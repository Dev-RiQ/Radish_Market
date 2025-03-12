package com.radish.dao;

public class UserDAO {
	private static UserDAO instance;
	private UserDAO() {}
	public static UserDAO getInstance() {
		if(instance == null) instance = new UserDAO();
		return instance;
	}
}
