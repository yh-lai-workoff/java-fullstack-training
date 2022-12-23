package com.accenture.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.AdminModel;
import com.accenture.model.CustomerInfoModel;
import com.accenture.utils.Utils;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DEBUG: Servlet LoginUser received REQUEST.");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String userType = req.getParameter("usertype");
		
		if (userType.equals("customer")) {
			CustomerInfoModel cim = new CustomerInfoModel(username, password);
			if (cim.loginCustomer()) {
				resp.sendRedirect(Utils.PROJ_NAME_DIR+"/CustomerInterface.jsp");
			} else {
				System.out.println("DEBUG: Customer Login Failed");
				resp.sendRedirect(Utils.PROJ_NAME_DIR+"/LoginFailed.jsp");
			}
		} else if (userType.equals("admin")) {
			AdminModel am = new AdminModel(username, password);
			if(am.loginAdmin()) {
				HttpSession session = req.getSession(true);
				session.setAttribute("username", username);
				resp.sendRedirect(Utils.PROJ_NAME_DIR+"/AdminInterface.jsp");
			} else {
				// TODO: Redirect to Login Failed
				System.out.println("DEBUG: Admin Login Failed");
				resp.sendRedirect(Utils.PROJ_NAME_DIR+"/LoginFailed.jsp");

			}
		}
	}
}
