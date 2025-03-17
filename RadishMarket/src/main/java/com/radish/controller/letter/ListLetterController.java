package com.radish.controller.letter;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.LetterDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Letter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListLetterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		List<Letter> letterList = LetterDAO.getInstance().getLetterListByUserNo(user_no);
		request.setAttribute("letterList", letterList);
		request.setAttribute("sendUserInfo", UserDAO.getInstance().getLetterUserList(letterList));
		
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		return "myPage/userLetterList";
	}

}
