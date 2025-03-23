package com.radish.controller.calendar;

import java.io.IOException;

import com.radish.dao.CalendarDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListCalendarAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("log") == null) {
			return null;
		}
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String dateNum = request.getParameter("dateNum");
		
		StringBuilder sb = new StringBuilder();
		for(Calendar e : CalendarDAO.getInstance().getCalendarListByUserNo(log, dateNum)) {
			sb.append(e.getCalendar_no());
			sb.append("/divide/");
			sb.append(e.getCalendar_datetime());
			sb.append("/divide/");
			sb.append(e.getCalendar_title());
			sb.append("/separation/");
		}
		String data = sb.toString();
		if(!data.isBlank()) {
			response.getWriter().print(data.substring(0, data.length()-12));
		}else {
			response.getWriter().print("no_data");
		}
		return null;
	}

}
