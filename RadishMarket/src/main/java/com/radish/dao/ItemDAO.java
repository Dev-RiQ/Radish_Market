package com.radish.dao;

import java.util.ArrayList;
import java.util.HashMap;
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

	public ArrayList<Item> getLimitItemListByLimitWithOffset(int limit, int offset) {
		ArrayList<Item> itemList = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			Map<String, Object> params = new HashMap<>();
			params.put("limit", limit);
			params.put("offset", offset);
			itemList = (ArrayList) session.selectList("getLimitItemListByLimitWithOffset", params);
		} catch (Exception e) {
			System.out.println("getLimitItemListByLimitWithOffset fail");
			e.printStackTrace();
		}
		return itemList;
	}
}
