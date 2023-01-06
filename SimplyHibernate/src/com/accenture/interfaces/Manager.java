package com.accenture.interfaces;

import com.accenture.entities.StudentEntity;

public interface Manager {
	void connect();
	void addStudent(StudentEntity s);
	void fetchByFirstName(String sfn);
	StudentEntity fetchById(int id);
	void updateEmail(String newEmail, int id);
	void deleteStudent(int id);
}
