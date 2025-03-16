package com.radish.controller.user;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.MeetCategoryDAO;
import com.radish.dao.MeetDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Board;
import com.radish.vo.Meet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class test_meetListUserController implements Controller {
	private static final int ITEMS_PER_PAGE = 30;

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(log));
		
		int meetHostTotalCnt = MeetDAO.getInstance().getAUserHostTotalBoardCnt(log);
		request.setAttribute("meetHostTotalCnt", meetHostTotalCnt);
		int hostLimit = ITEMS_PER_PAGE;
		if (hostLimit > meetHostTotalCnt) {
			hostLimit = meetHostTotalCnt;
		}
		int hostOffset = Integer.parseInt(request.getParameter("hostOffset") != null ? request.getParameter("hostOffset") : "0");
		
		List<Meet> hostMeetList = MeetDAO.getInstance().getAUserHostMeetListByUserNo(log, hostLimit, hostOffset);
		request.setAttribute("hostMeetList", hostMeetList);
		request.setAttribute("hostMeetDongList", UserDAO.getInstance().getDongListByMeetHostUserNo(hostMeetList));
		request.setAttribute("hostMeetUserCountList", MeetUserDAO.getInstance().getUserCountListByMeetNo(hostMeetList));
		request.setAttribute("hostMeetCategoryList", MeetCategoryDAO.getInstance().getMeetCategoryListByMeetNo(hostMeetList));
		
		
		int meetTotalCnt = MeetUserDAO.getInstance().getAUserMeetTotalCountByUserNo(log);
        request.setAttribute("meetTotalCnt", meetTotalCnt);
        int limit = ITEMS_PER_PAGE;
        if (limit > meetTotalCnt) limit = meetTotalCnt;
        int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");
		
		List<Integer> meetNoList =  MeetUserDAO.getInstance().getMeetNoListByUserNo(log);
		List<Meet> meetList = MeetDAO.getInstance().getAUserAllMeetListByMeetNo(meetNoList, limit, offset, log);
		request.setAttribute("meetList", meetList);
		request.setAttribute("meetDongList", UserDAO.getInstance().getDongListByMeetHostUserNo(meetList));
		request.setAttribute("meetUserCountList", MeetUserDAO.getInstance().getUserCountListByMeetNo(meetList));
		request.setAttribute("meetCategoryList", MeetCategoryDAO.getInstance().getMeetCategoryListByMeetNo(meetList));
		
		return "user/test_userMeetList";
	}

}
