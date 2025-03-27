package com.radish.controller.myPage;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ReviewDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class itemListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		String user_no_str = request.getParameter("user_no");
		if(user_no_str != null) {
			log = Integer.parseInt(user_no_str);
		}
		
		User user = UserDAO.getInstance().getAUserByLog(log);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		int sellListSizeInt = ItemDAO.getInstance().getSellListSize(log);
		String sellListSize = (sellListSizeInt > 100) ? "100+" : sellListSizeInt+"";
		request.setAttribute("sellListSize", sellListSize);
		
		int reviewListSizeInt = ReviewDAO.getInstance().getReviewListSize(log);
		String reviewListSize = (reviewListSizeInt > 100) ? "100+" : reviewListSizeInt + "";
		request.setAttribute("reviewListSize", reviewListSize);
		
		String alarm_no_str = request.getParameter("alarm_no");
		if (alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			request.setAttribute("alarm_no", alarm_no);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		
		return "myPage/userItemList";
	}

}
