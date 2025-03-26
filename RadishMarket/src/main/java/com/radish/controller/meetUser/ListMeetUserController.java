package com.radish.controller.meetUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.EmojiDAO;
import com.radish.dao.MeetDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		request.setAttribute("meet_no", meet_no);
		request.setAttribute("meet_dong", request.getParameter("meet_dong"));
		request.setAttribute("meet_user_count", request.getParameter("meet_user_count"));
		request.setAttribute("meet_category_name", request.getParameter("meet_category_name"));
		request.setAttribute("meet", MeetDAO.getInstance().getAMeetByMeetNo(meet_no));
		
		List<Integer> meetUserNoList = MeetUserDAO.getInstance().getUserNoListByMeetNo(meet_no);
		List<User> meetUserList = UserDAO.getInstance().getMeetUserList(meetUserNoList);
		request.setAttribute("meet_user_list", meetUserList);
		List<String> emojiList = new ArrayList<>();
		for(User user : meetUserList)
			emojiList.add(EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		request.setAttribute("emojiList", emojiList);
		
		return "meet/meetUserList";
	}

}
