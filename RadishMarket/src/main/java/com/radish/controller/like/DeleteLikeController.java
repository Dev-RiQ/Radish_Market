package com.radish.controller.like;

import java.io.IOException;

import com.radish.dao.LikeDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Like;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteLikeController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		Like like = new Like(board_no, user_no);
		
		if(LikeDAO.getInstance().deleteLike(like))
			AlertUtil.getInstance().goUrlWithAlert(response, "좋아요--", "infoBoard.do?board_no="+board_no);
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 좋아요 취소에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
