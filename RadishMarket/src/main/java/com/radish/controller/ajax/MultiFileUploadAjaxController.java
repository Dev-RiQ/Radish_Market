package com.radish.controller.ajax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import com.radish.frontController.Controller;
import com.radish.util.FileUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class MultiFileUploadAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		int item_no = Integer.parseInt(request.getParameter("item_no"));
		System.out.println("item_no: " + item_no);

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getName().equals("files") && part.getSize() > 0) {
				String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				System.out.println(fileName);
			}
		}

		//response.getWriter().write("{\"status\": \"success\"}");
		
		return null;
	}
	
}
