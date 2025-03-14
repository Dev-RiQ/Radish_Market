package com.radish.controller.zzim;

import java.io.IOException;

import com.radish.dao.ZzimDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Zzim;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteZzimController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goBackWithAlert(response, "로그인 후 이용해주세요.");
			return null;
		}
		
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		int user_no = Integer.parseInt(request.getSession().getAttribute("log").toString());
		
		Zzim zzim = new Zzim(item_no, user_no);
		
		if(ZzimDAO.getInstance().deleteZzim(zzim)) {
			AlertUtil.getInstance().goUrlWithAlert(response, "찜--", "infoItem.do?item_no=" + item_no);
		}else {
			AlertUtil.getInstance().goBackWithAlert(response, "서버 오류로 인해 찜하기 취소에 실패했습니다.\\n다시 시도해주세요.");
		}
		return null;
	}

}
