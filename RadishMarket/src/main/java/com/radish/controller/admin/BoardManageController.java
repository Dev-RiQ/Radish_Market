package com.radish.controller.admin;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardManageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("boardList", BoardDAO.getInstance().getAllBoardList());
		return "admin/boardManage";
	}

}
