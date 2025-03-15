package com.radish.controller.admin;

import java.io.IOException;

import com.radish.dao.MeetDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MeetManageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("meetList", MeetDAO.getInstance().getAllMeetList());
		return "admin/meetManage";
	}

}
