package com.accenture.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student s = context.getBean("sample",Student.class);
		s.setSid(rs.getInt(1));
		s.setSname(rs.getString(2));
		s.setSusername(rs.getString(3));
		s.setSpassword(rs.getString(4));
		return s;
	}

}
