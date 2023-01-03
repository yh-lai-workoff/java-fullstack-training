package com.association;

public class Student extends Human{
	
	Book book;
	Bike bike;
	
	Student(){
		
	}
	
	Student(Book book, Bike bike){
		this.book = book;
		this.bike = bike;
	}
	
	public void has_A(Object o) {
		if (o instanceof Book) {
			this.book = (Book) o;
		} else if (o instanceof Bike) {
			this.bike = (Bike) o;
		}
	}
	
}
