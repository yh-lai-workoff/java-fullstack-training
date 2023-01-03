package com.accenture.spring;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.accenture.spring")
@PropertySource("classpath:datasource.properties")
public class BeanConfig {
	
	@Autowired
	Environment environment;
	
	private String URL = "url";
	private String USERNAME = "user_name";
	private String PASSWORD = "password";
	
	@Bean("connection")
	public JdbcTemplate getTemplateObject(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println(environment.getProperty("NUMBER_OF_PROCESSORS"));
		dataSource.setUrl(environment.getProperty(URL));
		dataSource.setUsername(environment.getProperty(USERNAME));
		dataSource.setPassword(environment.getProperty(PASSWORD));
		System.out.println("%s + %s + %s".formatted(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword()));
		return new JdbcTemplate(dataSource);
	}
	
	@Bean("sample")
	public Student getStudentBean() {
		return new Student();
	}
	
	@Bean("mapper")
	public StudentMapper getMapperBean() {
		return new StudentMapper();
	}
	
	// Nice Long Detailed Method of getting Properties and setting Template
//	@Bean("connection")
//	public JdbcTemplate getTemplateObject() throws IOException {
//		JdbcTemplate template = null;
//		DriverManagerDataSource dataSource = null;
//		
//		String url = null;
//		String username = null;
//		String password = null;
//		
//		FileInputStream fis = new FileInputStream("C:\\Users\\icych\\Documents\\workspace-spring-tool-suite-4-4.17.0.RELEASE\\SpringProject1\\src\\main\\java\\datasource.properties");
//		Properties p = new Properties();
//		p.load(fis);
//		
//		url = p.getProperty("url");
//		username = p.getProperty("username");
//		password = p.getProperty("password");
//		
//		dataSource = new DriverManagerDataSource();
//		
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		
//		System.out.println("%s + %s + %s".formatted(dataSource.getUrl(),dataSource.getUsername(),dataSource.getPassword()));
//
//		template = new JdbcTemplate(dataSource);
//		return template;
//	}
}
