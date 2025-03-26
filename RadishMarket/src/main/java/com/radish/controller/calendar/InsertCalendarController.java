package com.radish.controller.calendar;

import java.io.IOException;

import com.radish.dao.CalendarDAO;
import com.radish.dao.CartDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Calendar;
import com.radish.vo.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertCalendarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object log_obj = request.getSession().getAttribute("log");
		if(log_obj == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인을 먼저 해주세요.");
			return null;
		}
		
		int main_user_no = Integer.parseInt(log_obj.toString());
		String sub_user_no_str = request.getParameter("sub_user_no");
		String meet_no_str = request.getParameter("meet_no");
		int sub_user_no = 0;
		int meet_no = 0;
		if(sub_user_no_str != null && !sub_user_no_str.isBlank()) {
			sub_user_no = Integer.parseInt(sub_user_no_str);
		}
		if(meet_no_str != null && !meet_no_str.isBlank()) {
			meet_no = Integer.parseInt(meet_no_str);
		}
		String item_no_str = request.getParameter("item_no");
		int item_no = 0;
		if(item_no_str != null && !item_no_str.isBlank()) {
			item_no = Integer.parseInt(item_no_str);
		}
		String calendar_title = request.getParameter("calendar_title");
		if(calendar_title == null) {
			if(sub_user_no != 0)
				request.setAttribute("sub_user_no", sub_user_no);
			if(meet_no != 0)
				request.setAttribute("meet_no", meet_no);
			request.setAttribute("item_no", item_no);
			return "utils/calendarInsert";
		}
		
		String address = request.getParameter("calendar_address");
		String calendar_dir_x = request.getParameter("calendar_dir_x");
		String calendar_dir_y = request.getParameter("calendar_dir_y");
		String[] calendar_datetimes = request.getParameterValues("calendar_datetime");
		String calendar_datetime = calendar_datetimes[0] + " ";
		
		if(Integer.parseInt(calendar_datetimes[1]) < 10) {
			calendar_datetime += "0";
		}
		calendar_datetime += calendar_datetimes[1] + ":";
		
		if(Integer.parseInt(calendar_datetimes[2]) < 10) {
			calendar_datetime += "0";
		}
		calendar_datetime += calendar_datetimes[2];
		
		String calendar_content = request.getParameter("calendar_content");
		
		Calendar calendar = new Calendar(main_user_no, sub_user_no, meet_no, address, calendar_dir_x, calendar_dir_y, calendar_datetime, calendar_title, calendar_content);
		if(CalendarDAO.getInstance().insertACalendar(calendar)) {
			AlertUtil.getInstance().goUrlWithAlert(response, "일정 추가 완료", "mypageUser.do");
			Cart cart = new Cart(item_no, sub_user_no, 0);
			CartDAO.getInstance().cartInsert(cart);
		}
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 일정 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
