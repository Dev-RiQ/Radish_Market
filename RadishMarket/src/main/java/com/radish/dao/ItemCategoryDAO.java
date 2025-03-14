package com.radish.dao;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Item;

public class ItemCategoryDAO {
	private static ItemCategoryDAO instance;
	private ItemCategoryDAO() {}
	public static ItemCategoryDAO getInstance() {
		if(instance == null) instance = new ItemCategoryDAO();
		return instance;
	}
	
	public String getAitemCategoryNameByItemCategoryNo(int item_category_no) {
		String categoryName = "";
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			categoryName = session.selectOne("getAitemCategoryNameByItemCategoryNo", item_category_no);
		} catch (Exception e) {
			System.out.println("getAitemCategoryNameByItemCategoryNo fail");
			e.printStackTrace();
		}
		return categoryName;
	}
}
