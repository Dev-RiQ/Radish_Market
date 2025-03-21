package com.radish.controller.myPage;

import java.io.IOException;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.UserDAO;
import com.radish.dao.ZzimDAO;
import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;
import com.radish.vo.Item;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class zzimListUserController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession() == null || request.getSession().getAttribute("log") == null) {
			AlertUtil.getInstance().goHomeWithAlert(response, "로그인 후 이용해주세요.");
		}
		
		int log = Integer.parseInt(request.getSession().getAttribute("log").toString());
		request.setAttribute("user", UserDAO.getInstance().getAUserPortionInfo(log));
		
		int zzimListSizeInt = ZzimDAO.getInstance().getZzimListSize(log);
		String zzimListSize = "";
		if(zzimListSizeInt > 100) {
			zzimListSize = "100+";
		}else {
			zzimListSize = zzimListSizeInt+"";
		}
		request.setAttribute("zzimListSize", zzimListSize);
		return "myPage/userZzimList";
	}

}
