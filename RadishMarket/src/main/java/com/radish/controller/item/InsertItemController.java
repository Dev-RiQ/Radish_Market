package com.radish.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.ItemCategoryDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Item;
import com.radish.vo.ItemCategory;
import com.radish.vo.ItemImg;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용해주세요.");
			return null;
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserByLog(log));
		
		List<ItemCategory> itemCategoryList = ItemCategoryDAO.getInstance().getAllItemCategoryList();
		request.setAttribute("itemCategoryList", itemCategoryList);
		if(request.getParameter("item_name") == null) {
			return "item/itemInsert";
		}

		int item_category_no = Integer.parseInt(request.getParameter("item_category_no"));
		String item_name = request.getParameter("item_name");
		String item_content = request.getParameter("item_content");
		int item_price = Integer.parseInt(request.getParameter("item_price"));
		String item_reg_datetime = DateUtil.getInstance().getRegDatetime();
		String item_gu = request.getParameter("item_gu");
		String item_dong = request.getParameter("item_dong");
		Item item = new Item(log, item_category_no, item_name, item_content, item_price, item_reg_datetime, item_reg_datetime, 1, item_gu, item_dong);
		Boolean check = ItemDAO.getInstance().insertItem(item);
		
		if(item != null) {
			String uploadFileNames = request.getParameter("user_item_img");
			String[] uploadFileName = uploadFileNames.split(", ");
			
			int lastItemNo = ItemDAO.getInstance().getLastItemNo();
			
			List<ItemImg> list = new ArrayList<>();
			for(String item_img : uploadFileName) {
				list.add(new ItemImg(item_img, lastItemNo));
			}
			
			if(ItemImgDAO.getInstance().insertItemImg(list) == 0) {
				AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 판매글 이미지 등록에 실패했습니다.\\\\n다시 시도해주세요.");
				return null;
			};
		}
		
		String user_nickname = UserDAO.getInstance().getAUserNicnameByUserNo(log);
		
		if(check)
			AlertUtil.getInstance().goUrlWithAlert(response, user_nickname + "님 판매글 등록 완료!.", "listItem.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 판매글 등록에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
