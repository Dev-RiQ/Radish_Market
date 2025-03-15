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
	public String getABoardCategoryName(int board_category_no) {
		String name = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			name = session.selectOne("getABoardCategoryName", board_category_no);
		} catch (Exception e) {
			System.out.println("getABoardCategoryName fail");
			e.printStackTrace();
		}
		return name;
	}
	public boolean insertBoardCategory(String board_category_name) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.insert("insertBoardCategory", board_category_name);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertBoardCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateBoardCategory(BoardCategory boardCategory) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.update("updateBoardCategory", boardCategory);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateBoardCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteBoardCategory(int board_category_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action= session.delete("deleteBoardCategory", board_category_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteBoardCategory fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
