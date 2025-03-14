package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.BoardCategory;

public class BoardCategoryDAO {
	private static BoardCategoryDAO instance;
	private BoardCategoryDAO() {}
	public static BoardCategoryDAO getInstance() {
		if(instance == null) instance = new BoardCategoryDAO();
		return instance;
	}
	
	public List<BoardCategory> getAllBoardCategoryList() {
		List<BoardCategory> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllBoardCategoryList");
		} catch (Exception e) {
			System.out.println("getAllBoardCategoryList fail");
			e.printStackTrace();
		}
		return list;
	}
}
