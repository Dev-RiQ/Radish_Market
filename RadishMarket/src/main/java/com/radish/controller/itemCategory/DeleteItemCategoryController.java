package com.radish.controller.itemCategory;

import java.io.IOException;

import com.radish.dao.ItemCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteItemCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int item_category_no = Integer.parseInt(request.getParameter("item_category_no"));
		
		if(ItemCategoryDAO.getInstance().deleteItemCategory(item_category_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "아이템 카테고리 삭제 완료", "listItemCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 아이템 카테고리 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
