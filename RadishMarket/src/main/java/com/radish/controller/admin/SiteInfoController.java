package com.radish.controller.admin;

import java.io.IOException;

import com.radish.frontController.Controller;
import com.radish.util.AlertUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SiteInfoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object log = request.getSession().getAttribute("log");
		if(log == null || Integer.parseInt(log.toString()) != -1) {
			AlertUtil.getInstance().goBackWithAlert(response, "접근 권한이 없습니다.");
		}
		return "admin/siteInfo";
	}

}
