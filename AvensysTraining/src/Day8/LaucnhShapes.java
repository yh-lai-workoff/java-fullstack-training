package Day8;

import java.util.Scanner;

public class LaucnhShapes {
	public static void main(String[] args) {
		Circle c = new Circle();
		Triangle t = new Triangle();
		Rectangle r = new Rectangle();
		
		c.runStack();
		t.runStack();
		r.runStack();
		
		r.getArea();
	}
}

abstract class Shape {
	float area;
	abstract void getInput();
	abstract void calculateArea();

	float getArea() {
		return this.area;
	}
	
	void runStack() {
		getInput();
		calculateArea();
	}
}

class Circle extends Shape {
	float radius;
	
	void getInput() {
		System.out.println("Please Enter Circle Radius: ");
		Scanner scanner = new Scanner(System.in);
		this.radius = scanner.nextFloat();
	}
	
	void calculateArea() {
		this.area = (float)( Math.PI * Math.pow(this.radius,2));
		System.out.println("Area of the Circle is %f units^2".formatted(this.area));
	}
	
}

class Rectangle extends Shape {
	float length;
	float breadth;
	
	void getInput() {
		System.out.println("Please Enter Rectangle Length: ");
		Scanner scanner = new Scanner(System.in);
		this.length = scanner.nextFloat();
		System.out.println("Please Enter Rectangle Breadth: ");
		this.breadth = scanner.nextFloat();
	}
	
	void calculateArea() {
		this.area = length * breadth;
		System.out.println("Area of the Rectangle is %f units^2".formatted(this.area));
	}
	
}

class Triangle extends Shape {
	float height;
	float base;
	
	void getInput() {
		System.out.println("Please Enter Triangle Height: ");
		Scanner scanner = new Scanner(System.in);
		this.height = scanner.nextFloat();
		System.out.println("Please Enter Triangle Base: ");
		this.base = scanner.nextFloat();
	}
	
	void calculateArea() {
		this.area = 0.5f * height * base;
		System.out.println("Area of the Rectangle is %f units^2".formatted(this.area));
	}
	
}


