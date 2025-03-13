package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		int user_age = Integer.parseInt(request.getParameter("user_age"));
		String user_email = request.getParameter("user_email");
		String user_nickname = request.getParameter("user_nickname");
		String user_address = request.getParameter("user_address");
		String user_img = request.getParameter("user_img");
		String user_phone = request.getParameter("user_phone");
		String user_reg_datetime = DateUtil.getInstance().getRegDatetime();
		String user_dir_x = request.getParameter("user_dir_x");
		String user_dir_y = request.getParameter("user_dir_y");
		String user_city = request.getParameter("user_city");
		String user_gu = request.getParameter("user_gu");
		String user_dong = request.getParameter("user_dong");
		int user_deg = 36;
		
		User user = new User(user_id, user_pw, user_name, user_age, user_email, user_nickname, user_address, user_img, user_phone, user_reg_datetime, user_dir_x, user_dir_y, user_city, user_gu, user_dong, user_deg);
		if(UserDAO.getInstance().userInsert(user))
			AlertUtil.getInstance().goUrlWithAlert(response, request, user_nickname + "님 가입을 환영합니다 !\\n로그인 페이지로 이동합니다.", "userLogin.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 가입에 실패했습니다.\\n다시 시도해주세요.");
		request.setAttribute("user", user);
		return "user/test_userInfo";
	}

}
