package com.radish.controller.meet;

import java.io.IOException;

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

public class InsertMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object log_obj = request.getSession().getAttribute("log");
		if(log_obj == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인을 먼저 해주세요.");
			return null;
		}
		int host_user_no = Integer.parseInt(log_obj.toString());
		if(request.getParameter("meet_title") == null) {
			request.setAttribute("user", UserDAO.getInstance().getAUserByLog(host_user_no));
			request.setAttribute("meetCategoryList", MeetCategoryDAO.getInstance().getAllMeetCategoryList());
			return "meet/meetInsert";
		}
		String meet_title = request.getParameter("meet_title");
		String meet_content = request.getParameter("meet_content");
		int meet_category = Integer.parseInt(request.getParameter("meet_category_no"));
		int age_min = Integer.parseInt(request.getParameter("age_min"));
		int age_max = Integer.parseInt(request.getParameter("age_max"));
		String meet_img = request.getParameter("meet_img");
		String meet_gu = request.getParameter("meet_gu");
		String meet_dong = request.getParameter("meet_dong");
		System.out.println("meet_gu : "+meet_gu);
		System.out.println("meet_dong : "+meet_dong);
		int meet_user_count = 1;
		String meet_category_name = MeetCategoryDAO.getInstance().getAMeetCategoryName(meet_category);
		
		Meet meet = new Meet(host_user_no, meet_title, meet_content, meet_category, age_min, age_max, meet_img, meet_gu, meet_dong);
		if(MeetDAO.getInstance().insertMeet(meet)) {
			int meet_no = MeetDAO.getInstance().getLastMeetNo();
			MeetUserDAO.getInstance().insertMeetUser(meet_no, host_user_no);
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 생성 완료", String.format("infoMeet.do?meet_no=%s&meet_dong=%s&meet_user_count=%s&meet_category_name=%s",meet_no,meet_dong,meet_user_count,meet_category_name));
		}
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 생성에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
