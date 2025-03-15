package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		if(user_id == null)
			return "user/userLogin";
		
		String user_pw = request.getParameter("user_pw");
		
		if(user_id.equals("admin") && user_pw.equals("admin")) {
			request.getSession().setAttribute("log", -1);
			AlertUtil.getInstance().goHomeWithAlert(response, "관리자님 로그인 성공 !");
		}
		
		int log = UserDAO.getInstance().isLoginSuccess(user_id, user_pw);
		if(log != 0) {
			request.getSession().setAttribute("log", log);
			AlertUtil.getInstance().goHomeWithAlert(response, user_id + "님 로그인 성공 !");
		}else {
			AlertUtil.getInstance().goBackWithAlert(response, "아이디 혹은 비밀번호를 확인해주세요.");
		}
		
		return null;
	}

}
