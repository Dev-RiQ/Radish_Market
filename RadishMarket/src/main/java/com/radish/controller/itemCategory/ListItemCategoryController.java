package com.radish.controller.itemCategory;

import java.io.IOException;
import java.util.List;

import com.radish.dao.ItemCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.vo.ItemCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListItemCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ItemCategory> list = ItemCategoryDAO.getInstance().getAllItemCategoryList();
		request.setAttribute("itemCategoryList", list);
		return "itemCategory/itemCategoryList";
	}

}
