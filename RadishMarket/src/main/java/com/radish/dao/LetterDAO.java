package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Letter;

public class LetterDAO {
	private static LetterDAO instance;
	private LetterDAO() {}
	public static LetterDAO getInstance() {
		if(instance == null) instance = new LetterDAO();
		return instance;
	}
	public boolean insertALetter(Letter letter) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertALetter", letter);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertALetter fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Letter> getLetterListByUserNo(int receive_user_no) {
		List<Letter> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getLetterListByUserNo", receive_user_no);
		} catch (Exception e) {
			System.out.println("getLetterListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public boolean deleteALetterByLetterNo(int letter_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteALetterByLetterNo", letter_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteALetterByLetterNo fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public Letter getALetter(int letter_no) {
		Letter letter = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			letter = session.selectOne("getALetter", letter_no);
		} catch (Exception e) {
			System.out.println("getALetter fail");
			e.printStackTrace();
		}
		return letter;
	}
	public boolean setCheck(int letter_no) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("setCheck", letter_no);
			session.commit();
		} catch (Exception e) {
			System.out.println("setCheck fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public int getReceveListSize(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			size = session.selectOne("getReceveListSize", user_no);
		} catch (Exception e) {
			System.out.println("getReceveListSize fail");
			e.printStackTrace();
		}
		return size;
	}
	public int getSendListSize(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			size = session.selectOne("getSendListSize", user_no);
		} catch (Exception e) {
			System.out.println("getSendListSize fail");
			e.printStackTrace();
		}
		return size;
	}
}
