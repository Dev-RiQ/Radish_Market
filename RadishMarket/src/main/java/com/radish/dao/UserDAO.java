package com.radish.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Item;
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
	
	public int isLoginSuccess(String user_id, String user_pw) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.selectOne("isLoginSuccess", new User(user_id,user_pw));
		} catch (Exception e) {
			System.out.println("isLoginSuccess fail");
			e.printStackTrace();
		}
		return action;
	}
	
	public User getAUserByLog(int log) {
		User action = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.selectOne("getAUserByLog", log);
		} catch (Exception e) {
			System.out.println("getAUserByLog fail");
			e.printStackTrace();
		}
		return action;
	}
	
	public boolean userUpdate(User user) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.update("userUpdate", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("userUpdate fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public boolean deleteAUser(int log) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.delete("deleteAUser", log);
			session.commit();
		} catch (Exception e) {
			System.out.println("deleteAUser fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	
	public ArrayList<String> getLimitUserDongByItemList(ArrayList<Item> itemList) {
		ArrayList<String> userDongList = new ArrayList<>();
		int user_no = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			for(Item item : itemList) {
				user_no = item.getUser_no();
				userDongList.add(session.selectOne("getLimitUserDongByItemList", item));
			}
		} catch (Exception e) {
			System.out.println("getLimitUserDongByItemList fail");
			e.printStackTrace();
		}
		return userDongList;
	}
}
