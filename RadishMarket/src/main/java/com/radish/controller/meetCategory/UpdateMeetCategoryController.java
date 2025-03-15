package com.radish.controller.meetCategory;

import java.io.IOException;

import com.radish.dao.MeetCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.MeetCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateMeetCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_category_no = Integer.parseInt(request.getParameter("meet_category_no"));
		
		if(request.getParameter("meet_category_name") == null) {
			request.setAttribute("meet_category_no", meet_category_no);
			request.setAttribute("meet_category_name", MeetCategoryDAO.getInstance().getAMeetCategoryName(meet_category_no));
			return "meetCategory/meetCategoryUpdate";
		}
		
		String meet_category_name = request.getParameter("meet_category_name");
		
		MeetCategory meetCategory = new MeetCategory(meet_category_no, meet_category_name);
		if(MeetCategoryDAO.getInstance().updateMeetCategory(meetCategory))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 카테고리 수정 완료", "listMeetCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 카테고리 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
