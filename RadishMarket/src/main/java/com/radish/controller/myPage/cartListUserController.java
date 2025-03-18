package com.radish.controller.myPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.CartDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Cart;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class cartListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(user_no));
		
		List<Integer> buyItemNoList = CartDAO.getInstance().getBuyItemNoList(user_no);
		List<Item> itemList = ItemDAO.getInstance().getBuyItemList(buyItemNoList);
		request.setAttribute("itemList", itemList);
		
		return "myPage/userCartList";
	}

}
