package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test_itemListUserController implements Controller {
	private static final int ITEMS_PER_PAGE = 30;

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("log") == null || request.getSession() == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}

		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));
		
		int itemTotalCnt = ItemDAO.getInstance().getTotalItemCnt();
		int limit = ITEMS_PER_PAGE;
		if (limit > itemTotalCnt) {
			limit = itemTotalCnt;
		}

		int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");

		request.setAttribute("itemList", ItemDAO.getInstance().getAUserAllItemListByUserNo(log , limit, offset));
		
		return "user/test_userItemList";
	}

}
