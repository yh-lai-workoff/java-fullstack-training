package com.accenture.spring;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    	JdbcTemplate conn = context.getBean("connection", JdbcTemplate.class);
    	
    	Student s = context.getBean("sample",Student.class);
    	
    	s.setSid(2);
    	s.setSname("SampleName");
    	s.setSusername("username2");
    	s.setSpassword("spassword");
    	
//    	String insert_statement = "insert into new_table values(?,?,?,?)";
//    	int rows = conn.update(insert_statement,s.getSid(),s.getSname(),s.getSusername(),s.getSpassword());
//    	if (rows >= 1) {
//    		System.out.println("Updated");
//    	} else {
//    		System.out.println("Not Updated");
//    	}
    	
//    	String update_statement = "UPDATE new_table SET name=?, password=? where username=?";
//    	s.setSid(2);
//    	s.setSname("anothername");
//    	s.setSpassword("passpass");
//    	int rows = conn.update(update_statement,s.getSname(),s.getSpassword(),s.getSusername());
//    	if (rows >= 1) {
//    		System.out.println("Updated");
//    	} else {
//    		System.out.println("Not Updated");
//    	}
    	
    	String select_statement = "SELECT * from new_table";
    	List<Student> students = conn.query(select_statement, context.getBean("mapper",StudentMapper.class));
    	String select1_statement = "SELECT * from new_table where username=?";
    	List<Student> studentsRequirement= conn.query(select1_statement, new Object[] {s.getSid()}, new int[] {Types.INTEGER},context.getBean("mapper",StudentMapper.class));
    	for (Student stu: students) {
    		System.out.println(stu.toString());
    	}
    	
    }
}
