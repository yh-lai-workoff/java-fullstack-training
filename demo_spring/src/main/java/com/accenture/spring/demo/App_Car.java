package com.accenture.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_Car {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Car.class);
		Car obj = context.getBean("car",Car.class);
		obj.print();
	}
}
