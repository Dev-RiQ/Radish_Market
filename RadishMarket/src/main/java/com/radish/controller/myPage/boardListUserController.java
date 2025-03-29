package com.radish.controller.myPage;

import java.io.IOException;

import com.radish.dao.BoardDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class boardListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("log") == null || request.getSession() == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		User user = UserDAO.getInstance().getAUserPortionInfo(log);
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));
		
		int boardListSizeInt = BoardDAO.getInstance().getBoardListSize(log);
		String boardListSize = "";
		if(boardListSizeInt > 100) {
			boardListSize = "100+";
		}else {
			boardListSize = boardListSizeInt+"";
		}
		request.setAttribute("boardListSize", boardListSize);
		request.setAttribute("isMyPage", true);
		return "myPage/userBoardList";
	}

}
