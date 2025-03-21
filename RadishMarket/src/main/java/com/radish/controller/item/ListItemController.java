package com.radish.controller.item;

import java.io.IOException;

import com.radish.dao.ItemCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DongUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category_no_str = request.getParameter("category_no");
		int category_no = 0;
		if(category_no_str != null)
			category_no = Integer.parseInt(category_no_str);
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
		
		String order_by_str = request.getParameter("order_by");
		int order_by = 0;
		if (order_by_str != null)
			order_by = Integer.parseInt(order_by_str);
		
		String item_status_str = request.getParameter("item_status");
		int item_status = 0;
		if (item_status_str != null)
			item_status = Integer.parseInt(item_status_str);
		
		String price_min_str = request.getParameter("price_min");
		int price_min = 0;
		if (price_min_str != null)
			price_min = Integer.parseInt(price_min_str);
		
		String price_max_str = request.getParameter("price_max");
		int price_max = 0;
		if (price_max_str != null)
			price_max = Integer.parseInt(price_max_str);
		
		request.setAttribute("item_status", item_status);
		request.setAttribute("price_min", price_min);
		request.setAttribute("price_max", price_max);
		request.setAttribute("order_by", order_by);
		request.setAttribute("categoryNo", category_no);
		request.setAttribute("categoryList", ItemCategoryDAO.getInstance().getAllItemCategoryList());
		request.setAttribute("gu", gu);
		request.setAttribute("userDong", user_dong);
		if(user_dong.equals("전체")) {
			user_dong = request.getSession().getAttribute("dong").toString();
		}
		request.setAttribute("dongList", DongUtil.getInstance().getDongFilterList(gu, user_dong));
		
		return "item/itemList";
	}

}
