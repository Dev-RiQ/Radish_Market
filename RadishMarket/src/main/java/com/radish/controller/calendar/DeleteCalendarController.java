package com.radish.controller.calendar;

import java.io.IOException;

import com.radish.dao.CalendarDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCalendarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int calendar_no = Integer.parseInt(request.getParameter("calendar_no"));
		if (CalendarDAO.getInstance().deleteACalendarByCalendarNo(calendar_no)) {
			AlertUtil.getInstance().goUrlWithAlert(response, "일정 삭제 완료", "mypageUser.do");
		} else {
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 일정 삭제에 실패했습니다.\n다시 시도해주세요.");
		}
		return null;
	}

}
