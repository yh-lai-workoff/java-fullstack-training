package com.association;

public class LaunchMobile {
	public static void main(String[] args) {
		Charger c = new Charger("Nokia","iPhone Adapt 3.3");
		Mobile m = new Mobile(c);
		System.out.println("DEBUG: Output Dependent OS: %s __ %s".formatted(m.o.getName(),m.o.getModel()));
		System.out.println("DEBUG: Output Independent Charger: %s __ %s".formatted(c.getName(),c.getModel()));
		System.out.println("DEBUG: Output Independent Component Charger: %s __ %s".formatted(m.c.getName(),m.c.getModel()));
		
	}

}
