package com.radish.controller.calendar;

import java.io.IOException;

import com.radish.dao.CalendarDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertCalendarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int main_user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String sub_user_no_str = request.getParameter("sub_user_no");
		String meet_no_str = request.getParameter("meet_no");
		int sub_user_no = 0;
		int meet_no = 0;
		if(sub_user_no_str != null) {
			sub_user_no = Integer.parseInt(sub_user_no_str);
		}
		if(meet_no_str != null) {
			meet_no = Integer.parseInt(meet_no_str);
		}
		String calendar_title = request.getParameter("calendar_title");
		if(calendar_title == null) {
			if(sub_user_no != 0)
				request.setAttribute("sub_user_no", sub_user_no);
			if(meet_no != 0)
				request.setAttribute("meet_no", meet_no);
			return "utils/calendarInsert";
		}
		
		String address = request.getParameter("calendar_address");
		String calendar_dir_x = request.getParameter("calendar_dir_x");
		String calendar_dir_y = request.getParameter("calendar_dir_y");
		String[] calendar_datetimes = request.getParameterValues("calendar_datetime");
		String calendar_datetime = calendar_datetimes[0] + " " + calendar_datetimes[1] + ":" + calendar_datetimes[2];
		String calendar_content = request.getParameter("calendar_content");
		
		Calendar calendar = new Calendar(main_user_no, sub_user_no, meet_no, address, calendar_dir_x, calendar_dir_y, calendar_datetime, calendar_title, calendar_content);
		if(CalendarDAO.getInstance().insertACalenadr(calendar))
			AlertUtil.getInstance().goHomeWithAlert(response, "일정 추가 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 일정 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
