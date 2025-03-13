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

public class InsertBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("board_title") == null) {
			request.setAttribute("boardCategoryList", null);
			return "board/boardInsert";
		}
		
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		int board_category_no = Integer.parseInt(request.getParameter("board_category_no"));
		int meet_no = Integer.parseInt(request.getParameter("meet_no"));
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		String board_reg_datetime = DateUtil.getInstance().getRegDatetime();
		String board_update_datetime = board_reg_datetime;
		String board_img = request.getParameter("board_img");
		
		Board board = new Board(user_no, board_category_no, meet_no, board_title, board_content, board_reg_datetime, board_update_datetime, board_img);
		if(BoardDAO.getInstance().boardInsert(board))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시글 추가 완료", "infoBoard.do?board_no="+BoardDAO.getInstance().getLastBoardNo());
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시글 추가에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
