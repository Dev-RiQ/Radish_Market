package com.radish.controller.letter;

import java.io.IOException;

import com.radish.dao.EmojiDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.LetterDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Item;
import com.radish.vo.Letter;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoLetterAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int letter_no = Integer.parseInt(request.getParameter("letter_no"));
		Letter letter = LetterDAO.getInstance().getALetter(letter_no);
		User send_user_portion_info = UserDAO.getInstance().getAUserPortionInfo(letter.getSend_user_no());
		Item item = null;
		if(letter.getItem_no() != 0) {
			item = ItemDAO.getInstance().getAItemByItemNo(letter.getItem_no());
		}
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
		sb.append(send_user_portion_info.getUser_img());
		sb.append("/devide/");
		String send_user_nickname = send_user_portion_info.getUser_nickname();
		sb.append(send_user_nickname);
		sb.append("/devide/");
		sb.append(send_user_portion_info.getUser_dong());
		sb.append("/devide/");
		int user_deg = send_user_portion_info.getUser_deg();
		sb.append(user_deg);
		sb.append("/devide/");
		sb.append(EmojiDAO.getInstance().getEmoji(user_deg));
		if(item != null) {
			sb.append("/devide/");
			sb.append(ItemImgDAO.getInstance().getAItemImg(item.getItem_no()));
			sb.append("/devide/");
			sb.append(item.getItem_name());
			sb.append("/devide/");
			sb.append(item.getItem_price());
		}
		response.getWriter().print(sb.toString());
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(!UserDAO.getInstance().getAUserByLog(log).getUser_nickname().equals(send_user_nickname))
			LetterDAO.getInstance().setCheck(letter_no);
		return null;
	}

}
