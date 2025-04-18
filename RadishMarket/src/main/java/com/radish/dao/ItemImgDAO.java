package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.ItemImg;

public class ItemImgDAO {
	private static ItemImgDAO instance;

	private ItemImgDAO() {
	}

	public static ItemImgDAO getInstance() {
		if (instance == null)
			instance = new ItemImgDAO();
		return instance;
	}

	public int insertItemImg(List<ItemImg> list) {
		int cnt = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (ItemImg itemImg : list) {
				cnt += session.insert("insertItemImg", itemImg);
				session.commit();
			}
		} catch (Exception e) {
			System.out.println("insertItemImg fail");
			e.printStackTrace();
		}
		return cnt;
	}

	public List<String> getItemImgListByItemList(List<Integer> itemNoList) {
		List<String> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer item_no : itemNoList) {
				list.add(session.selectOne("getItemImgListByItemList", item_no));
			}
		} catch (Exception e) {
			System.out.println("getItemImgListByItemList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> getAllItemImgList(int item_no) {
		List<String> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getAllItemImgList", item_no);
		} catch (Exception e) {
			System.out.println("getAllItemImgList fail");
			e.printStackTrace();
		}
		return list;
	}

	public Boolean deleteItemImg(int item_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.delete("deleteItemImg", item_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteItemImg fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public String getAItemImg(int item_no) {
		String action = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.selectOne("getAItemImg", item_no);
		} catch (Exception e) {
			System.out.println("getAItemImg fail");
			e.printStackTrace();
		}
		return action;
	}

}
