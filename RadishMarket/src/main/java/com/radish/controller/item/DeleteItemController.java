package com.radish.controller.item;

import java.io.IOException;

import com.radish.dao.ItemDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteItemController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		if(ItemDAO.getInstance().deleteAItem(item_no))
			AlertUtil.getInstance().goUrlWithAlert(response, "아이템 삭제 완료", log == -1 ? "itemManage.do" : "listItem.do");
		else
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 아이템 삭제에 실패했습니다.\\n다시 시도해주세요.");
		return null;
	}

}
