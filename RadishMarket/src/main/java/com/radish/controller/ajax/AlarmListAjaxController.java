package com.radish.controller.ajax;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.dao.AlarmDAO;
import com.radish.frontController.Controller;
import com.radish.util.DateUtil;
import com.radish.vo.Alarm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlarmListAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object user_log = request.getSession().getAttribute("log");
		if(user_log == null) {
			return null;
		}
		
		int user_no = Integer.parseInt(user_log.toString());
		List<Alarm> alarmList = AlarmDAO.getInstance().getAlarmListByUserNo(user_no);
		StringBuilder sb = new StringBuilder();
		for(Alarm alarm : alarmList) {
			sb.append(AlarmCategoryDAO.getInstance().getAAlarmCategoryName(alarm.getAlarm_category_no()));
			sb.append(",");
			sb.append(alarm.getAlarm_content());
			sb.append(",");
			sb.append(DateUtil.getInstance().getCalcDateAgo(alarm.getAlarm_reg_datetime()));
			sb.append(",");
			sb.append(alarm.getAlarm_no());
			sb.append(",");
			sb.append(alarm.getAlarm_category_no());
			sb.append(",");
			sb.append(alarm.getLink_no());
			sb.append(",");
			sb.append(alarm.getAlarm_check());
			sb.append("/");
		}
		String data = sb.toString(); 
		response.getWriter().print(data.substring(0, data.length() - 1));
		return null;
	}

}
