package com.radish.dao;

public class ItemCategoryDAO {
	private static ItemCategoryDAO instance;
	private ItemCategoryDAO() {}
	public static ItemCategoryDAO getInstance() {
		if(instance == null) instance = new ItemCategoryDAO();
		return instance;
	}
}
