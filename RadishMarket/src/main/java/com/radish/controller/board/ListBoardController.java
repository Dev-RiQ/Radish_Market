package com.radish.controller.board;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DongUtil;
import com.radish.vo.Board;
import com.radish.vo.Filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String category_no_str = request.getParameter("category_no");
		int category_no = 0;
		if (category_no_str != null) {
			category_no = Integer.parseInt(category_no_str);
		}
		String user_dong = request.getSession().getAttribute("dong").toString();
		String meet_dong = request.getParameter("meet_dong");
		String order_by_str = request.getParameter("order_by");
		int order_by = 0;
		if (order_by_str != null)
			order_by = Integer.parseInt(order_by_str);
		String meet_no_str = request.getParameter("meet_no");
		int meet_no = 0;
		if (meet_no_str != null)
			meet_no = Integer.parseInt(meet_no_str);
		request.setAttribute("categoryNo", category_no);
		request.setAttribute("userDong", meet_dong == null ? user_dong : meet_dong);
		request.setAttribute("order_by", order_by);
		request.setAttribute("meet_no", meet_no);

		request.setAttribute("categoryList", BoardCategoryDAO.getInstance().getAllBoardCategoryList());
		Object log_obj = request.getSession().getAttribute("log");
		String logUserDong = request.getParameter("dong");
		if (log_obj != null) {
			int log = Integer.parseInt(log_obj.toString());
			logUserDong = UserDAO.getInstance().getAUserDongByUserNo(log);
			request.setAttribute("logUserDong", logUserDong);
		}
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(logUserDong));

		return "board/boardList";
	}

}
