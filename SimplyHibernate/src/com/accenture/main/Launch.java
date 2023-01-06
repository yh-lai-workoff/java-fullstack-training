package com.accenture.main;

import com.accenture.entities.StudentEntity;
import com.accenture.interfaces.Manager;
import com.accenture.manager.HibernateManager;

public class Launch {
	public static void main(String[] args) {
		Manager m = new HibernateManager();
		m.connect();
		
		StudentEntity se = new StudentEntity("YanHong","Lie","random@gmail.com");
//		m.addStudent(se);
		// Upper and Lowercase gotta be careful
		m.fetchByFirstName("YanHong");
		m.fetchById(2);
//		m.updateEmail("blahhhh@gmail.com", 1);
		m.deleteStudent(3);
	}
}
