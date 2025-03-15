package com.radish.controller.meetCategory;

import java.io.IOException;
import java.util.List;

import com.radish.dao.MeetCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.vo.MeetCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MeetCategory> list = MeetCategoryDAO.getInstance().getAllMeetCategoryList();
		request.setAttribute("meetCategoryList", list);
		return "meetCategory/meetCategoryList";
	}

}
