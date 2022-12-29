package com.accenture.spring.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.spring.demo.Airtel;
import com.accenture.spring.demo.BeanConfig;
import com.accenture.spring.demo.Vodaphone;

public class LaunchOutsidePackage {
	public static void main(String[] args) {
		System.out.println( "Hello World!" );
//      ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
      ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
      Airtel obj = (Airtel) context.getBean("airtel");
      obj.print();
      
      Vodaphone obj2 = (Vodaphone) context.getBean("vphone");
      Vodaphone obj3 = (Vodaphone) context.getBean("vphone");
      Airtel obj4 = (Airtel) context.getBean("airtel");
      
      System.out.println(obj4.getTest());
      System.out.println(obj.getTest2());
      
      System.out.println(obj2.getName());
      System.out.println(obj3.getValue());
      if(obj.getpObj()!=null)
      	System.out.println(obj.getpObj().getValuables());
	}
}
