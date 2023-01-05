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
		m.fetch("YanHong");
	}
}
