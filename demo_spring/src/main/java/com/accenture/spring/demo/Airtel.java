package com.accenture.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class Airtel {
	
	private String test;
	private int test2;
	public String noSetTest;
	PassingObject pObj;
	
	Airtel(){
		System.out.println("This class will only create once");
	}
	
	public void print() {
		System.out.println("Do Something");
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getTest2() {
		return test2;
	}

	public void setTest2(int test2) {
		this.test2 = test2;
	}

	public PassingObject getpObj() {
		return pObj;
	}

	public void setpObj(PassingObject pObj) {
		this.pObj = pObj;
	}
	
	
}
