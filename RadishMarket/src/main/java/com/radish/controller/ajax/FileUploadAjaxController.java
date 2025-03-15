package com.radish.controller.ajax;

import java.io.IOException;
import java.util.Arrays;

import com.radish.frontController.Controller;
import com.radish.util.FileUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FileUploadAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String beforeFileName = request.getParameter("beforeFileName");
		if(beforeFileName != null) {
			FileUtil.getInstance().deleteFile(request, beforeFileName);
		}else {
			String[] sFileName = FileUtil.getInstance().uploadFile(request, response);
			response.getWriter().print(Arrays.toString(sFileName));
		}
		return null;
	}

}
