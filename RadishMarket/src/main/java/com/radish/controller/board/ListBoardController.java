package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int limit = 0;
		if(request.getParameter("lastIndex") != null)
			limit = Integer.parseInt(request.getParameter("lastIndex"));
		request.setAttribute("boardList", BoardDAO.getInstance().getBoardList(limit));
		return "board/boardList";
	}

}
