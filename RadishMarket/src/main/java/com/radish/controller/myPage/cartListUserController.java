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
		List<Cart> cartList = CartDAO.getInstance().getCartList(user_no);
		List<Integer> itemNoList = new ArrayList<>();
		for(Cart cart : cartList)
			itemNoList.add(cart.getItem_no());
		List<Item> itemList = ItemDAO.getInstance().getAUserAllZzimItemList(itemNoList);
		request.setAttribute("cartList", cartList);
		request.setAttribute("itemList", itemList);
		request.setAttribute("mainImgList", ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList));

		return "myPage/userItemList";
	}

}
