package com.association;

public class Mobile {
	private String name;
	private String model;
	
	Charger c;
	OS o;
	Mobile(Charger c){
		this.c = c;
		o = new OS("iPhone Charger","iOS200000");
	}
	
	
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}
	
	
}
