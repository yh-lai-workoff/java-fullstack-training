package com.accenture.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.accenture.entities.StudentEntity;
import com.accenture.interfaces.Manager;

public class HibernateManager implements Manager {

	SessionFactory f;
	Session session;
	
	@Override
	public void connect() {
		f = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(StudentEntity.class).buildSessionFactory();
		session = f.getCurrentSession();
		System.out.println("INFO: Connected to Database");
	}
	
	@Override
	public void addStudent(StudentEntity s) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		session.save(s);
		t.commit();
		System.out.println("Student Data ADDED");
	}

	@Override
	public void fetch(String sfn) {
		// TODO Auto-generated method stub
		Transaction t = f.getCurrentSession().beginTransaction();
		List details = session.createQuery("FROM StudentEntity s WHERE s.sfn = '%s'".formatted(sfn)).list();
		for (StudentEntity s: (List<StudentEntity>) details) {
			System.out.println(s.toString());
		}
		t.commit();
	}

}
