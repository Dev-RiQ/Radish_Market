package com.radish.dao;

public class BoardDAO {
	private static BoardDAO instance;
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
}
