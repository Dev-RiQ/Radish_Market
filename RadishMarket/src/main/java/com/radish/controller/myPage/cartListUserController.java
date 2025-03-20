package com.radish.controller.myPage;

import java.io.IOException;

import com.radish.dao.CartDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class cartListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용해 주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		User user = UserDAO.getInstance().getAUserPortionInfo(log);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		int buyListSizeInt = CartDAO.getInstance().getBuyItemSize(log);
		String buyListSize = "";
		if(buyListSizeInt > 100) {
			buyListSize = "100+";
		}else {
			buyListSize = buyListSizeInt+"";
		}
		request.setAttribute("buyListSize", buyListSize);
		
		return "myPage/userCartList";
	}

}
