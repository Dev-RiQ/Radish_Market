package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;

import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListItemController implements Controller {
	private static final int ITEMS_PER_PAGE = 30;

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		System.out.println("뭐지?");
		int itemTotalCnt = ItemDAO.getInstance().getTotalItemCnt();

		int limit = ITEMS_PER_PAGE;

		if (limit > itemTotalCnt) {
			limit = itemTotalCnt;
		}

		System.out.println("뭐임?");
		int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");

		ArrayList<Item> itemList = (ArrayList) ItemDAO.getInstance().getLimitItemListByLimitWithOffset(limit, offset);
		request.setAttribute("itemList", itemList);
		
		ArrayList<String> userDongList = UserDAO.getInstance().getLimitUserDongByItemList(itemList);
		request.setAttribute("userDongList", userDongList);
		return "item/itemList";
	}

}
