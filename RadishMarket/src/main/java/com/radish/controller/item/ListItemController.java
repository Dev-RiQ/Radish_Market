package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.DongUtil;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object log_str = request.getSession().getAttribute("log");
		int log = 0;
		String dong = request.getParameter("dong");
		if(log_str != null) {
			log = Integer.parseInt(log_str.toString());
			request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));
			dong = UserDAO.getInstance().getAUserDongByUserNo(log);
			
		}
		
		request.setAttribute("categoryList", BoardCategoryDAO.getInstance().getAllBoardCategoryList());
		request.setAttribute("logUserDong", dong);
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(dong));
		
		return "item/itemList";
	}

}
