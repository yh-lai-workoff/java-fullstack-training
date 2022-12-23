package com.accenture.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.utils.Utils;

public class AdminModel {
	private String username;
	private String password;
	
	private final String dbName = "car_service_example";
	private final String tableName = "admin_db";
	
	private final String loginStatement = "SELECT * FROM "+tableName+" WHERE a_username = ? AND a_password = ?";
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public boolean loginAdmin() {
		try {
			Connection conn = Utils.getConnection(dbName);
			PreparedStatement login = conn.prepareStatement(loginStatement);
			login.setString(1, username);
			login.setString(2, password);
			ResultSet res = login.executeQuery();
			return res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
