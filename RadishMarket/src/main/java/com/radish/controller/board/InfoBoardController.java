package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		BoardDAO.getInstance().boardHitsUp(board_no);
		request.setAttribute("board", BoardDAO.getInstance().getABoardByBoardNo(board_no));
		return "board/boardInfo";
	}

}
