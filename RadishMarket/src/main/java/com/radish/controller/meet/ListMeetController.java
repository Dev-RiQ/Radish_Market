package com.radish.controller.meet;

import java.io.IOException;
import java.util.List;

import com.radish.dao.MeetCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DongUtil;
import com.radish.vo.MeetCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListMeetController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category_no_str = request.getParameter("category_no");
		int category_no = 0;
		if(category_no_str != null)
			category_no = Integer.parseInt(category_no_str);
		
		String order_by_str = request.getParameter("order_by");
		int order_by = 0;
		if(order_by_str != null)
			order_by = Integer.parseInt(order_by_str);
		
		String meet_no_str = request.getParameter("meet_no");
		int meet_no = 0;
		if(meet_no_str != null)
			meet_no = Integer.parseInt(meet_no_str);
		
		Object gu_obj = request.getSession().getAttribute("gu");
		if(gu_obj == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "위치 정보를 불러올 수 없습니다.\\n로그인 또는 위치 정보 사용을 허용해주세요.");
			return null;
		}
		String gu = gu_obj.toString();
		String user_dong = request.getSession().getAttribute("dong").toString();
		
		if(request.getParameter("filter") != null) {
			String filter_gu = request.getParameter("gu"); 
			if(filter_gu != null && !filter_gu.isBlank())
				gu = filter_gu;
			String filter_dong = request.getParameter("dong"); 
			if(filter_dong != null && !filter_dong.isBlank())
				user_dong = filter_dong;
		}
		
		List<MeetCategory> categoryList = MeetCategoryDAO.getInstance().getAllMeetCategoryList();
		request.setAttribute("categoryNo", category_no);
		request.setAttribute("gu", gu);
		request.setAttribute("userDong", user_dong);
		request.setAttribute("order_by", order_by);
		request.setAttribute("meet_no", meet_no);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(gu, user_dong));
		return "meet/meetList";
	}

}
