package com.radish.controller.board;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		if(BoardDAO.getInstance().deleteABoard(board_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "게시글 삭제 완료", "listBoard.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 게시글 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
