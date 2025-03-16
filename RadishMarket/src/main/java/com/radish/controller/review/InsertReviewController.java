package com.radish.controller.review;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.dao.ReviewDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Review;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertReviewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		String review_content = request.getParameter("review_content");
		if(review_content == null) {
			String item_img = "아이템 이미지 1장";
			request.setAttribute("item", ItemDAO.getInstance().getAItemByItemNo(item_no));
			request.setAttribute("item_img", item_img);
			return "utils/reviewInsert";
		}
		
		int review_deg = Integer.parseInt(request.getParameter("review_deg"));
		int sell_user_no = Integer.parseInt(request.getParameter("sell_user_no"));
		int buy_user_no = Integer.parseInt(request.getParameter("buy_user_no"));
		
		Review review = new Review(sell_user_no, buy_user_no, item_no, review_deg, review_content);
		if(ReviewDAO.getInstance().insertAReview(review))
			AlertUtil.getInstance().goHomeWithAlert(response, "리뷰 등록 완료");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 리뷰 등록에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
