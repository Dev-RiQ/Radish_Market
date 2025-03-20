package com.radish.controller.review;

import java.io.IOException;

import com.radish.dao.AlarmDAO;
import com.radish.dao.CartDAO;
import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
import com.radish.dao.ReviewDAO;
import com.radish.dao.UserDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Cart;
import com.radish.vo.Item;
import com.radish.vo.Review;
import com.radish.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertReviewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		String review_content = request.getParameter("review_content");
		
		String alarm_no_str = request.getParameter("alarm_no");
		if(alarm_no_str != null) {
			int alarm_no = Integer.parseInt(alarm_no_str);
			AlarmDAO.getInstance().setAlarmCheck(alarm_no);
		}
		
		if(review_content == null) {
			Item item = ItemDAO.getInstance().getAItemByItemNo(item_no);
			request.setAttribute("item", item);
			request.setAttribute("item_img", ItemImgDAO.getInstance().getAItemImg(item_no));
			return "utils/reviewInsert";
		}
		
		int review_deg = Integer.parseInt(request.getParameter("review_deg"));
		int sell_user_no = Integer.parseInt(request.getParameter("sell_user_no"));
		int buy_user_no = Integer.parseInt(request.getParameter("buy_user_no"));
		
		Review review = new Review(sell_user_no, buy_user_no, item_no, review_deg, review_content);
		if(ReviewDAO.getInstance().insertAReview(review)) {
			AlertUtil.getInstance().goHomeWithAlert(response, "리뷰 등록 완료");
			Cart cart = new Cart(item_no, buy_user_no, 0);
			CartDAO.getInstance().setCheckReviewed(cart);
			int nowDeg = UserDAO.getInstance().getAUserByLog(sell_user_no).getUser_deg();
			int afterDeg = nowDeg + review_deg;
			if(afterDeg < 0)
				afterDeg = 0;
			if(afterDeg > 100)
				afterDeg = 100;
			User user = new User(sell_user_no, afterDeg);
			UserDAO.getInstance().setReviewDegree(user);
		}
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 리뷰 등록에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
