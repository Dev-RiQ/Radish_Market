package com.radish.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.radish.dao.ListPagingDAO;
import com.radish.frontController.Controller;
import com.radish.vo.BoardCategory;
import com.radish.vo.Filter;
import com.radish.vo.Item;
import com.radish.vo.ItemCategory;
import com.radish.vo.ItemImg;
import com.radish.vo.MeetCategory;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListPagingAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryString = request.getQueryString();
		String[] queryCategory = queryString.split("&");
		int queryStartIndex = Integer.parseInt(queryCategory[0].split("=")[1]);
		
		Filter filter = setFilter(queryStartIndex, queryCategory);
		
		String type = queryCategory[1].split("=")[1];
		switch(type) {
		case "receiveLetter", "sendLetter", "zzim", "cart", "myItem", "review", 
			"myBoard", "hostMeet", "myMeet": 
			filter.setUser_no(Integer.parseInt(request.getSession().getAttribute("log").toString())); break;
		}
		
		List<?> list = ListPagingDAO.getInstance().getListByFilter(type, filter);
		List<User> userList = ListPagingDAO.getInstance().getUserListByList(list, type);
		List<Item> itemList = null;
		List<BoardCategory> boardCategoryList = null;
		List<ItemCategory> itemCategoryList = null;
		List<MeetCategory> meetCategoryList = null;
		List<ItemImg> itemImgList = null;
		
		
		
		StringBuilder sb = new StringBuilder();
		
		switch(type) {
		case "item":  break;
		case "board":  break;
		case "meetBoard": ; break;
		case "meet":  break;
		case "receiveLetter":  break;
		case "sendLetter":  break;
		case "zzim":  break;
		case "cart":  break;
		case "myItem":  break;
		case "review":  break;
		case "myBoard":  break;
		case "hostMeet":  break;
		case "myMeet":  break;
		}
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		return null;
	}
	

	private Filter setFilter(int queryStartIndex, String[] queryCategory) {
		Filter filter = new Filter(queryStartIndex);
		if(queryCategory.length > 2) {
			filter.setItem_status(Integer.parseInt(queryCategory[2]));
			filter.setCategory_no(Integer.parseInt(queryCategory[3]));
			filter.setPrice_min(Integer.parseInt(queryCategory[4]));
			filter.setPrice_max(Integer.parseInt(queryCategory[5]));
			filter.setUser_dong(queryCategory[6]);
			filter.setOrder_by(Integer.parseInt(queryCategory[7]));
			filter.setMeet_no(Integer.parseInt(queryCategory[8]));
		}
		return filter;
	}

}
