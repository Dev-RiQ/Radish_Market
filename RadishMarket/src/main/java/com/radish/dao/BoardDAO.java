package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.BoardCategory;
import com.radish.vo.Like;

public class BoardDAO {
	private static BoardDAO instance;
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
	public List<Board> getBoardListByNonMeetNo(int start) {
		List<Board> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getBoardListByNonMeetNo",start);
		} catch (Exception e) {
			System.out.println("getBoardListByNonMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public Board getABoardByBoardNo(int board_no) {
		Board board = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			board = session.selectOne("getABoardByBoardNo",board_no);
		} catch (Exception e) {
			System.out.println("getABoardByBoardNo fail");
			e.printStackTrace();
		}
		return board;
	}
	public boolean boardInsert(Board board) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("boardInsert",board);
			session.commit();
		} catch (Exception e) {
			System.out.println("boardInsert fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public int getLastBoardNo() {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.selectOne("getLastBoardNo");
		} catch (Exception e) {
			System.out.println("getLastBoardNo fail");
			e.printStackTrace();
		}
		return action;
	}
	
	public void boardHitsUp(int board_no) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			int board_hits = session.selectOne("getBoardHits", board_no);
			session.update("boardHitsUp", new Board(board_no, board_hits + 1));
			session.commit();
		} catch (Exception e) {
			System.out.println("boardHitsUp fail");
			e.printStackTrace();
		}
	}
	
	public boolean boardUpdate(Board board) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("boardUpdate", board);
			session.commit();
		} catch (Exception e) {
			System.out.println("boardUpdate fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public boolean deleteABoard(int board_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteABoard", board_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteABoard fail");
			e.printStackTrace();
		}
		return action != 0;
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
	public boolean hasNextList(int start) {
		try (SqlSession session = DBUtil.getInstance().openSession()){
			start += 30;
			if(session.selectOne("getCountBoardListByNonMeetNo", start) != null)
				return true;
		} catch (Exception e) {
			System.out.println("getCountBoardListByNonMeetNo fail");
			e.printStackTrace();
		}
		return false;
	}
	public List<Integer> getLikeListByBoardList(List<Board> boardList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Board board : boardList) {
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
		try (SqlSession session = DBUtil.getInstance().openSession()){
			count = session.selectOne("getCountLikeByBoardNo", board_no);
		} catch (Exception e) {
			System.out.println("getCountLikeByBoardNo fail");
			e.printStackTrace();
		}
		return count;
	}
	public int isLikedInBoardNoByLog(int board_no, int log) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			count = session.selectOne("isLikedInBoardNoByLog", new Like(board_no, log));
		} catch (Exception e) {
			System.out.println("isLikedInBoardNoByLog fail");
			e.printStackTrace();
		}
		return count;
	}
	public boolean hasLike(Like like) {
		
		return false;
	}
	public boolean insertLike(Like like) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
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
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("deleteLike", like);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteLike fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
