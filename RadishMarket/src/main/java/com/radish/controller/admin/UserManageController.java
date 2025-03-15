package com.radish.controller.admin;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserManageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("userList", UserDAO.getInstance().getAllUserList());
		return "admin/userManage";
	}

}
