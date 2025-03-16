package com.radish.controller.letter;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.dao.LetterDAO;
import com.radish.dao.UserDAO;
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
		int receive_user_no = Integer.parseInt(request.getParameter("user_no"));
		int send_user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String letter_title = request.getParameter("letter_title");
		String item_no_str = request.getParameter("item_no");
		int item_no = 0;
		if(item_no_str != null) {
			item_no = Integer.parseInt(item_no_str);
			request.setAttribute("item", ItemDAO.getInstance().getAItemByItemNo(item_no));
		}
		if(letter_title == null) {
			request.setAttribute("user", UserDAO.getInstance().getAUserByLog(send_user_no));
			return "utils/letterInsert";
		}
		String letter_content = request.getParameter("letter_content");
		String letter_reg_datetime = DateUtil.getInstance().getRegDatetime();
		int letter_check = 0;
		
		Letter letter = new Letter(receive_user_no, send_user_no, letter_title, letter_content, letter_reg_datetime, letter_check, item_no);
		if(LetterDAO.getInstance().insertALetter(letter))
			AlertUtil.getInstance().goHomeWithAlert(response, "쪽지 발송 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 쪽지 발송에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
