package com.radish.controller.user;

import java.io.IOException;

import com.radish.dao.EmojiDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(request.getParameter("user_id") == null) {
			User user = UserDAO.getInstance().getAUserByLog(log);
			request.setAttribute("user", user);
			request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
			return "myPage/userUpdate";
		}
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_email = "";
		for(String email : request.getParameterValues("user_email"))
			user_email += email;
		String user_nickname = request.getParameter("user_nickname");
		String user_address = request.getParameter("user_address");
		String user_img = request.getParameter("user_img");
		String user_phone = "";
		for(String number : request.getParameterValues("user_phone"))
			user_phone += number + "-";
		user_phone = user_phone.substring(0, user_phone.length() - 1);
		String user_dir_x = request.getParameter("user_dir_x");
		String user_dir_y = request.getParameter("user_dir_y");
		String user_city = request.getParameter("user_city");
		String user_gu = request.getParameter("user_gu");
		String user_dong = request.getParameter("user_dong");
		
		User user = new User(log,user_pw, user_name, user_email, user_nickname, user_address, user_img, user_phone, user_dir_x, user_dir_y, user_city, user_gu, user_dong);
		if(UserDAO.getInstance().userUpdate(user))
			AlertUtil.getInstance().goUrlWithAlert(response, user_nickname + "회원 정보 수정 완료.", "mypageUser.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 정보 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
