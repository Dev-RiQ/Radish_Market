package com.radish.controller.comment;

import java.io.IOException;

import com.radish.dao.CommentDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Comment;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		String comment_content = request.getParameter("comment_content");
		int check_update = 1;
		
		Comment comment = new Comment(comment_no, comment_content, check_update);
		
		if(CommentDAO.getInstance().updateAComment(comment))
			AlertUtil.getInstance().goUrlWithAlert(response, "댓글 수정 완료", "infoBoard.do?board_no="+board_no);
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 댓글 수정에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
