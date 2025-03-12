package com.radish.dao;

public class CommentDAO {
	private static CommentDAO instance;
	private CommentDAO() {}
	public static CommentDAO getInstance() {
		if(instance == null) instance = new CommentDAO();
		return instance;
	}
}
