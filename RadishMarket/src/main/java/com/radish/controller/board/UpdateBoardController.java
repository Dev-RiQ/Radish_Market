package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		if(request.getParameter("board_title") == null) {
			request.setAttribute("boardCategoryList", null);
			request.setAttribute("board", BoardDAO.getInstance().getABoardByBoardNo(board_no));
			return "board/boardUpdate";
		}
		
		int board_category_no = Integer.parseInt(request.getParameter("board_category_no"));
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_update_datetime = DateUtil.getInstance().getRegDatetime();
		String board_img = request.getParameter("board_img");
		
		Board board = new Board(board_no, board_category_no, board_title, board_content, board_update_datetime, board_img);
		if(BoardDAO.getInstance().boardUpdate(board))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시글 수청 완료", "infoBoard.do?board_no="+board_no);
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시글 수정에 실패했습니다.\\n다시 시도해주세요.");
		
		return null;
	}

}
