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
    maxFileSize = 1024 * 1024 * 5,
    maxRequestSize = 1024 * 1024 * 40
)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		
		Controller controller = null;
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(url);
		String nextPage = controller.requestHandler(request, response);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1)
				response.sendRedirect("/" + nextPage.split(":")[1] + ".do");
			else {
				request.setAttribute("section", ViewResolver.makeView(nextPage));
				request.getRequestDispatcher(ViewResolver.makeView("main/main"))
				.forward(request, response);
			}
		}
	}

}