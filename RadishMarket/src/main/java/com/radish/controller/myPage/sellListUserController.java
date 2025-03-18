package com.radish.controller.myPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.CartDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Cart;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class sellListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용해 주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(log));
		
		List<Item> itemList = ItemDAO.getInstance().getAllSellList(log);
		request.setAttribute("itemList", itemList);
		List<Integer> itemNoList = new ArrayList<>();
		for(Item item : itemList) {
			itemNoList.add(item.getItem_no());
		}
		request.setAttribute("mainImgList", ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList));
		
		List<Item> reserveItemList = ItemDAO.getInstance().getAllReserveItemList(log);
		request.setAttribute("reserveItemList", reserveItemList);
		List<Integer> reserveItemNoList = new ArrayList<>();
		for(Item reserveItem : reserveItemList) {
			reserveItemNoList.add(reserveItem.getItem_no());
		}
		request.setAttribute("mainReserveImgList", ItemImgDAO.getInstance().getItemImgListByItemList(reserveItemNoList));
		
		List<Item> soldItemList = ItemDAO.getInstance().getAllSoldList(log);
		request.setAttribute("soldItemList", soldItemList);
		List<Integer> soldItemNoList = new ArrayList<>();
		for(Item soldItem : reserveItemList) {
			soldItemNoList.add(soldItem.getItem_no());
		}
		request.setAttribute("mainReserveImgList", ItemImgDAO.getInstance().getItemImgListByItemList(soldItemNoList));

		return "myPage/userSellList";
	}

}
