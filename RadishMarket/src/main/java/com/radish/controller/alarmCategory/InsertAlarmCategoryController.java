package com.radish.controller.alarmCategory;

import java.io.IOException;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertAlarmCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("alarm_category_name") == null) {
			return "alarmCategory/alarmCategoryInsert";
		}
		
		String alarm_category_name = request.getParameter("alarm_category_name");
		
		if(AlarmCategoryDAO.getInstance().insertAlarmCategory(alarm_category_name))
			AlertUtil.getInstance().goUrlWithAlert(response, "알람 카테고리 추가 완료", "listAlarmCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 알람 카테고리 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
