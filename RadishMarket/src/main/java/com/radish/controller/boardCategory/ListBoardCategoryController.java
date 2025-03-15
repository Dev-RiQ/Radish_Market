package com.radish.controller.boardCategory;

import java.io.IOException;
import java.util.List;

import com.radish.dao.BoardCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.vo.BoardCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBoardCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardCategory> list = BoardCategoryDAO.getInstance().getAllBoardCategoryList();
		request.setAttribute("boardCategoryList", list);
		return "boardCategory/boardCategoryList";
	}

}
