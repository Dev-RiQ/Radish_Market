package com.radish.controller.comment;

import java.io.IOException;

import com.radish.dao.CommentDAO;
import com.radish.frontController.Controller;
import com.radish.util.DateUtil;
import com.radish.vo.Comment;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertCommentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String comment_content = request.getParameter("comment_content");
		String comment_reg_datetime = DateUtil.getInstance().getRegDatetime();
		
		Comment comment = new Comment(board_no, user_no, comment_content, comment_reg_datetime);
		CommentDAO.getInstance().insertComment(comment);
		
		return null;
	}

}
