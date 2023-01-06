package com.accenture.main;

import java.util.Scanner;

import com.accenture.entities.StudentEntity;
import com.accenture.interfaces.Manager;
import com.accenture.manager.HibernateManager;

public class Launch {
	public static void main(String[] args) {
		Manager m = new HibernateManager();
		m.connect();
		
//		StudentEntity se = new StudentEntity("YanHong","Lai","random@gmail.com");
//		m.addStudent(se);
//		// Upper and Lowercase gotta be careful
//		m.fetchByFirstName("YanHong");
//		m.fetchById(2);
//		m.updateEmail("blahhhh@gmail.com", 1);
//		m.deleteStudent(3);
		
		/*
		 * 1. Add Student
		 * 2. Fetch All Data based on First Name
		 * 3. Fetch all data based on ID
		 * 4. Update Email by ID
		 * 5. Delete Student by ID
		 * X. Exit
		 */
		Scanner sc = new Scanner(System.in);
		outer:
		while (true) {
			System.out.println("Welcome to Student Info Database:\n"
					+ "1) Add Student\n"
					+ "2) Find Student by First Name\n"
					+ "3) Find Student by ID\n"
					+ "4) Update Student Email by ID\n"
					+ "5) Delete Student Info By ID\n"
					+ "X) Exit\n"
					+ "Enter Input: ");
			String value = sc.nextLine();
			switch(value.toLowerCase()) {
			
				case "1":
					StudentEntity newSE = new StudentEntity();
					
					System.out.println("Enter Student First Name: ");
					newSE.setSfn(sc.nextLine());
					System.out.println("Enter Student Last Name: ");
					newSE.setSln(sc.nextLine());
					System.out.println("Enter Student Email:");
					newSE.setSemail(sc.nextLine());
					m.addStudent(newSE);
					break;
					
				case "2":
					System.out.println("Enter Student First Name: ");
					String searchFN = sc.nextLine();
					m.fetchByFirstName(searchFN);
					break;
					
				case "3":
					System.out.println("Enter Student ID to search:");
					int searchID = sc.nextInt();
					m.fetchById(searchID);
					break;
					
				case "4":
					System.out.println("Enter Student ID to Search");
					int searchID2 = sc.nextInt();
					StudentEntity updateRes = m.fetchById(searchID2);
					System.out.println("Enter new Email to change");
					updateRes.setSemail(sc.nextLine());
					m.updateEmail(updateRes.getSemail(), searchID2);
					
					break;
					
				case "5":
					System.out.println("Enter Student ID to Delete");
					int searchID3 = sc.nextInt();
					m.deleteStudent(searchID3);
					break;
					
				case "x":
					break outer;
					
				default:
					break;
			}
			
//			break;
		}
	}
}
