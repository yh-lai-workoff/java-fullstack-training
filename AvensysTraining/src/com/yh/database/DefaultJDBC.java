package com.yh.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DefaultJDBC {
	final static String SQL_DB_NAME = "testdb";
	final static String SQL_DB_UN = "root";
	final static String SQL_DB_PW = "root";
	public static void main(String[] args) throws SQLException {
		Connection sqlDB = SQLUtils.getConnection(SQL_DB_NAME, SQL_DB_UN, SQL_DB_PW);
		
		String query = "select * from TestTable where studentID=?";
		PreparedStatement ps =  sqlDB.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter StudentID:");
		int placeHolderID = sc.nextInt();
		
		ps.setInt(1, placeHolderID);
		
		
		
//		Statement start = sqlDB.createStatement();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String firstName = rs.getString(3);
			int score = rs.getInt(4);
			
			System.out.println(id + " "+name+" "+firstName+" "+score);
		}
		
		String deleteQuery = "delete from TestTable where studentID=?";
		PreparedStatement deleteStatement = sqlDB.prepareStatement(deleteQuery);
		System.out.println("Select StudentID to delete:");
		deleteStatement.setInt(1, sc.nextInt());
		deleteStatement.executeUpdate();
		
		/*
		 * Part where insert multiple when changing prepared statement
		 */
		
//		String update = "insert into TestTable values (?,?,?,?)";
//		PreparedStatement ps2 = sqlDB.prepareStatement(update);
//		System.out.println("Enter new StudentID:");
//		ps2.setInt(1, sc.nextInt());
//		System.out.println("Enter new LastName:");
//		ps2.setString(2, sc.next());
//		System.out.println("Enter new FirstName:");
//		ps2.setString(3, sc.next());
//		System.out.println("Enter new score:");
//		ps2.setInt(4, sc.nextInt());
//		
//		ps2.executeUpdate();
//		
//		System.out.println("Enter new StudentID:");
//		ps2.setInt(1, sc.nextInt());
//		System.out.println("Enter new LastName:");
//		ps2.setString(2, sc.next());
//		System.out.println("Enter new FirstName:");
//		ps2.setString(3, sc.next());
//		System.out.println("Enter new score:");
//		ps2.setInt(4, sc.nextInt());
//		
//		ps2.executeUpdate();
		
		
		/*
		 * Test of changing preparedstatements
		 */
		
//		ps.setInt(1, 2);
//		rs = ps.executeQuery();
//		while(rs.next()) {
//			int id = rs.getInt(1);
//			String name = rs.getString(2);
//			String firstName = rs.getString(3);
//			int score = rs.getInt(4);
//			
//			System.out.println(id + " "+name+" "+firstName+" "+score);
//		}
//		ps.setInt(1, 1);
//		rs = ps.executeQuery();
//		while(rs.next()) {
//			int id = rs.getInt(1);
//			String name = rs.getString(2);
//			String firstName = rs.getString(3);
//			int score = rs.getInt(4);
//			
//			System.out.println(id + " "+name+" "+firstName+" "+score);
//		}
		
		sqlDB.close();
	}
}
