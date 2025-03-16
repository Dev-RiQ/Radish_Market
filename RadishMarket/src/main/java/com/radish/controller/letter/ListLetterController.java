package com.radish.controller.letter;

import java.io.IOException;
import java.util.List;

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
		return "마이페이지 쪽지 목록";
	}

}
