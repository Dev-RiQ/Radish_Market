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
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));

		List<Item> itemList = ItemDAO.getInstance().getAllSellList(log);
		request.setAttribute("itemList", itemList);

		List<Integer> itemNoList = new ArrayList<>();
		for (Item itemNo : itemList) {
			itemNoList.add(itemNo.getItem_no());
		}

		List<String> mainImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("mainImgList", mainImgList);

		List<Integer> zzimCountList = ZzimDAO.getInstance().getZzimCountListByItemNoList(itemNoList);
		request.setAttribute("zzimCountList", zzimCountList);

		List<Review> reviewList = ReviewDAO.getInstance().getReviewListByUserNo(log);
		request.setAttribute("reviewList", reviewList);
		
		List<String> itemImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("itemImgList", itemImgList);
		// 구매 확정 지난 시간 표기해야함
		
		if (reviewList != null) {
			List<Integer> buyUserNoList = new ArrayList<>();
			for (Review review : reviewList) {
				buyUserNoList.add(review.getBuy_user_no());
			}
			List<User> buyUserInfoList = UserDAO.getInstance().getCartUserList(buyUserNoList);
			request.setAttribute("buyUserInfoList", buyUserInfoList);
		}

		return "myPage/userItemList";
	}

}
