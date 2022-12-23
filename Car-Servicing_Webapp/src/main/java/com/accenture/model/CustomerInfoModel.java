package com.accenture.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.accenture.utils.Utils;

public class CustomerInfoModel {
	private String name;
	private String username;
	private String password;
	private String email;

	private static final String DB_NAME = "car_service_example";
	private static final String TABLE_NAME = "customers_db";

	private final String usernameSearch = "SELECT * FROM " + TABLE_NAME + " WHERE username = ?";
	private final String insertStatement = "INSERT INTO " + TABLE_NAME + " VALUES (?,?,?,?)";
	private final String loginStatement = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?";
	private static final String FETCH_ALL_STATEMENT = "SELECT * FROM " + TABLE_NAME;

	public CustomerInfoModel(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = null;
		this.email = null;
	}

	public CustomerInfoModel(String name, String username, String password, String email) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int registerCustomer() {
		if (name == null || email == null)
			return -1;
		try {
			Connection conn = Utils.getConnection(DB_NAME, "root", "root");
			PreparedStatement ps = conn.prepareStatement(usernameSearch);
			ps.setString(1, username);
			ResultSet res = ps.executeQuery();
			if (!res.next()) {
				PreparedStatement insert = conn.prepareStatement(insertStatement);
				insert.setString(1, name);
				insert.setString(2, username);
				insert.setString(3, password);
				insert.setString(4, email);
				return insert.executeUpdate();
			} else {
				return -1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public boolean loginCustomer() {
		try {
			Connection conn = Utils.getConnection(DB_NAME);
			PreparedStatement login = conn.prepareStatement(loginStatement);
			ResultSet res = login.executeQuery();
			if (res.next()) {
				this.name = res.getString(1);
				this.email = res.getString(4);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet getAllCustomers() {
		Connection conn;
		try {
			conn = Utils.getConnection(DB_NAME);
			ResultSet res = conn.createStatement().executeQuery(FETCH_ALL_STATEMENT);
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
