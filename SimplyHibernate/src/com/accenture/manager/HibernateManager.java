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
	private Transaction t;
	
	@Override
	public void connect() {
		this.f = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(StudentEntity.class).buildSessionFactory();
		this.session = this.f.getCurrentSession();
		System.out.println("INFO: Connected to Database");
	}
	
	@Override
	public void addStudent(StudentEntity s) {
		// TODO Auto-generated method stub
		if(!this.session.isOpen())
			this.session = f.getCurrentSession();
		this.t = this.session.beginTransaction();
		this.session.save(s);
		this.t.commit();
		System.out.println("Student Data ADDED");
	}

	@Override
	public void fetchByFirstName(String sfn) {
		// TODO Auto-generated method stub
		if(!this.session.isOpen())
			this.session = f.getCurrentSession();
		this.t = this.session.beginTransaction();
		List details = this.session.createQuery("FROM StudentEntity s WHERE s.sfn = '%s'".formatted(sfn)).list();
		for (StudentEntity s: (List<StudentEntity>) details) {
			System.out.println(s.toString());
		}
		this.t.commit();
	}

	@Override
	public StudentEntity fetchById(int id) {
		System.out.println(this.session.isOpen());
		if(!this.session.isOpen())
			this.session = f.getCurrentSession();
		this.t = this.session.beginTransaction();
		StudentEntity details = (StudentEntity) this.session.createQuery("FROM StudentEntity s WHERE s.sid = '%d'".formatted(id)).uniqueResult();
		
		System.out.println(details.toString());
		this.t.commit();
		return details;
	}

	@Override
	public void updateEmail(String newEmail, int id) {
		// TODO Auto-generated method stub
		System.out.println(this.session.isOpen());
		if(!this.session.isOpen())
			this.session = f.getCurrentSession();
		this.t = this.session.beginTransaction();
		StudentEntity details = (StudentEntity) this.session.createQuery("FROM StudentEntity s WHERE s.sid = '%d'".formatted(id)).uniqueResult();
		if (details != null) {
			details.setSemail(newEmail);
		}
//		this.session.update(details);
		this.t.commit();
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		StudentEntity details = fetchById(id);
		if(!this.session.isOpen())
			this.session = f.getCurrentSession();
		this.t = this.session.beginTransaction();
		
		this.session.delete(details);
		t.commit();
	}
	
	

}
