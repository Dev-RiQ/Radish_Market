package com.radish.controller.meetJoin;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.MeetJoinDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.vo.MeetJoin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetJoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		List<MeetJoin> meetJoinList = MeetJoinDAO.getInstance().getMeetJoinListByMeetNo(meet_no);
		request.setAttribute("meetJoinList", meetJoinList);
		request.setAttribute("joinUserList", UserDAO.getInstance().getAllUserByMeetJoinList(meetJoinList));
		
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		
		return "meet/meetJoinList";
	}

}
