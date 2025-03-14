package com.radish.controller.meet;

import java.io.IOException;

import com.radish.dao.MeetCategoryDAO;
import com.radish.dao.MeetDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Meet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		if(request.getParameter("meet_title") == null) {
			request.setAttribute("meetCategoryList", MeetCategoryDAO.getInstance().getAllMeetCategoryList());
			request.setAttribute("meetInfo", MeetDAO.getInstance().getAMeetByMeetNo(meet_no));
			return "meet/meetUpdate";
		}
		int host_user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String meet_title = request.getParameter("meet_title");
		String meet_content = request.getParameter("meet_content");
		int meet_category = Integer.parseInt(request.getParameter("meet_category_no"));
		int age_min = Integer.parseInt(request.getParameter("age_min"));
		int age_max = Integer.parseInt(request.getParameter("age_max"));
		String meet_img = request.getParameter("meet_img");
		
		Meet meet = new Meet(meet_no, host_user_no, meet_title, meet_content, meet_category, age_min, age_max, meet_img);
		if(MeetDAO.getInstance().updateMeet(meet))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 수정 완료", "listMeet.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
