package com.radish.util;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AlertUtil {
	private AlertUtil() {
	}

	private static AlertUtil instance;

	public static AlertUtil getInstance() {
		if (instance == null)
			instance = new AlertUtil();
		return instance;
	}

	public void goHomeWithAlert(HttpServletResponse response, HttpServletRequest request, String msg)
			throws IOException {
		String ctx = request.getContextPath();
		String alertMsg = "<script>alert('%s'); location.href='%s/%s'</script>";
		go(response, String.format(alertMsg, msg, ctx, "index.jsp"));
	}

	public void goBackWithAlert(HttpServletResponse response, String msg) throws IOException {
		String alertMsg = "<script>alert('%s'); history.back() </script>";
		go(response, String.format(alertMsg, msg));
	}

	public void goUrlWithAlert(HttpServletResponse response, HttpServletRequest request, String msg, String url)
			throws IOException {
		String ctx = request.getContextPath();
		String alertMsg = "<script>alert('%s'); location.href='%s/%s'</script>";
		go(response, String.format(alertMsg, msg, ctx, url));
	}

	private void go(HttpServletResponse response, String msg) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(msg);
		writer.close();
	}
}
