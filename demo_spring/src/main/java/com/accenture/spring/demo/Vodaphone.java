package com.accenture.spring.demo;

import org.springframework.stereotype.Component;

@Component("vphone")
public class Vodaphone {
	private String name;
	private int value;
	
	Vodaphone(){
		System.out.println("This Prototype Scope Class will create multiple times");
	}
	
	Vodaphone(String name, int value){
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	
	
}
