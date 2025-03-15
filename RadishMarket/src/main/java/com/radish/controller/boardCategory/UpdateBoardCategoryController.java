package com.radish.controller.boardCategory;

import java.io.IOException;

import com.radish.dao.BoardCategoryDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.BoardCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardCategoryController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_category_no = Integer.parseInt(request.getParameter("board_category_no"));
		
		if(request.getParameter("board_category_name") == null) {
			request.setAttribute("board_category_no", board_category_no);
			request.setAttribute("board_category_name", BoardCategoryDAO.getInstance().getABoardCategoryName(board_category_no));
			return "boardCategory/boardCategoryUpdate";
		}
		
		String board_category_name = request.getParameter("board_category_name");
		
		BoardCategory boardCategory = new BoardCategory(board_category_no, board_category_name);
		if(BoardCategoryDAO.getInstance().updateBoardCategory(boardCategory))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시판 카테고리 수정 완료", "listBoardCategory.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시판 카테고리 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
