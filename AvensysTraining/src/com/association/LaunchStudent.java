package com.association;

public class LaunchStudent {
	public static void main(String[] args) {
		Book book = new Book("Parry Hotter", "Rowling");
		Bike bike = new Bike("Mountain", 14.3f);
		
		Student s = new Student(book, bike);
		System.out.println("DEBUG: Student Brain, IQ: %d \t Weight: %f".formatted(s.getB().getIq(),s.getB().getWeight()));
		System.out.println("DEBUG: Student Heart, Heart Rate %f \t ");
	}

}
