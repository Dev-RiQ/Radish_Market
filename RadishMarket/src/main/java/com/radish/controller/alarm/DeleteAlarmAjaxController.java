package com.radish.controller.alarm;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteAlarmAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int alarm_no = Integer.parseInt(request.getParameter("alarm_no"));
		AlarmDAO.getInstance().deleteAAlarm(alarm_no);
		return null;
	}

}
