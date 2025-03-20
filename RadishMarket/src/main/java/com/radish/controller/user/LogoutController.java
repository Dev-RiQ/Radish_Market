package com.radish.controller.user;

import java.io.IOException;

import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("log");
		request.getSession().removeAttribute("address");
		request.getSession().removeAttribute("gu");
		request.getSession().removeAttribute("dong");
		AlertUtil.getInstance().goHomeWithAlert(response, "로그아웃 성공 !");
		return null;
	}

}
