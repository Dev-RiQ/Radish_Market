package com.radish.controller.alarm;

import java.io.IOException;
import java.util.List;

import com.radish.dao.AlarmCategoryDAO;
import com.radish.dao.AlarmDAO;
import com.radish.frontController.Controller;
import com.radish.util.DateUtil;
import com.radish.vo.Alarm;
import com.radish.vo.AlarmCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListAlarmAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object user_log = request.getSession().getAttribute("log");
		if(user_log == null) {
			return null;
		}
		
		int user_no = Integer.parseInt(user_log.toString());
		List<Alarm> alarmList = AlarmDAO.getInstance().getAlarmListByUserNo(user_no);
		List<AlarmCategory> alarmCategoryList = AlarmCategoryDAO.getInstance().getAlarmCategoryListByAlarmList(alarmList);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < alarmList.size() ; i++) {
			sb.append(alarmCategoryList.get(i).getAlarm_category_name());
			sb.append(",");
			sb.append(alarmCategoryList.get(i).getAlarm_category_content());
			sb.append(",");
			sb.append(DateUtil.getInstance().getCalcDateAgo(alarmList.get(i).getAlarm_reg_datetime()));
			sb.append(",");
			sb.append(alarmList.get(i).getAlarm_no());
			sb.append(",");
			sb.append(alarmList.get(i).getAlarm_category_no());
			sb.append(",");
			sb.append(alarmList.get(i).getLink_no());
			sb.append(",");
			sb.append(alarmList.get(i).getAlarm_check());
			sb.append("/");
		}
		String data = sb.toString(); 
		if(data.length() > 0)
			response.getWriter().print(data.substring(0, data.length() - 1));
		return null;
	}

}
