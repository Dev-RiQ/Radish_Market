package com.radish.controller.calendar;

import java.io.IOException;

import com.radish.dao.CalendarDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCalendarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
		if (request.getParameter("check") == null) {
			request.setAttribute("calendar", CalendarDAO.getInstance().getACalendarByCalendarNo(calendar_no));
			return "utils/calendarUpdate";
		}
		
		int main_user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String calendar_title = request.getParameter("calendar_title");
		String address = request.getParameter("calendar_address");
		String calendar_dir_x = request.getParameter("calendar_dir_x");
		String calendar_dir_y = request.getParameter("calendar_dir_y");
		String[] calendar_datetimes = request.getParameterValues("calendar_datetime");
		String calendar_datetime = calendar_datetimes[0] + " ";

		if (Integer.parseInt(calendar_datetimes[1]) < 10) {
			calendar_datetime += "0";
		}
		calendar_datetime += calendar_datetimes[1] + ":";

		if (Integer.parseInt(calendar_datetimes[2]) < 10) {
			calendar_datetime += "0";
		}
		calendar_datetime += calendar_datetimes[2];

		String calendar_content = request.getParameter("calendar_content");

		Calendar calendar = new Calendar(main_user_no, address, calendar_dir_x, calendar_dir_y, calendar_datetime,
				calendar_title, calendar_content);
		if (CalendarDAO.getInstance().insertACalenadr(calendar))
			AlertUtil.getInstance().goUrlWithAlert(response, "일정 수정 완료", "mypageUser.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 일정 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
