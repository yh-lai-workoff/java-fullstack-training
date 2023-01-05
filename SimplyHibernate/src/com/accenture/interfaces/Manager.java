package com.accenture.interfaces;

import com.accenture.entities.StudentEntity;

public interface Manager {
	void connect();
	void addStudent(StudentEntity s);
	void fetch(String sfn);
}
