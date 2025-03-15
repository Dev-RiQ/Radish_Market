package com.radish.controller.alarmCategory;

import java.io.IOException;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteAlarmCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int alarm_category_no = Integer.parseInt(request.getParameter("alarm_category_no"));
		
		if(AlarmCategoryDAO.getInstance().deleteAlarmCategory(alarm_category_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "알람 카테고리 삭제 완료", "listAlarmCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 알람 카테고리 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
