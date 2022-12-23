package com.accenture.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.CustomerInfoModel;
import com.accenture.utils.Utils;

/**
 * Servlet implementation class RetrieveCustomers
 */
public class RetrieveCustomers extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet res = CustomerInfoModel.getAllCustomers();
		HttpSession session = req.getSession(true);
		session.setAttribute("results", res);
		
		resp.sendRedirect(Utils.PROJ_NAME_DIR+"/AdminInterface.jsp");
		
	}

}
