package com.radish.controller.like;

import java.io.IOException;

import com.radish.dao.LikeDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Like;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertLikeController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		Like like = new Like(board_no, user_no);
		LikeDAO.getInstance().insertLike(like);
		return null;
	}

}
