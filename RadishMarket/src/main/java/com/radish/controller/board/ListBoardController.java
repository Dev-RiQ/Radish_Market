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
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goUrlWithAlert(response, "로그인 후 이용 가능합니다.", "login.do");
		}
//		int start = 0;
//		if(request.getParameter("start") != null)
//			start = Integer.parseInt(request.getParameter("start"));
//		request.setAttribute("start", start);
//		if(BoardDAO.getInstance().hasNextList(start))
//			request.setAttribute("hasNext", true);
//		
//		List<Board> list = null;
//		if(request.getParameter("filter") != null) {
//			int category_no = Integer.parseInt(request.getParameter("category_no"));
//			String user_dong = request.getParameter("user_dong");
//			int order_by = Integer.parseInt(request.getParameter("order_by"));
//			request.setAttribute("categoryNo", category_no);
//			request.setAttribute("userDong", user_dong);
//			request.setAttribute("order_by", order_by);
//			Filter filter = new Filter(start, category_no, user_dong, order_by);
//			String meet_no_str = request.getParameter("meet_no");
//			if(meet_no_str != null && meet_no_str.isBlank()) {
//				filter.setMeet_no(Integer.parseInt(meet_no_str));
//			}
//			list = BoardDAO.getInstance().getBoardListByNonMeetNoInFilter(filter);
//		}else {
//			list = BoardDAO.getInstance().getBoardListByNonMeetNo(start);
//		}
//		
//		request.setAttribute("boardList", list);
//		request.setAttribute("likeList", LikeDAO.getInstance().getLikeListByBoardList(list));
//		request.setAttribute("commentList", CommentDAO.getInstance().getCommentListByBoardList(list));
		request.setAttribute("categoryList", BoardCategoryDAO.getInstance().getAllBoardCategoryList());
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String logUserDong = UserDAO.getInstance().getAUserDongByUserNo(log);
		request.setAttribute("logUserDong", logUserDong);
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(logUserDong));
		
		return "board/boardList";
	}

}
