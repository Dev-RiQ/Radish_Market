package com.radish.dao;

public class LetterDAO {
	private static LetterDAO instance;
	private LetterDAO() {}
	public static LetterDAO getInstance() {
		if(instance == null) instance = new LetterDAO();
		return instance;
	}
}
