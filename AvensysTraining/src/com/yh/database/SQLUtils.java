package com.yh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class SQLUtils {
	public static Connection getConnection(String database, String username, String password) throws SQLException {
		DriverManager.registerDriver(new Driver());
		System.out.println("Driver loaded Successfully.");
		
		Connection output = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, username, password);
		System.out.println("Connection established successfully.");
		return output;
	}
}
