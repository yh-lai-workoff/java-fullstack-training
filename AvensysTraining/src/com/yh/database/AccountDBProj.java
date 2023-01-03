package com.yh.database;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountDBProj {
	public static void main(String[] args) {
		DBMS dbms = new DBMS();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome!\n1) New User?\n2) Existing User!");
		try {
			switch(sc.nextInt()) {
				case 1:
					dbms.register();
					break;
				case 2:
					dbms.login();
					break;
				default:
					System.out.println("Invalid Input! Please Try Again!");
					break;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}
	
}

class DBMS implements Closeable{
	Scanner input = new Scanner(System.in);
	Connection conn;
	
	final String TABLENAME = "users";
	
	final String SEL_USERNAME = "SELECT * FROM "+TABLENAME+" WHERE username=?";
	final String SEL_LOGIN = "SELECT * FROM "+TABLENAME+" WHERE username=? AND password=?";
	
	final String INS_USER_INFO = "INSERT INTO "+TABLENAME+" VALUES (?,?,?,?,?)";
	
	DBMS(){
		try {
			this.conn = SQLUtils.getConnection("UsersTest","root" , "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void register() throws SQLException {
		System.out.println("Please input registration Information:");
		String username = "";
		do {
			System.out.println("Enter New Username: ");
			username = input.next();
		}
		while (!validate(username,1));
		String password = "";
		do {
			System.out.println("Enter Password:");
			password = input.next();
		} while(!validate(password,2));
		
		System.out.println("Enter Name:");
		String name = input.next();
		
		System.out.println("Enter Email:");
		String email = input.next();
		
		int mobile = -1;
		do {
			System.out.println("Enter Phone Number:");
			mobile = input.nextInt();
		} while(!validate(Integer.toUnsignedString(mobile),3));
		
		insertUserEntry(username, password, name, email, mobile);
		System.out.println("Successfully Registered!");
	}
	
	public void login() throws SQLException {
		System.out.println("Welcome Back!");
		String username = "";
		String password = "";
		
		for (int i = 0; i<3;i++)
		{
			System.out.println("Please enter your Username:");
			username = input.next();
			System.out.println("Please enter your Password:");
			password = input.next();
			if (validate(username,password)){
				System.out.println("Successfully Logged In!");
				return;
			}
		}
			
		
		System.out.println("Failed Login for 3 Attempts. Shutting Down...");
	}
	
	private boolean validate (String input1,String input2) throws SQLException {
		PreparedStatement checkUNPW = conn.prepareStatement(SEL_LOGIN);
		checkUNPW.setString(1, input1);
		checkUNPW.setString(2, input2);
		if(checkUNPW.executeQuery().next()) {
			return true;
		}
		else {
			System.out.println("Username and Password Login Failed!");
			return false;
		}
	}
	
	private boolean validate(String input, int mode) throws SQLException {
		
		switch(mode) {
			// Check Existing UN for Registration
			case 1:
				if (input.length() ==0) {
					System.out.println("Warning! Please Enter Username!");
					return false;
				}
				else {
					PreparedStatement checkUN = conn.prepareStatement(SEL_USERNAME);
					checkUN.setString(1, input);
					return !checkUN.executeQuery().next();
				}
			// Check Password Length and other stuff
			case 2:
				if (input.length() <8) {
					System.out.println("Password Length should be >=8");
					return false;
				}
				else
					return true;
			// Check Phone Number during registration
			case 3:
				if (input.length() == 8)
					return true;
				else {
					System.out.println("Phone Number should be 8 digits");
				}
				
			default:
				break;
		}
		return false;
	}
	
	private void insertUserEntry(String username, String password, String name, String email, int mobile) throws SQLException {
		PreparedStatement pushNewUser = conn.prepareStatement(INS_USER_INFO);
		pushNewUser.setString(1, username);
		pushNewUser.setString(2, password);
		pushNewUser.setString(3, name);
		pushNewUser.setString(4, email);
		pushNewUser.setInt(5, mobile);
		pushNewUser.executeUpdate();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.conn = null;
	}
	
}


