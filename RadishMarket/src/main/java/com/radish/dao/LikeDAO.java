package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.Like;

public class LikeDAO {
	private static LikeDAO instance;

	private LikeDAO() {
	}

	public static LikeDAO getInstance() {
		if (instance == null)
			instance = new LikeDAO();
		return instance;
	}

	public List<Integer> getLikeListByBoardList(List<Board> boardList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Board board : boardList) {
				int board_no = board.getBoard_no();
				list.add(session.selectOne("getCountLikeByBoardNo", board_no));
			}
		} catch (Exception e) {
			System.out.println("getLikeListByBoardList fail");
			e.printStackTrace();
		}
		return list;
	}

	public int getCountLikeByBoardNo(int board_no) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			count = session.selectOne("getCountLikeByBoardNo", board_no);
		} catch (Exception e) {
			System.out.println("getCountLikeByBoardNo fail");
			e.printStackTrace();
		}
		return count;
	}

	public int isLikedInBoardNoByLog(int board_no, int log) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			count = session.selectOne("isLikedInBoardNoByLog", new Like(board_no, log));
		} catch (Exception e) {
			System.out.println("isLikedInBoardNoByLog fail");
			e.printStackTrace();
		}
		return count;
	}

	public boolean insertLike(Like like) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.insert("insertLike", like);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertLike fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public boolean deleteLike(Like like) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.insert("deleteLike", like);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteLike fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public List<Integer> getCountLikeByBoardNoList(List<Integer> boardNoList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			for (Integer board_no : boardNoList) {
				list.add(session.selectOne("getCountLikeByBoardNoList", board_no));
			}
		} catch (Exception e) {
			System.out.println("getCountLikeByBoardNoList fail");
			e.printStackTrace();
		}
		return list;
	}
}
