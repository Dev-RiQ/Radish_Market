package com.radish.controller.ajax;

import java.io.IOException;

import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MainAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("log") == null) {
			String address = request.getParameter("address");
			String dong = request.getParameter("dong");
			request.getSession().setAttribute("address", address);
			request.getSession().setAttribute("dong", dong);
		}

		return null;
	}

}
