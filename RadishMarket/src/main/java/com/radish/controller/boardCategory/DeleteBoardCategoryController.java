package com.radish.controller.boardCategory;

import java.io.IOException;

import com.radish.dao.BoardCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBoardCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_category_no = Integer.parseInt(request.getParameter("board_category_no"));
		
		if(BoardCategoryDAO.getInstance().deleteBoardCategory(board_category_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시판 카테고리 삭제 완료", "listBoardCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시판 카테고리 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
