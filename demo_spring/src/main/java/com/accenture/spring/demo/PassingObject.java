package com.accenture.spring.demo;

import org.springframework.stereotype.Component;

@Component("passedObject")
public class PassingObject {
	private String valuables;
	
	PassingObject(){
		this.valuables = "Default";
	}
	
	PassingObject(String valuables){
		this.valuables = valuables;
	}

	public String getValuables() {
		return valuables;
	}

	public void setValuables(String valuables) {
		this.valuables = valuables;
	}
	
	
}
