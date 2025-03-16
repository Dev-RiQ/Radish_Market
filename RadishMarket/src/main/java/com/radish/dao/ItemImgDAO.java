package com.radish.dao;

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
			System.out.println(cnt + "개의 이미지 삽입");
		} catch (Exception e) {
			System.out.println("insertItemImg fail");
			e.printStackTrace();
		}
		return cnt;
	}

}
