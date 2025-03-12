package com.radish.dao;

public class ReviewDAO {
	private static ReviewDAO instance;
	private ReviewDAO() {}
	public static ReviewDAO getInstance() {
		if(instance == null) instance = new ReviewDAO();
		return instance;
	}
}
