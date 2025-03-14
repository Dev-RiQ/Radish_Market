package com.radish.controller.meet;

import java.io.IOException;

import com.radish.dao.MeetDAO;
import com.radish.dao.MeetJoinDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.MeetJoin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		boolean hasUser = MeetUserDAO.getInstance().hasUser(meet_no, log);
		request.setAttribute("meet", MeetDAO.getInstance().getAMeetByMeetNo(meet_no));
		request.setAttribute("meet_dong", request.getParameter("meet_dong"));
		request.setAttribute("meet_user_count", request.getParameter("meet_user_count"));
		request.setAttribute("meet_category_name", request.getParameter("meet_category_name"));
		if(hasUser)
			request.setAttribute("hasUser", hasUser);
		else if(MeetJoinDAO.getInstance().hasMeetJoin(new MeetJoin(meet_no,log)))
			request.setAttribute("hasMeetJoin", true);
		
		return "meet/meetInfo";
	}

}
