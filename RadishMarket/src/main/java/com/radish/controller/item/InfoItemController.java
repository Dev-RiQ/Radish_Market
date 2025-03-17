package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.ItemCategoryDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.ZzimDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Item;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoItemController implements Controller {
	private static final int ITEMS_PER_PAGE = 6;
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("item_no") == null){
			AlertUtil.getInstance().goBackWithAlert(response, "\"서버 오류로 인해 아이템 정보를 가져오지 못했습니다.\\\\\\\\n다시 시도해주세요.\"");
			return null;
		}
		
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		Item item = ItemDAO.getInstance().getAItemByItemNo(item_no);
		request.setAttribute("item", item);
		request.setAttribute("item_category_name", ItemCategoryDAO.getInstance().getAitemCategoryName(item_no));
		User user = UserDAO.getInstance().getAUserByLog(item.getUser_no());
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		request.setAttribute("zzimCount", ZzimDAO.getInstance().getCountZzimByItemNo(item_no));
		ItemDAO.getInstance().itemHitsUp(item_no);
		
		int itemTotalCnt = ItemDAO.getInstance().getTotalItemCnt();
		int limit = ITEMS_PER_PAGE;
		if (limit > itemTotalCnt) {
			limit = itemTotalCnt;
		}
		int offset = 0;
		
		List<Item> itemList = ItemDAO.getInstance().getAUserAllItemListByUserNo(item.getUser_no(), limit, offset);
		request.setAttribute("itemList", itemList);
		request.setAttribute("userAllItemListSize", ItemDAO.getInstance().getAUserAllItemListSizeByUserNo(item.getUser_no()));
		
		List<Integer> itemNoList = new ArrayList<>();
		for(Item itemNo : itemList) {
			itemNoList.add(itemNo.getItem_no());
		}
		List<String> mainImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("mainImgList", mainImgList);
		
		int item_category_no = item.getItem_category_no();
		request.setAttribute("categoryName", ItemCategoryDAO.getInstance().getAitemCategoryName(item_category_no));
		
		List<Item> hotItemSortList = ItemDAO.getInstance().getHotItemSortList();
		request.setAttribute("hotItemSortList", hotItemSortList);
		
		List<Integer> hotItemNoList = new ArrayList<>();
		for(Item hotItemNo : hotItemSortList) {
			hotItemNoList.add(hotItemNo.getItem_no());
		}
		List<String> hotImgList = ItemImgDAO.getInstance().getItemImgListByItemList(hotItemNoList);
		request.setAttribute("hotImgList", hotImgList);
		
		List<String> hotUserNicknameList = UserDAO.getInstance().getHotItemSortUserNicknameList(hotItemSortList);
		request.setAttribute("hotUserNicknameList", hotUserNicknameList);
		
		if(request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
			return null;
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("isZzim", ZzimDAO.getInstance().isZzimInItemNoByLog(item_no, log));
		
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		
		List<String> itemImgList = ItemImgDAO.getInstance().getAllItemImgList(item_no);
		request.setAttribute("itemImgList", itemImgList);
		
		return "item/itemInfo";
	}

}
