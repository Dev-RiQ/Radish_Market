package com.radish.controller.itemCategory;

import java.io.IOException;

import com.radish.dao.ItemCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.ItemCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateItemCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int item_category_no = Integer.parseInt(request.getParameter("item_category_no"));
		
		if(request.getParameter("item_category_name") == null) {
			request.setAttribute("item_category_no", item_category_no);
			request.setAttribute("item_category_name", ItemCategoryDAO.getInstance().getAitemCategoryName(item_category_no));
			return "itemCategory/itemCategoryUpdate";
		}
		
		String item_category_name = request.getParameter("item_category_name");
		
		ItemCategory itemCategory = new ItemCategory(item_category_no, item_category_name);
		if(ItemCategoryDAO.getInstance().updateItemCategory(itemCategory))
			AlertUtil.getInstance().goUrlWithAlert(response, "아이템 카테고리 수정 완료", "listItemCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 아이템 카테고리 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
