package com.radish.controller.meetJoin;

import java.io.IOException;

import com.radish.dao.MeetJoinDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteMeetJoinController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_join_no = Integer.parseInt(request.getParameter("meet_join_no"));
		
		if(MeetJoinDAO.getInstance().deleteMeetJoin(meet_join_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 가입 취소 완료", "listMeet.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 가입 취소에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
