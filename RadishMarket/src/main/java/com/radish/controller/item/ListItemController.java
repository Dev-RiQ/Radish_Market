package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		int itemTotalCnt = ItemDAO.getInstance().getTotalItemCnt();

		int limit = ITEMS_PER_PAGE;

		if (limit > itemTotalCnt) {
			limit = itemTotalCnt;
		}

		int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");

		List<Item> itemList = ItemDAO.getInstance().getLimitItemListByLimitWithOffset(limit, offset);
		request.setAttribute("itemList", itemList);
		
		List<String> userDongList = UserDAO.getInstance().getLimitUserDongByItemList(itemList);
		request.setAttribute("userDongList", userDongList);
		return "item/itemList";
	}

}
