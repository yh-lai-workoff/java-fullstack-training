package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.CustomerInfoModel;

/**
 * Servlet implementation class RegisterCustomer
 */
public class RegisterCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("personname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		System.out.println("DEBUG: Servlet RegisterCustomer received REQUEST.");
		
		CustomerInfoModel m = new CustomerInfoModel(name, username, password, email);
		HttpSession session = req.getSession(true);
		if (m.registerCustomer() < 0) {
			session.setAttribute("username", username);
			resp.sendRedirect("/Car-Servicing_Webapp/DuplicateName.jsp");
		} else {
			session.setAttribute("name", name);
			resp.sendRedirect("/Car-Servicing_Webapp/RegisterSuccess.jsp");
		}
	}
	

}
