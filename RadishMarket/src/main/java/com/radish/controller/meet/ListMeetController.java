package com.radish.controller.meet;

import java.io.IOException;
import java.util.List;

import com.radish.dao.MeetCategoryDAO;
import com.radish.dao.MeetDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Meet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goUrlWithAlert(response, "로그인 후 이용 가능합니다.", "login.do");
		}
		int start = 0;
		if(request.getParameter("start") != null)
			start = Integer.parseInt(request.getParameter("start"));
		request.setAttribute("start", start);
		if(MeetDAO.getInstance().hasNextList(start))
			request.setAttribute("hasNext", true);
		List<Meet> list = MeetDAO.getInstance().getLimitedMeetList(start);
		request.setAttribute("meetDongList", UserDAO.getInstance().getDongListByMeetHostUserNo(list));
		request.setAttribute("meetUserCountList", MeetUserDAO.getInstance().getUserCountListByMeetNo(list));
		request.setAttribute("meetCategoryList", MeetCategoryDAO.getInstance().getMeetCategoryListByMeetNo(list));
		request.setAttribute("meetList", list);
		return "meet/meetList";
	}

}
