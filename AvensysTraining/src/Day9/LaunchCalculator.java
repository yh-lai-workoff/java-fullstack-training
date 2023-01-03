package Day9;

import java.util.Scanner;

interface Calculator {
	void add();

	void sub();

	void mul();

	void div();
}

interface CalculatorDLC {
	void exp();
}

interface CalculatorClone {
	void add();
}

interface CalculatorOverload {
	void add(int a, int b);
}

interface CalCal extends Calculator{
	void exp2();
}

class MyCalculator1 implements Calculator {
	public void add() {
//		int[] input = getInputs();
//		if (input[0] > 0 || input [1] >0) {
//			// do add
//		}
//		else {
//			System.out.println("Invalid Input");
//		}
		System.out.println("Running Addition");
	}

	public void sub() {
		System.out.println("Running Subtraction");
	}

	public void mul() {
		System.out.println("Running Multiplication");
	}

	public void div() {
		System.out.println("Running Division");
	}

	int[] getInputs() {
		int[] output = new int[2];
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter first value:");
		output[0] = scanner.nextInt();
		System.out.println("Please enter second value: ");
		output[1] = scanner.nextInt();
		return output;
	}
}

class MyCalculator11 extends MyCalculator1 implements CalculatorDLC{

	@Override
	public void exp() {
		System.out.println("Running Mycal 11 - Exp");
		
	}
	
}

class Calculator2 implements CalCal{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exp2() {
		// TODO Auto-generated method stub
		
	}
	
}

class Calculator3 implements Calculator, CalculatorDLC{

	@Override
	public void exp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class Calculator41 implements Calculator{
	public void add() {
		System.out.println("I have a body");
	}
}

class Calculator42 extends Calculator41{

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		
	}
	
}

class Calculator5 implements Calculator, CalculatorClone{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		
	}
	
}

class Calculator6 implements Calculator, CalculatorOverload{

	@Override
	public void add(int a, int b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void div() {
		// TODO Auto-generated method stub
		
	}
	
}

public class LaunchCalculator {
	public static void main(String[] args) {
		MyCalculator1 mc1 = new MyCalculator1();
		MyCalculator1 mc11 = new MyCalculator11();
		((MyCalculator11)mc11).exp();
		
		Calculator2 mc2 = new Calculator2();
		mc2.exp2();
		
	}
}
