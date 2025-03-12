package com.radish.frontController;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
