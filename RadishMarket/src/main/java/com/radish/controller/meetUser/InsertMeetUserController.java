package com.radish.controller.meetUser;

import java.io.IOException;

import com.radish.dao.MeetUserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertMeetUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		if(MeetUserDAO.getInstance().insertMeetUser(meet_no, user_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 가입 승인 완료", "listMeetJoin.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 가입 승인에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
