package com.radish.controller.meetJoin;

import java.io.IOException;

import com.radish.dao.MeetJoinDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.MeetJoin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertMeetJoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meet_join_content = request.getParameter("meet_join_content");
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		if(meet_join_content == null) {
			request.setAttribute("meet_no", meet_no);
			return "meet/meetJoinInsert";
		}
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		MeetJoin meetJoin = new MeetJoin(meet_no, log, meet_join_content);
		if(MeetJoinDAO.getInstance().insertMeetJoin(meetJoin))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 가입 신청 완료", "listMeet.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 가입 신청에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
