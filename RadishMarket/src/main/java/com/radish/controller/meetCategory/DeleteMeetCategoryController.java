package com.radish.controller.meetCategory;

import java.io.IOException;

import com.radish.dao.MeetCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteMeetCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int meet_category_no = Integer.parseInt(request.getParameter("meet_category_no"));
		
		if(MeetCategoryDAO.getInstance().deleteMeetCategory(meet_category_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "모임 카테고리 삭제 완료", "listMeetCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 모임 카테고리 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
