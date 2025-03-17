package com.radish.controller.myPage;

import java.io.IOException;
import java.util.List;

import com.radish.dao.ItemDAO;
import com.radish.dao.ItemImgDAO;
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
		
		List<Integer> itemNoList = ZzimDAO.getInstance().getAUserZzimItemNoList(log);
		List<Item> zzimList = ItemDAO.getInstance().getAUserAllZzimItemList(itemNoList);
		List<String> userDongList = UserDAO.getInstance().getLimitUserDongByItemList(zzimList);
		request.setAttribute("zzimList", zzimList);
		request.setAttribute("userDongList", userDongList);
		
		List<String> mainImgList = ItemImgDAO.getInstance().getItemImgListByItemList(itemNoList);
		request.setAttribute("mainImgList", mainImgList);
		
		return "myPage/userZzimList";
	}

}
