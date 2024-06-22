package com.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession httpsession = request.getSession();
			httpsession.removeAttribute("user");
			httpsession.setAttribute("logoutMsg", "Logout Successfully");
			response.sendRedirect("loginRegister.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
