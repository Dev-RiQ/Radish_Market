package com.radish.controller.board;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Board;
import com.radish.vo.Comment;

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
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(board.getUser_no()));
		request.setAttribute("likeCount", LikeDAO.getInstance().getCountLikeByBoardNo(board_no));
		List<Comment> commentList = CommentDAO.getInstance().getCommentListByBoard(board_no);
		request.setAttribute("commentList", commentList);
		request.setAttribute("commentNickname", UserDAO.getInstance().getCommentedUserNickname(commentList));
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("isLike", LikeDAO.getInstance().isLikedInBoardNoByLog(board_no, log));
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		return "board/boardInfo";
	}

}
