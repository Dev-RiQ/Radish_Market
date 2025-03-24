package com.radish.controller.myPage;

import java.io.IOException;

import com.radish.dao.EmojiDAO;
import com.radish.dao.MeetDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class meetListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		User user = UserDAO.getInstance().getAUserPortionInfo(log);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		int hostMeetListSizeInt = MeetDAO.getInstance().getHostMeetListSize(log);
		String hostMeetListSize = "";
		if(hostMeetListSizeInt > 100) {
			hostMeetListSize = "100+";
		}else {
			hostMeetListSize = hostMeetListSizeInt+"";
		}
		request.setAttribute("hostMeetListSize", hostMeetListSize);
		
		int meetListSizeInt = MeetUserDAO.getInstance().getMeetListSize(log);
		String meetListSize = "";
		if(meetListSizeInt > 100) {
			meetListSize = "100+";
		}else {
			meetListSize = meetListSizeInt+"";
		}
		request.setAttribute("meetListSize", meetListSize);
		
		return "myPage/userMeetList";
	}

}
