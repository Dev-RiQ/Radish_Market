package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Cart;

public class CartDAO {
	private static CartDAO instance;

	private CartDAO() {
	}

	public static CartDAO getInstance() {
		if (instance == null)
			instance = new CartDAO();
		return instance;
	}

	public List<Cart> getCartList(int user_no) {
		List<Cart> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getCartList", user_no);
		} catch (Exception e) {
			System.out.println("getCartList fail");
			e.printStackTrace();
		}
		return list;
	}

	public boolean cartInsert(Cart cart) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.insert("cartInsert", cart);
			session.commit();
		} catch (Exception e) {
			System.out.println("cartInsert fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public boolean setCheckReviewed(Cart cart) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			action = session.update("setCheckReviewed", cart);
			session.commit();
		} catch (Exception e) {
			System.out.println("setCheckReviewed fail");
			e.printStackTrace();
		}
		return action != 0;
	}

	public List<Integer> getBuyItemNoList(int user_no) {
		List<Integer> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getBuyItemNoList", user_no);
		} catch (Exception e) {
			System.out.println("getBuyItemNoList fail");
			e.printStackTrace();
		}
		return list;
	}

	public List<Cart> getUserCartList(int user_no) {
		List<Cart> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			list = session.selectList("getUserCartList", user_no);
		} catch (Exception e) {
			System.out.println("getUserCartList fail");
			e.printStackTrace();
		}
		return list;
	}

	public int getBuyItemSize(int user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			size = session.selectOne("getBuyItemSize", user_no);
		} catch (Exception e) {
			System.out.println("getBuyItemSize fail");
			e.printStackTrace();
		}
		return size;
	}

}
