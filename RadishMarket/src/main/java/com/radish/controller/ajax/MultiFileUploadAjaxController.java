package com.radish.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.radish.frontController.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class MultiFileUploadAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		Collection<Part> parts = request.getParts();
		List<String> fileNameList = new ArrayList<>();

		String savePath = request.getServletContext().getRealPath("/images");
		File uploadDir = new File(savePath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		for (Part part : parts) {
			if (part.getName().equals("img") && part.getSize() > 0) {
				String originalFileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				String saveFileName = System.currentTimeMillis() + "_" + originalFileName;

				part.write(savePath + File.separator + saveFileName);
				fileNameList.add(saveFileName);
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(fileNameList);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();

		return null;
	}
}
