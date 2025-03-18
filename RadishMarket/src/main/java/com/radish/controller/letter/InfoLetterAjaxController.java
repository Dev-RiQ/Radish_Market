package com.radish.controller.letter;

import java.io.IOException;

import com.radish.dao.LetterDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Letter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoLetterAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int letter_no = Integer.parseInt(request.getParameter("letter_no"));
		Letter letter = LetterDAO.getInstance().getALetter(letter_no);
		String send_user_nickname = UserDAO.getInstance().getAUserNicnameByUserNo(letter.getSend_user_no());
		StringBuilder sb = new StringBuilder();
		sb.append(letter.getSend_user_no());
		sb.append("/devide/");
		sb.append(letter.getLetter_title());
		sb.append("/devide/");
		sb.append(letter.getItem_no());
		sb.append("/devide/");
		sb.append(letter.getLetter_reg_datetime());
		sb.append("/devide/");
		sb.append(letter.getLetter_content());
		sb.append("/devide/");
		sb.append(send_user_nickname);
		response.getWriter().print(sb.toString());
		LetterDAO.getInstance().setCheck(letter_no);
		return null;
	}

}
