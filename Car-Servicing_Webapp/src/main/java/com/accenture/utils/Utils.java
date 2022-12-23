package com.accenture.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Utils {
	public final static String PROJ_NAME_DIR = "/Car-Servicing_Webapp";
	
	public static Connection getConnection(String database, String username, String password) throws SQLException {
		DriverManager.registerDriver(new Driver());
		System.out.println("Driver loaded Successfully.");

		Connection output = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
		System.out.println("Connection established successfully.");
		return output;
	}

	public static Connection getConnection(String database) throws SQLException {
		return getConnection(database, "root", "root");
	}
}