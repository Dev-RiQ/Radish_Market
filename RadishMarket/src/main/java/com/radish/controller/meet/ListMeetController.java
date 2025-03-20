package com.radish.controller.meet;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.MeetCategoryDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.DongUtil;
import com.radish.vo.MeetCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetController implements Controller {

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
		String order_by_str = request.getParameter("order_by");
		int order_by = 0;
		if(order_by_str != null)
			order_by = Integer.parseInt(order_by_str);
		String meet_no_str = request.getParameter("meet_no");
		int meet_no = 0;
		if(meet_no_str != null)
			meet_no = Integer.parseInt(meet_no_str);
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
		List<MeetCategory> categoryList = MeetCategoryDAO.getInstance().getAllMeetCategoryList();
		request.setAttribute("categoryNo", category_no);
		request.setAttribute("userDong", user_dong);
		request.setAttribute("order_by", order_by);
		request.setAttribute("meet_no", meet_no);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(gu, user_dong));
		return "meet/meetList";
	}

}
