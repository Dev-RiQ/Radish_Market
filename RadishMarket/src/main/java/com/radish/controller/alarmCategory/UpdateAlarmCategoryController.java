package com.radish.controller.alarmCategory;

import java.io.IOException;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.AlarmCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateAlarmCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int alarm_category_no = Integer.parseInt(request.getParameter("alarm_category_no"));
		
		if(request.getParameter("alarm_category_name") == null) {
			request.setAttribute("alarm_category_no", alarm_category_no);
			AlarmCategory alarmCategory = AlarmCategoryDAO.getInstance().getAAlarmCategory(alarm_category_no);
			request.setAttribute("alarm_category_name", alarmCategory.getAlarm_category_name());
			request.setAttribute("alarm_category_content", alarmCategory.getAlarm_category_content());
			return "alarmCategory/alarmCategoryUpdate";
		}
		
		String alarm_category_name = request.getParameter("alarm_category_name");
		String alarm_category_content = request.getParameter("alarm_category_content");
		
		AlarmCategory alarmCategory = new AlarmCategory(alarm_category_no, alarm_category_name,alarm_category_content);
		if(AlarmCategoryDAO.getInstance().updateAlarmCategory(alarmCategory))
			AlertUtil.getInstance().goUrlWithAlert(response, "알람 카테고리 수정 완료", "listAlarmCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 알람 카테고리 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
