package com.radish.controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.radish.dao.AlarmDAO;
import com.radish.dao.BoardCategoryDAO;
import com.radish.dao.BoardDAO;
import com.radish.dao.CommentDAO;
import com.radish.dao.EmojiDAO;
import com.radish.dao.LikeDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.util.DateUtil;
import com.radish.util.DongUtil;
import com.radish.vo.Board;
import com.radish.vo.Comment;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InfoBoardController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int board_no = Integer.parseInt(request.getParameter("board_no"));

		BoardDAO.getInstance().boardHitsUp(board_no);
		Board board = BoardDAO.getInstance().getABoardByBoardNo(board_no);
		request.setAttribute("board", board);

		String BoardUpdateDatetime = DateUtil.getInstance().getCalcDateAgo(board.getBoard_update_datetime());
		request.setAttribute("BoardUpdateDatetime", BoardUpdateDatetime);

		String category_name = BoardCategoryDAO.getInstance().getABoardCategoryName(board.getBoard_category_no());
		request.setAttribute("category_name", category_name);

		User user = UserDAO.getInstance().getAUserPortionInfo(board.getUser_no());
		request.setAttribute("user", user);
		request.setAttribute("emoji", EmojiDAO.getInstance().getEmoji(user.getUser_deg()));

		request.setAttribute("likeCount", LikeDAO.getInstance().getCountLikeByBoardNo(board_no));

		List<Comment> commentList = CommentDAO.getInstance().getCommentListByBoard(board_no);
		request.setAttribute("commentList", commentList);

		List<Integer> commentUserNoList = new ArrayList<>();
		for (Comment e : commentList) {
			commentUserNoList.add(e.getUser_no());
		}
		List<String> commentUserDongList = UserDAO.getInstance().getUserDongListByUserNoList(commentUserNoList);
		request.setAttribute("commentUserDongList", commentUserDongList);
		List<String> commentUserImgList = UserDAO.getInstance().getUserImgList(commentUserNoList);
		request.setAttribute("commentUserImgList", commentUserImgList);
		
		List<String> commentUpdateTime = new ArrayList<>();
		for (Comment e : commentList) {
			String time = DateUtil.getInstance().getCalcDateAgo(e.getComment_reg_datetime());
			commentUpdateTime.add(time);
		}
		request.setAttribute("commentUpdateTime", commentUpdateTime);

		List<String> commentNickname = UserDAO.getInstance().getCommentedUserNickname(commentList);
		request.setAttribute("commentNickname", commentNickname);

		Object log_obj = request.getSession().getAttribute("log");
		int log = 0;
		if (log_obj != null) {
			log = Integer.parseInt(log_obj.toString());
			request.setAttribute("isLike", LikeDAO.getInstance().isLikedInBoardNoByLog(board_no, log));
		}

		String alarm_no_str = request.getParameter("alarm_no");
		if (alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}

		String category_no_str = request.getParameter("category_no");
		int category_no = 0;
		if (category_no_str != null)
			category_no = Integer.parseInt(category_no_str);
		Object gu_obj = request.getSession().getAttribute("gu");
		if (gu_obj == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "위치 정보를 불러올 수 없습니다.\\n로그인 또는 위치 정보 사용을 허용해주세요.");
			return null;
		}
		request.setAttribute("category_no", category_no);
		
		String gu = gu_obj.toString();
		String user_dong = request.getSession().getAttribute("dong").toString();
		if (request.getParameter("filter") != null) {
			String filter_gu = request.getParameter("gu");
			if (filter_gu != null && !filter_gu.isBlank()) {
				gu = filter_gu;
			}
			String filter_dong = request.getParameter("dong");
			if (filter_dong != null && !filter_dong.isBlank()) {
				user_dong = filter_dong;
			}
		}
		request.setAttribute("gu", gu);
		request.setAttribute("user_dong", user_dong);
		if (user_dong.equals("전체")) {
			user_dong = request.getSession().getAttribute("dong").toString();
		}
		List<String> dongList = DongUtil.getInstance().getDongFilterList(gu, user_dong);
		request.setAttribute("dongList", dongList);
		
		String order_by_str = request.getParameter("order_by");
		int order_by = 0;
		if (order_by_str != null && !order_by_str.isBlank()) {
			order_by = Integer.parseInt(order_by_str);
		}
		request.setAttribute("order_by", order_by);
		
		String meet_no_str = request.getParameter("meet_no");
		int meet_no = 0;
		if (meet_no_str != null && !meet_no_str.isBlank()) {
			meet_no = Integer.parseInt(meet_no_str);
		}
		request.setAttribute("meet_no", meet_no);
		
		request.setAttribute("categoryList", BoardCategoryDAO.getInstance().getAllBoardCategoryList());
		
		return "board/boardInfo";
	}
}