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
}
