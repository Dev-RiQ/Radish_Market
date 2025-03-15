package com.radish.controller.user;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test_boardListUserController implements Controller {
	private static final int ITEMS_PER_PAGE = 30;

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("log") == null || request.getSession() == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(log));
		
		int boardTotalCnt = BoardDAO.getInstance().getAUserTotalBoardCnt(log);
		int limit = ITEMS_PER_PAGE;
		if (limit > boardTotalCnt) {
			limit = boardTotalCnt;
		}
		int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");
		List<Board> list = BoardDAO.getInstance().getAllUserBoardListByUserNo(log, limit, offset);
		request.setAttribute("boardList", list);
		request.setAttribute("likeList", LikeDAO.getInstance().getLikeListByBoardList(list));
		request.setAttribute("commentList", CommentDAO.getInstance().getCommentListByBoardList(list));
		
		return "user/test_userBoardList";
	}

}
