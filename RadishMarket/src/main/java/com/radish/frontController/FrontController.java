package com.radish.frontController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
@MultipartConfig(
	maxFileSize = 1024 * 1024 * 1,  //1MB
	maxRequestSize = 1024 * 1024 * 10  //10MB
)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = url.substring(ctx.length());
		
		Controller controller = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		String nextPage = controller.requestHandler(request, response);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1)
				response.sendRedirect(ctx + "/" + nextPage.split(":")[1] + ".do");
			else {
				request.setAttribute("section", ctx + ViewResolver.makeView(nextPage));
				request.getRequestDispatcher(ctx + ViewResolver.makeView("main/main"))
				.forward(request, response);
			}
		}
	}

}