package com.radish.controller.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		Map<String, String[]> queryString = request.getParameterMap();
		int queryStartIndex = Integer.parseInt(queryString.get("start")[0]);
		
		Filter filter = ListPagingDAO.getInstance().setFilter(queryStartIndex, queryString);
		
		String type = queryString.get("type")[0];
		switch(type) {
		case "receiveLetter", "sendLetter", "zzim", "cart", "myItem", "review", 
			"myBoard", "hostMeet", "myMeet": 
			filter.setUser_no(Integer.parseInt(request.getSession().getAttribute("log").toString())); break;
		}
		
		List<?> list = ListPagingDAO.getInstance().getListByFilter(type, filter);
		if(list != null && list.size() != 0) {
			List<User> userList = ListPagingDAO.getInstance().getUserListByList(list, type);
			List<Item> itemList = ListPagingDAO.getInstance().getItemListByList(list, type);
			List<BoardCategory> boardCategoryList = ListPagingDAO.getInstance().getBoardCategoryListByList(list, type);
			List<ItemCategory> itemCategoryList = ListPagingDAO.getInstance().getItemCategoryListByList(list, type);
			List<MeetCategory> meetCategoryList = ListPagingDAO.getInstance().getMeetCategoryListByList(list, type);
			List<ItemImg> itemImgList = ListPagingDAO.getInstance().getItemImgListByList(list, itemList, type);
			List<Integer> likeCountList = ListPagingDAO.getInstance().getLikeCountListByList(list, type);
			List<Integer> commentCountList = ListPagingDAO.getInstance().getCommentCountListByList(list, type);
			List<Integer> memberCountList = ListPagingDAO.getInstance().getMemberCountListByList(list, type);
			
			StringBuilder sb = ListPagingDAO.getInstance().getPrintListData(type, list, userList, itemList, 
					boardCategoryList, itemCategoryList, meetCategoryList, itemImgList, likeCountList,
					commentCountList, memberCountList);
			
			response.getWriter().print(sb.toString());
		}else {
			response.getWriter().print("noMoreList");
		}
        
		return null;
	}
	



}
