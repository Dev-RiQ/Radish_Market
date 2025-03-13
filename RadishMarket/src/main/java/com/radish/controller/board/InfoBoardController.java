package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		BoardDAO.getInstance().boardHitsUp(board_no);
		Board board = BoardDAO.getInstance().getABoardByBoardNo(board_no);
		request.setAttribute("board", board);
		request.setAttribute("likeCount", BoardDAO.getInstance().getCountLikeByBoardNo(board_no));
		request.setAttribute("commentList", CommentDAO.getInstance().getCommentListByBoard(board_no));
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("isLike", BoardDAO.getInstance().isLikedInBoardNoByLog(board_no, log));
		return "board/boardInfo";
	}

}
