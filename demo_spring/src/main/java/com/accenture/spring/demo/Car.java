package com.accenture.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.accenture.spring.example.Tyre;


@Configuration
@Component
@ComponentScan(basePackages = {"com.accenture.spring.demo","com.accenture.spring.example"})
public class Car {
	
	@Autowired
	private Tyre tyres;
	
	public Car (Tyre tyres) {
		this.tyres = tyres;
	}
	
	public void print() {
		System.out.println("Tyre Object:" + tyres);
	}
}
