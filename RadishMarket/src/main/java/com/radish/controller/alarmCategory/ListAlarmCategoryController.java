package com.radish.controller.alarmCategory;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.vo.AlarmCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAlarmCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AlarmCategory> list = AlarmCategoryDAO.getInstance().getAllAlarmCategoryList();
		request.setAttribute("alarmCategoryList", list);
		return "alarmCategory/alarmCategoryList";
	}

}
