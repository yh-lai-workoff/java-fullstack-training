package com.association;

public class Heart {
	private int heartRate;
	private float weight;
	private int spO2;
	public Heart(int heartRate, float weight, int spO2) {
		this.heartRate = heartRate;
		this.weight = weight;
		this.spO2 = spO2;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public float getWeight() {
		return weight;
	}
	public int getSpO2() {
		return spO2;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	
	
}
