package com.radish.dao;

public class ItemDAO {
	private static ItemDAO instance;
	private ItemDAO() {}
	public static ItemDAO getInstance() {
		if(instance == null) instance = new ItemDAO();
		return instance;
	}
}
