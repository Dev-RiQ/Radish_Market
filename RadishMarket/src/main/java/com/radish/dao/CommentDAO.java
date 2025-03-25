package com.radish.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Board;
import com.radish.vo.Comment;

public class CommentDAO {
	private static CommentDAO instance;
	private CommentDAO() {}
	public static CommentDAO getInstance() {
		if(instance == null) instance = new CommentDAO();
		return instance;
	}
	public List<Integer> getCommentListByBoardList(List<Board> boardList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Board board : boardList) {
				int board_no = board.getBoard_no();
				list.add(session.selectOne("getCountCommentByBoardNo", board_no));
			}
		} catch (Exception e) {
			System.out.println("getCommentListByBoardList fail");
			e.printStackTrace();
		}
		return list;
	}
	public List<Comment> getCommentListByBoard(int board_no) {
		List<Comment> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getCommentListByBoard", board_no);
		} catch (Exception e) {
			System.out.println("getCommentListByBoard fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean insertComment(Comment comment) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertComment", comment);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertComment fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean deleteAComment(int comment_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteAComment", comment_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAComment fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public boolean updateAComment(Comment comment) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("updateAComment", comment);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateAComment fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Integer> getCommentListByBoardNoList(List<Integer> boardNoList) {
		List<Integer> list = new ArrayList<>();
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Integer board_no : boardNoList) {
			list.add(session.selectOne("getCommentListByBoardNoList", board_no));
			}
		} catch (Exception e) {
			System.out.println("getCommentListByBoardNoList fail");
			e.printStackTrace();
		}
		return list;
	}
}
