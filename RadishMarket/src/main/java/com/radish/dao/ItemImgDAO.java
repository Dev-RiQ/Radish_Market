package com.radish.dao;

public class ItemImgDAO {
	private static ItemImgDAO instance;
	private ItemImgDAO() {}
	public static ItemImgDAO getInstance() {
		if(instance == null) instance = new ItemImgDAO();
		return instance;
	}
}
