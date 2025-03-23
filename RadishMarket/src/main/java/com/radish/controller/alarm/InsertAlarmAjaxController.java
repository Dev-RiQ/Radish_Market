package com.radish.controller.alarm;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Alarm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertAlarmAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용가능합니다.");
			return null;
		}
		
		if(request.getParameter("user_no") == null || request.getParameter("user_no").isBlank()) {
			return null;
		}
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		int alarm_category_no = Integer.parseInt(request.getParameter("alarm_category_no"));
		String link_no_str = request.getParameter("link_no");
		int link_no = 0;
		if(link_no_str != null)
			link_no = Integer.parseInt(link_no_str);
		String alarm_reg_datetime = DateUtil.getInstance().getRegDatetime();
		int alarm_check = 0;
		
		Alarm alarm = new Alarm(user_no, alarm_category_no, link_no, alarm_reg_datetime, alarm_check);
		AlarmDAO.getInstance().insertAAlarm(alarm);
		return null;
	}

}
