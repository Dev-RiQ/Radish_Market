package com.radish.controller.meetUser;

import java.io.IOException;

import com.radish.dao.MeetUserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteMeetUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		if(MeetUserDAO.getInstance().deleteMeetUser(meet_no, log))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 탈퇴 완료", "listMeet.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 탈퇴에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
