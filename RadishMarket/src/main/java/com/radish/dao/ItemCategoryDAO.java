package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.ItemCategory;

public class ItemCategoryDAO {
	private static ItemCategoryDAO instance;
	private ItemCategoryDAO() {}
	public static ItemCategoryDAO getInstance() {
		if(instance == null) instance = new ItemCategoryDAO();
		return instance;
	}
	
	public String getAitemCategoryName(int item_category_no) {
		String categoryName = "";
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			categoryName = session.selectOne("getAitemCategoryNameByItemCategoryNo", item_category_no);
		} catch (Exception e) {
			System.out.println("getAitemCategoryNameByItemCategoryNo fail");
			e.printStackTrace();
		}
		return categoryName;
	}
	
	public List<ItemCategory> getAllItemCategoryList() {
        List<ItemCategory> list = null;
        try (SqlSession session = DBUtil.getInstance().openSession()){
            list = session.selectList("getAllItemCategoryList");
        } catch (Exception e) {
            System.out.println("getAllItemCategoryList fail");
            e.printStackTrace();
        }
        return list;
    }
}
