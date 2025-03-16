package com.radish.controller.alarm;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.frontController.Controller;
import com.radish.util.DateUtil;
import com.radish.vo.Alarm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertAlarmController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int user_no = Integer.parseInt(request.getParameter("user_no"));
		int alarm_category_no = Integer.parseInt(request.getParameter("alarm_category_no"));
		int link_no = Integer.parseInt(request.getParameter("link_no"));
		String alarm_reg_datetime = DateUtil.getInstance().getRegDatetime();
		int alarm_check = 0;
		String alarm_content = "";
		
		switch(alarm_category_no) {
		case 1 : alarm_content = "누군가 게시글을 좋아합니다."; break; // 좋아요 
		case 2 : alarm_content = "게시글에 댓글이 추가되었습니다."; break; // 댓글
		case 3 : alarm_content = "누군가 아이템을 찜했습니다."; break; // 찜
		case 4 : alarm_content = "판매 물품에 리뷰가 추가되었습니다."; break; // 리뷰달림
		case 5 : alarm_content = "구매한 품목의 리뷰를 작성해주세요."; break; // 리뷰작성안내
		case 6 : alarm_content = "새로운 쪽지가 있습니다."; break; // 쪽지
		case 7 : alarm_content = "누군가 새로운 일정에 나를 추가했습니다."; break; // 일정추가
		case 8 : alarm_content = "누군가 모임에 가입 신청을 했습니다."; break; // 모임가입신청
		case 9 : alarm_content = "신청했던 모임에 가입되었습니다."; break; // 모임가입신청승인
		}
		
		Alarm alarm = new Alarm(user_no, alarm_category_no, link_no, alarm_reg_datetime, alarm_check, alarm_content);
		AlarmDAO.getInstance().insertAAlarm(alarm);
		return null;
	}

}
