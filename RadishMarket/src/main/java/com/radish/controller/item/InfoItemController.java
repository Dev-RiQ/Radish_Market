package com.radish.controller.item;

import java.io.IOException;
import java.util.List;

import com.radish.dao.ItemCategoryDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.ZzimDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		Item item = ItemDAO.getInstance().getAItemByItemNo(item_no);
		request.setAttribute("item", item);
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(item.getUser_no()));
		request.setAttribute("zzimCount", ZzimDAO.getInstance().getCountZzimByItemNo(item_no));
		ItemDAO.getInstance().itemHitsUp(item_no);
		
		List<Item> itemList = ItemDAO.getInstance().getAuserAllItemListByUserNo(item.getUser_no());
		request.setAttribute("itemList", itemList);
		
		int item_category_no = item.getItem_category_no();
		request.setAttribute("categoryName", ItemCategoryDAO.getInstance().getAitemCategoryName(item_category_no));
		
		List<Item> hotItemSortList = ItemDAO.getInstance().getHotItemSortList();
		request.setAttribute("hotItemSortList", hotItemSortList);
		
		List<String> hotUserNicknameList = UserDAO.getInstance().getHotItemSortUserNicknameList(hotItemSortList);
		request.setAttribute("hotUserNicknameList", hotUserNicknameList);
		return "item/itemInfo";
	}

}
