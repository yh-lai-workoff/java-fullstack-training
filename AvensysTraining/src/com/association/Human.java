package com.association;

public class Human {
	private Heart h;
	private Brain b;
	public Human() {
		this.h = new Heart(170, 3.46f,20);
		this.b = new Brain(170, 3.46f);
	}
	public Heart getH() {
		return h;
	}
	public Brain getB() {
		return b;
	}
	
	
}
