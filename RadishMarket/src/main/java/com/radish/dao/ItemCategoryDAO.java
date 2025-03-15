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
	public boolean insertItemCategory(String item_category_name) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.insert("insertItemCategory", item_category_name);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertItemCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateItemCategory(ItemCategory itemCategory) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.update("updateItemCategory", itemCategory);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateItemCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteItemCategory(int item_category_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.delete("deleteItemCategory", item_category_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteItemCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
