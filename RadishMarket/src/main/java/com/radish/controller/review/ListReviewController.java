package com.radish.controller.review;

import java.io.IOException;
import java.util.List;

import com.radish.dao.ReviewDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Review;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListReviewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_no = request.getParameter("user_no");
		int sell_user_no = Integer.parseInt(user_no);
		List<Review> reviewList = ReviewDAO.getInstance().getReviewListByUserNo(sell_user_no);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("buyUserInfo", UserDAO.getInstance().getReviewedUserList(reviewList));
		return "남이 보는 내 정보 리뷰 목록";
	}

}
