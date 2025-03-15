package com.radish.controller.ajax;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserInsertAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		boolean check = UserDAO.getInstance().hasId(user_id);
		response.getWriter().print(check? "" : "valid");
		return null;
	}

}
