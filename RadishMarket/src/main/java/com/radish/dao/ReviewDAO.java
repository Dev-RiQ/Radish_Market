package com.radish.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.radish.util.DBUtil;
import com.radish.vo.Review;

public class ReviewDAO {
	private static ReviewDAO instance;
	private ReviewDAO() {}
	public static ReviewDAO getInstance() {
		if(instance == null) instance = new ReviewDAO();
		return instance;
	}
	public boolean insertAReview(Review review) {
		int action = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			action = session.insert("insertAReview", review);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertAReview fail");
			e.printStackTrace();
		}
		return action != 0;
	}
	public List<Review> getReviewListByUserNo(int sell_user_no) {
		List<Review> list = null;
		try (SqlSession session = DBUtil.getInstance().openSession()){
			list = session.selectList("getReviewListByUserNo", sell_user_no);
		} catch (Exception e) {
			System.out.println("getReviewListByUserNo fail");
			e.printStackTrace();
		}
		return list;
	}
	public int getReviewListSize(int sell_user_no) {
		int size = 0;
		try (SqlSession session = DBUtil.getInstance().openSession()) {
			size = session.selectOne("getReviewListSize", sell_user_no);
		} catch (Exception e) {
			System.out.println("getReviewListSize fail");
			e.printStackTrace();
		}
		return size;
	}
}
