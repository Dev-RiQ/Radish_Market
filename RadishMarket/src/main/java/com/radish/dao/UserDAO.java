package com.radish.dao;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.User;

public class UserDAO {
	private static UserDAO instance;
	private UserDAO() {}
	public static UserDAO getInstance() {
		if(instance == null) instance = new UserDAO();
		return instance;
	}
	
	/** 
	 회원가입 SQL users 테이블 Insert
	 */
	public boolean userInsert(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("userInsert", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("userInsert fail");
			e.printStackTrace();
		}
		return action != 0;
	}
}
