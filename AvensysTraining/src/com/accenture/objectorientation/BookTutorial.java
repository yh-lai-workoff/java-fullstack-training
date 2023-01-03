package com.accenture.objectorientation;

public class BookTutorial {
	public static void main(String[] args) {
		Book b = new Book("Amazon", "Black", 340);
		b.setPageNumber(22);
		System.out.println(b.getPageNumber());
		System.out.println(b.getColor());
		System.out.println(b.getCost());
		System.out.println(b.getName());
	}
}

class Book {
	int pageNumber;
	String name;
	String color;
	int cost;
	
	public Book(String name, String color, int cost) {
		this.name = name;
		this.color = color;
		this.cost = cost;
	}
	
	public Book() {
		this.name = "Default";
		this.color = "Black";
		this.cost = 500;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber > 0)
			this.pageNumber = pageNumber;
		else
			System.out.println("Invalid Page Number");
	}

}