package com.radish.controller.myPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Item;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class userPageUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		User user = UserDAO.getInstance().getAUserPortionInfo(user_no);
		request.setAttribute("user", user);
		
		
		List<Item> itemList = ItemDAO.getInstance().getAllSellList(user_no);
		request.setAttribute("itemList", itemList);
		List<Integer> itemNoList = new ArrayList<>();
		for(Item item : itemList) {
			itemNoList.add(item.getItem_no());
		}
		List<String> mainImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("mainImgList", mainImgList);
		request.setAttribute("user_dong", user.getUser_dong());
		System.out.println("우저 동 안나오냐: " + user.getUser_dong());
		
		
		return "myPage/userItemList";
	}

}