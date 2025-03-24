

package com.radish.controller.myPage;

import java.io.IOException;

import com.radish.dao.EmojiDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

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
		
		User user = UserDAO.getInstance().getAUserPortionInfo(log);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		int sellListSizeInt = ItemDAO.getInstance().getSellListSize(log);
		String sellListSize = "";
		if(sellListSizeInt > 100) {
			sellListSize = "100+";
		}else {
			sellListSize = sellListSizeInt+"";
		}
		request.setAttribute("sellListSize", sellListSize);
		
		int reserveListSizeInt = ItemDAO.getInstance().getReserveListSize(log);
		String reserveListSize = "";
		if(reserveListSizeInt > 100) {
			reserveListSize = "100+";
		}else {
			reserveListSize = reserveListSizeInt+"";
		}
		request.setAttribute("reserveListSize", reserveListSize);
		
		int soldListSizeInt = ItemDAO.getInstance().getSoldListSize(log);
		String soldListSize = "";
		if(soldListSizeInt > 100) {
			soldListSize = "100+";
		}else {
			soldListSize = soldListSizeInt+"";
		}
		request.setAttribute("soldListSize", soldListSize);
		
		return "myPage/userSellList";
	}

}
