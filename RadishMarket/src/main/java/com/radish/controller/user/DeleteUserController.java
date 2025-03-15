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
		String user_no = request.getParameter("user_no");
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(log == -1) {
			if(UserDAO.getInstance().deleteAUser(Integer.parseInt(user_no)))
				AlertUtil.getInstance().goUrlWithAlert(response, "회원 삭제 완료", "userManage.do");
			else
				AlertUtil.getInstance().goBackWithAlert(response, "회원 삭제 실패");
			return null;
		}
		
		if(UserDAO.getInstance().deleteAUser(log))
			AlertUtil.getInstance().goHomeWithAlert(response, "회원 탈퇴 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "회원 탈퇴 실패");
		return null;
	}

}
