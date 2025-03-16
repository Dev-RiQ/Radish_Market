package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test_mypageUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null || request.getSession() == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
			return null;
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));
		return "user/test_userMypage";
	}

}
