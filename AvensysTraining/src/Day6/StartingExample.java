package Day6;

import java.util.Scanner;

public class StartingExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Govt govt = new Govt();

		Farmer farmer1 = new Farmer();
		Farmer farmer2 = new Farmer();
		Farmer farmer3 = new Farmer();

		govt.setRateOfInterest(2.5f);
		// Get Input, Calculate SI, DIsplay SI
		float inputPrinciple;
		int inputDuration;
		
		System.out.println("Inputting Info for Farmer 1: ");
		System.out.println("Please input Principle Amount: ");
		inputPrinciple = scanner.nextFloat();
		System.out.println("Please input Loan Duration: ");
		inputDuration = scanner.nextInt();
		farmer1.input(inputPrinciple, inputDuration);
		farmer1.calculateSimpleInterest(govt.getRateOfInterest());
		farmer1.display();

		System.out.println("Inputting Info for Farmer 2: ");
		System.out.println("Please input Principle Amount: ");
		inputPrinciple = scanner.nextFloat();
		System.out.println("Please input Loan Duration: ");
		inputDuration = scanner.nextInt();
		farmer2.input(inputPrinciple, inputDuration);
		farmer2.calculateSimpleInterest(govt.getRateOfInterest());
		farmer2.display();
		
		System.out.println("Inputting Info for Farmer 3: ");
		System.out.println("Please input Principle Amount: ");
		inputPrinciple = scanner.nextFloat();
		System.out.println("Please input Loan Duration: ");
		inputDuration = scanner.nextInt();
		farmer3.input(inputPrinciple, inputDuration);
		farmer3.calculateSimpleInterest(govt.getRateOfInterest());
		farmer3.display();

	}
}

class Loans {
	float principle;
	int duration;
	float rateOfInterest;

}

class Farmer {
	private float principle;
	private float simpleInterest;
	private int duration;

	void input(float principle, int duration) {
		this.principle = principle;
		this.duration = duration;
	}

	float calculateSimpleInterest(float interest) {
		this.simpleInterest = principle * interest * duration / 100;
		return simpleInterest;
	}

	void display() {
		System.out.println("Current Simple Interest is: %f".formatted(simpleInterest));
	}
}

class Govt {
	private float rateOfInterest = 2.5f;

	void setRateOfInterest(float interest) {
		if (interest > 0f) {
			this.rateOfInterest = interest;
		}
	}

	float getRateOfInterest() {
		return this.rateOfInterest;
	}
}
