package com.accenture.spring.demo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan(basePackages = "com.accenture.spring.demo","com.accenture.spring.example")
public class BeanConfig {
	
	@Bean("airtel")
	public Airtel airtelBean() {
		Airtel airtel = new Airtel();
		airtel.setpObj(passObject());
		return airtel;
	}
	
	@Bean("pObj")
	public PassingObject passObject() {
		return new PassingObject();
	}
	
	@Bean("vphone")
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public Vodaphone vodaBean() {
		return new Vodaphone();
	}
}
