package com.radish.controller.board;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Board;

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
		int start = 0;
		if(request.getParameter("start") != null)
			start = Integer.parseInt(request.getParameter("start"));
		request.setAttribute("start", start);
		if(BoardDAO.getInstance().hasNextList(start))
			request.setAttribute("hasNext", true);
		List<Board> list = BoardDAO.getInstance().getBoardListByNonMeetNo(start);
		request.setAttribute("boardList", list);
		request.setAttribute("likeList", BoardDAO.getInstance().getLikeListByBoardList(list));
		request.setAttribute("commentList", CommentDAO.getInstance().getCommentListByBoardList(list));
		return "board/boardList";
	}

}
