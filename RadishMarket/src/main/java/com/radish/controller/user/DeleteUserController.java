package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(UserDAO.getInstance().removeAUser(log))
			AlertUtil.getInstance().goHomeWithAlert(response, "회원 탈퇴 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "회원 탈퇴 실패");
		return null;
	}

}
