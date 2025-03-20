package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.DongUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String category_no_str = request.getParameter("category_no");
		int category_no = 0;
		if(category_no_str != null)
			category_no = Integer.parseInt(category_no_str);
		String user_dong = request.getParameter("dong");
		if(user_dong == null)
			user_dong = request.getParameter("meet_dong");
		String gu = null;
		request.setAttribute("categoryList", BoardCategoryDAO.getInstance().getAllBoardCategoryList());
		Object log_obj = request.getSession().getAttribute("log");
		if(log_obj != null && user_dong == null) {
			int log = Integer.parseInt(log_obj.toString());
			user_dong = UserDAO.getInstance().getAUserDongByUserNo(log);
			gu = UserDAO.getInstance().getAUserByLog(log).getUser_gu();
		}
		Object dong = request.getSession().getAttribute("dong");
		if(dong != null && user_dong == null) {
			user_dong = dong.toString();
		}
		if(gu == null)
			gu = request.getSession().getAttribute("gu").toString();
		request.setAttribute("categoryNo", category_no);
		request.setAttribute("userDong", user_dong);
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(gu, user_dong));
		
		return "board/boardList";
	}

}
