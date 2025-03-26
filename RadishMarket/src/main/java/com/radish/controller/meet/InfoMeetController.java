package com.radish.controller.meet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.BoardDAO;
import com.radish.dao.CalendarDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.MeetDAO;
import com.radish.dao.MeetJoinDAO;
import com.radish.dao.MeetUserDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.DateUtil;
import com.radish.vo.Board;
import com.radish.vo.Calendar;
import com.radish.vo.MeetJoin;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object log_obj = request.getSession().getAttribute("log");
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		if (log_obj != null) {
			int log = Integer.parseInt(log_obj.toString());
			boolean hasUser = MeetUserDAO.getInstance().hasUser(meet_no, log);
			if (hasUser)
				request.setAttribute("hasUser", hasUser);
			else if (MeetJoinDAO.getInstance().hasMeetJoin(new MeetJoin(meet_no, log)))
				request.setAttribute("hasMeetJoin", true);

		}
		request.setAttribute("meet", MeetDAO.getInstance().getAMeetByMeetNo(meet_no));
		request.setAttribute("meet_dong", request.getParameter("meet_dong"));
		request.setAttribute("meet_user_count", request.getParameter("meet_user_count"));
		request.setAttribute("meet_category_name", request.getParameter("meet_category_name"));

		String alarm_no_str = request.getParameter("alarm_no");
		if (alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}

		// 멤버
		int host_user_no = MeetDAO.getInstance().getHostUserNoByMeetNo(meet_no);
		User host_user = UserDAO.getInstance().getAUserPortionInfo(host_user_no);
		request.setAttribute("host_user", host_user);

		List<Integer> memberUserNoList = MeetUserDAO.getInstance().getUserNolimitListByMeetNo(meet_no, host_user_no);
		List<User> memberUserList = UserDAO.getInstance().getUserListByUserNoList(memberUserNoList, host_user_no);
		request.setAttribute("memberUserList", memberUserList);

		// 일정
		int calendarCountInt = CalendarDAO.getInstance().getMeetCalendarCount(meet_no);
		String calendarCount = "";
		if(calendarCountInt > 100) {
			calendarCount = "100+";
		}else {
			calendarCount = calendarCountInt+"";
		}
		request.setAttribute("calendarCount", calendarCount);
		
		List<Calendar> calendarList = CalendarDAO.getInstance().getMeetCalendarLimitList(meet_no);
		String[] calendarMonth = new String[calendarList.size()];
		String[] calendarDay = new String[calendarList.size()];
		String[] calendarTime = new String[calendarList.size()];
		for(int i = 0; i < calendarList.size(); i++) {
			calendarMonth[i] = calendarList.get(i).getCalendar_datetime().split(" ")[0].split("-")[1];
			calendarDay[i] = calendarList.get(i).getCalendar_datetime().split(" ")[0].split("-")[2];
			calendarTime[i] = calendarList.get(i).getCalendar_datetime().split(" ")[1];
		}
		request.setAttribute("calendarList", calendarList);
		request.setAttribute("calendarMonth", calendarMonth);
		request.setAttribute("calendarDay", calendarDay);
		request.setAttribute("calendarTimeList", calendarTime);
		
		// 게시글
		List<Board> boardList = BoardDAO.getInstance().getMeetBoardLimitList(meet_no);
		request.setAttribute("boardList", boardList);
		
		int boardListCountInt = BoardDAO.getInstance().getMeetBoardCount(meet_no);
		String boardCount = "";
		if(boardListCountInt > 100) {
			boardCount = "100+";
		}else {
			boardCount = boardListCountInt+"";
		}
		request.setAttribute("boardCount", boardCount);
		
		String[] boardTime = new String [boardList.size()];
		for(int i = 0; i < boardList.size(); i++) {
			boardTime[i] = DateUtil.getInstance().getCalcDateAgo(boardList.get(i).getBoard_update_datetime());
		}
		request.setAttribute("boardTime", boardTime);
		
		List<Integer> boardUserNoList = new ArrayList<>();
		for(Board board : boardList) {
			boardUserNoList.add(board.getUser_no());
		}
		List<String> boardUserNickNameList = UserDAO.getInstance().getUserNicknameList(boardUserNoList);
		request.setAttribute("boardUserNickNameList", boardUserNickNameList);
		
		List<Integer> boardNoList = new ArrayList<>();
		for(Board board : boardList) {
			boardNoList.add(board.getBoard_no());
		}
		List<Integer> boardLikeList = LikeDAO.getInstance().getCountLikeByBoardNoList(boardNoList);
		request.setAttribute("boardLikeList", boardLikeList);
		
		List<Integer> boardCategoryNoList = new ArrayList<>();
		for(Board e : boardList) {
			boardCategoryNoList.add(e.getBoard_category_no());
		}
		List<String> boardCategoryNameList = BoardCategoryDAO.getInstance().getBoardCategoryNameList(boardCategoryNoList);
		request.setAttribute("boardCategoryNameList", boardCategoryNameList);
		
		List<Integer> boardCommentCountList = CommentDAO.getInstance().getCommentListByBoardNoList(boardNoList);
		request.setAttribute("boardCommentCountList", boardCommentCountList);
		
		return "meet/meetInfo";
	}

}
