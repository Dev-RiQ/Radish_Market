package com.radish.controller.ajax;

import java.io.IOException;

import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewModeAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Object browserSetMode = request.getSession().getAttribute("browserSetMode");
		String mode = null;
		if(browserSetMode == null) {
			mode = request.getParameter("browserSetMode");
		}else {
			mode = request.getParameter("mode");
			if(mode.equals(request.getSession().getAttribute("mode"))) {
				return null;
			}
		}
		if(request.getSession().getAttribute("log") != null)
			request.getSession().setAttribute("browserSetMode", mode);
			request.getSession().setAttribute("mode", mode);
		response.getWriter().print(mode);
		return null;
	}

}
