package com.radish.dao;

public class BoardCategoryDAO {
	private static BoardCategoryDAO instance;
	private BoardCategoryDAO() {}
	public static BoardCategoryDAO getInstance() {
		if(instance == null) instance = new BoardCategoryDAO();
		return instance;
	}
}
