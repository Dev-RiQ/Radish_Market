package com.radish.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Item;

public class ItemDAO {
	private static ItemDAO instance;

	private ItemDAO() {
	}

	public static ItemDAO getInstance() {
		if (instance == null)
			instance = new ItemDAO();
		return instance;
	}

	public int getTotalItemCnt() {
		int itemTotalCnt = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			itemTotalCnt = session.selectOne("getTotalItemCnt");
		} catch (Exception e) {
			System.out.println("getTotalItemCnt fail");
			e.printStackTrace();
		}
		return itemTotalCnt;
	}

	public List<Item> getLimitItemListByLimitWithOffset(int limit, int offset) {
		List<Item> itemList = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			Map<String, Object> params = new HashMap<>();
			params.put("limit", limit);
			params.put("offset", offset);
			itemList = session.selectList("getLimitItemListByLimitWithOffset", params);
		} catch (Exception e) {
			System.out.println("getLimitItemListByLimitWithOffset fail");
			e.printStackTrace();
		}
		return itemList;
	}

	public Item getAItemByItemNo(int item_no) {
		Item item = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			item = session.selectOne("getAItemByItemNo", item_no);
		} catch (Exception e) {
			System.out.println("getAItemByItemNo fail");
			e.printStackTrace();
		}
		return item;
	}
	
	public void itemHitsUp(int item_no) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			int item_hits = session.selectOne("getItemHits", item_no);
			session.update("itemHitsUp", new Item(item_no, item_hits + 1));
			session.commit();
		} catch (Exception e) {
			System.out.println("itemHitsUp fail");
			e.printStackTrace();
		}
	}

	public List<Item> getAUserAllItemListByUserNo(int user_no, int limit, int offset) {
		List<Item> list = new ArrayList<>();
		Map<String, Integer> param = new HashMap<>();
		param.put("user_no", user_no);
		param.put("limit", limit);
		param.put("offset", offset);
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getAUserAllItemListByUserNo", param);
		} catch (Exception e) {
			System.out.println("getAUserAllItemListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<Item> getAllItemList() {
		List<Item> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getAllItemList");
		} catch (Exception e) {
			System.out.println("getAllItemList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<Item> getHotItemSortList() {
		List<Item> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getHotItemSortList");
		} catch (Exception e) {
			System.out.println("getHotItemSortList fail");
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertItem(Item item) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.insert("insertItem", item);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertItem fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public boolean deleteAItem(int item_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteAItem", item_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAItem fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public boolean updateItem(Item item) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("updateItem", item);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateItem fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public int getAUserAllItemListSizeByUserNo(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			size = session.selectOne("getAUserAllItemListSizeByUserNo", user_no);
		} catch (Exception e) {
			System.out.println("getAUserAllItemListSizeByUserNo fail");
			e.printStackTrace();
		}
		return size;
	}

	public List<Item> getAUserAllZzimItemList(List<Integer> itemNoList) {
		List<Item> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for(int item_no : itemNoList) {
				list.add(session.selectOne("getAUserAllZzimItemList", item_no));
			}
		} catch (Exception e) {
			System.out.println("getAUserAllZzimItemList fail");
			e.printStackTrace();
		}
		return list;
	}
	
	public int getLastItemNo() {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.selectOne("getLastItemNo");
		} catch (Exception e) {
			System.out.println("getLastItemNo fail");
			e.printStackTrace();
		}
		return action;
	}
}
