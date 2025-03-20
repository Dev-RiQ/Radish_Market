package com.radish.controller.letter;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.dao.LetterDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Letter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertLetterController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용가능합니다.");
			return null;
		}
		
		int receive_user_no = Integer.parseInt(request.getParameter("user_no"));
		int send_user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String letter_title = request.getParameter("letter_title");
		String item_no_str = request.getParameter("item_no");
		int item_no = 0;
		if(item_no_str != null) {
			item_no = Integer.parseInt(item_no_str);
			request.setAttribute("item", ItemDAO.getInstance().getAItemByItemNo(item_no));
		}
		String letter_content = request.getParameter("letter_content");
		String letter_reg_datetime = DateUtil.getInstance().getRegDatetime();
		int letter_check = 0;
		
		Letter letter = new Letter(receive_user_no, send_user_no, item_no, letter_title, letter_content, letter_reg_datetime, letter_check);
		boolean check = LetterDAO.getInstance().insertALetter(letter);
		response.getWriter().print(check? "check" : "");
		return null;
	}

}
