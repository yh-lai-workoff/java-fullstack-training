package com.accenture.spring.demo;


public class Airtel {
	
	private String test;
	private int test2;
	public String noSetTest;
	
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
	
	
}
