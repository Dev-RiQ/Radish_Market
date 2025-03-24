package com.radish.controller.calendar;

import java.io.IOException;

import com.google.gson.Gson;
import com.radish.dao.CalendarDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoCalendarAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("calendar_no") == null) {
			return null;
		}
		
		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
		Calendar calendar = CalendarDAO.getInstance().getACalendarByCalendarNo(calendar_no);
		
		response.setContentType("application/json;charset=utf-8");
		if(calendar != null) {
			Gson gson = new Gson();
			String json = gson.toJson(calendar);
			response.getWriter().print(json);
		}else {
			response.getWriter().print("no_data");
		}
		return null;
	}

}
