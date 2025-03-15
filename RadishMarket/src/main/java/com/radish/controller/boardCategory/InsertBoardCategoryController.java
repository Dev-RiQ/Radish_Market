package com.radish.controller.boardCategory;

import java.io.IOException;

import com.radish.dao.BoardCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertBoardCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("board_category_name") == null) {
			return "boardCategory/boardCategoryInsert";
		}
		
		String board_category_name = request.getParameter("board_category_name");
		
		if(BoardCategoryDAO.getInstance().insertBoardCategory(board_category_name))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시판 카테고리 추가 완료", "listBoardCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시판 카테고리 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
