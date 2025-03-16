package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test_userPageUserController implements Controller {
	private static final int ITEMS_PER_PAGE = 30;

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(user_no));
		
		int itemTotalCnt = ItemDAO.getInstance().getTotalItemCnt();
		int limit = ITEMS_PER_PAGE;
		if (limit > itemTotalCnt) {
			limit = itemTotalCnt;
		}

		int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");
		request.setAttribute("itemList", ItemDAO.getInstance().getAUserAllItemListByUserNo(user_no , limit, offset));
		
		return "user/test_userItemList";
	}

}