package com.radish.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.radish.frontController.Controller;
import com.radish.util.FileUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MultiFileUploadAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
        String[] uploadedFiles = FileUtil.getInstance().multipleFile(request, response);

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"success\":").append(uploadedFiles.length > 0).append(",");
        
        if (uploadedFiles.length > 0) {
            json.append("\"files\":").append(Arrays.toString(uploadedFiles));
        } else {
            json.append("\"message\":\"업로드된 파일이 없습니다.\"");
        }
        json.append("}");
        
        response.setContentType("application/json; charset=UTF-8");
        out.print(json.toString());
        out.flush();

        return null;
	}

}
