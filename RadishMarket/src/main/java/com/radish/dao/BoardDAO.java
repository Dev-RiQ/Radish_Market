package com.radish.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.Filter;

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
	public List<Board> getBoardListByMeetNo(int meet_no) {
		List<Board> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getBoardListByMeetNo",meet_no);
		} catch (Exception e) {
			System.out.println("getBoardListByMeetNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<Board> getAllBoardList() {
		List<Board> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllBoardList");
		} catch (Exception e) {
			System.out.println("getAllBoardList fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<Board> getBoardListByNonMeetNoInFilter(Filter filter) {
		List<Board> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getBoardListByNonMeetNoInFilter",filter);
		} catch (Exception e) {
			System.out.println("getBoardListByNonMeetNoInFilter fail");
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Board> getAllUserBoardListByUserNo(int user_no, int limit, int offset) {
		List<Board> list = null;
		Map<String, Integer> param = new HashMap<>();
		param.put("user_no", user_no);
		param.put("limit", limit);
		param.put("offset", offset);
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getAllUserBoardListByUserNo",param);
		} catch (Exception e) {
			System.out.println("getAllUserBoardListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public int getAUserTotalBoardCnt(int user_no) {
		int cnt = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			cnt = session.selectOne("getAUserTotalBoardCnt", user_no);
		} catch (Exception e) {
			System.out.println("getAUserTotalBoardCnt fail");
			e.printStackTrace();
		}
		return cnt;
	}
	public int getBoardListSize(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			size = session.selectOne("getBoardListSize", user_no);
		} catch (Exception e) {
			System.out.println("getBoardListSize fail");
			e.printStackTrace();
		}
		return size;
	}
	public List<Board> getMeetBoardLimitList(int meet_no) {
		List<Board> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getMeetBoardLimitList", meet_no);
		} catch (Exception e) {
			System.out.println("getMeetBoardLimitList fail");
			e.printStackTrace();
		}
		return list;
	}
	public int getMeetBoardCount(int meet_no) {
		int count = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			count = session.selectOne("getMeetBoardCount", meet_no);
		} catch (Exception e) {
			System.out.println("getMeetBoardCount fail");
			e.printStackTrace();
		}
		return count;
	}
	
}
