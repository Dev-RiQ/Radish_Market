package com.radish.controller.letter;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.LetterDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Letter;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListLetterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용해 주세요.");
		}
		
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		User user = UserDAO.getInstance().getAUserPortionInfo(user_no);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		List<Letter> letterList = LetterDAO.getInstance().getLetterListByUserNo(user_no);
		request.setAttribute("letterList", letterList);
		
		
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		
		return "myPage/userLetterList";
	}

}
