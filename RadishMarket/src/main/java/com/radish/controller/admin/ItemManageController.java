package com.radish.controller.admin;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ItemManageController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("itemList", ItemDAO.getInstance().getAllItemList());
		return "admin/itemManage";
	}

}
