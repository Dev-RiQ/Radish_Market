package com.radish.controller.like;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.dao.LikeDAO;
import com.radish.frontController.Controller;
import com.radish.vo.Alarm;
import com.radish.vo.Like;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteLikeController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		Alarm alarm = new Alarm(user_no, board_no, 1);
		int alarm_no = AlarmDAO.getInstance().getAlarmNo(alarm);
		AlarmDAO.getInstance().deleteAAlarm(alarm_no);
		Like like = new Like(board_no, user_no);
		LikeDAO.getInstance().deleteLike(like);
		
		return null;
	}

}
