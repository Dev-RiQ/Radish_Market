package com.radish.controller.myPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.ReviewDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.ZzimDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Item;
import com.radish.vo.ItemImg;
import com.radish.vo.Review;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class itemListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("log") == null || request.getSession() == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String user_no_str = request.getParameter("user_no");
		if(user_no_str != null) {
			log = Integer.parseInt(user_no_str);
		}
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));

		String sellListSize = "";
		int sellListSizeInt = ItemDAO.getInstance().getSellListSize(log);
		if(sellListSizeInt > 100) {
			sellListSize = "100+";
		}else {
			sellListSize = sellListSizeInt + "";
		}
		request.setAttribute("sellListSize", sellListSize);
		
		String reviewListSize = "";
		int reviewListSizeInt = ReviewDAO.getInstance().getReviewListSize(log);
		if(reviewListSizeInt > 100) {
			reviewListSize = "100+";
		}else {
			reviewListSize = reviewListSizeInt + "";
		}
		request.setAttribute("reviewListSize", reviewListSize);

		return "myPage/userItemList";
	}

}
