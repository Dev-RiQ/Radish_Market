package com.radish.controller.itemCategory;

import java.io.IOException;

import com.radish.dao.ItemCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertItemCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("item_category_name") == null) {
			return "itemCategory/itemCategoryInsert";
		}
		
		String item_category_name = request.getParameter("item_category_name");
		
		if(ItemCategoryDAO.getInstance().insertItemCategory(item_category_name))
			AlertUtil.getInstance().goUrlWithAlert(response, "아이템 카테고리 추가 완료", "listItemCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 아이템 카테고리 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
