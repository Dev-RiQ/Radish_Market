package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
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

		if(request.getSession() != null && request.getSession().getAttribute("log") != null) {
			int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
			request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));
		}
		
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
		
		List<Integer> itemNoList = new ArrayList<>();
		for(Item item : itemList) {
			itemNoList.add(item.getItem_no());
		}
		
		List<String> mainImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("mainImgList", mainImgList);
		
		return "item/itemList";
	}

}
