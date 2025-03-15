package com.radish.controller.meet;

import java.io.IOException;

import com.radish.dao.MeetDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(MeetDAO.getInstance().deleteMeet(meet_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 삭제 완료", log == -1 ? "meetManage.do" : "listMeet.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
