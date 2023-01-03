package com.accenture.projects.calculatorsim;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator {

	String input;
	Scanner scanner = new Scanner(System.in);
	ArrayList<Operation> calculation = new ArrayList<>();

	/**
	 * 
	 * @return Returns true if final input is entered (= equals).
	 */
	public boolean readInput() {
		boolean finalInput = false;
		System.out.println("Awaiting Calculator Input ([q]uit): ");
		input = scanner.nextLine();
		String[] splitString = parseInput(input);

		// TODO: Simplify Parsing of characters
		readLoop: for (String splits : splitString) {
			float value = Float.parseFloat(splits.substring(0, splits.length() - 1));
			switch (splits.charAt(splits.length() - 1)) {
			case '+':
				calculation.add(new Addition(value));
				break;

			case '-':
				calculation.add(new Subtraction(value));
				break;

			case '*':
				calculation.add(new Multiplication(value));
				break;

			case '/':
				calculation.add(new Division(value));
				break;
				
			case '=':
				calculation.add(new Equals(value));
				finalInput = true;
				break readLoop;

			case '^':
				calculation.add(new Exponent(value));
				break;

			default:
				System.out.println("Ignored");
				break;
			}
		}
		return finalInput;
	}

	private String[] parseInput(String input) {
		ArrayList<String> splitString = new ArrayList<>();
		Pattern calcSymbols = Pattern.compile("[\\=\\+\\-\\*\\/\\^]");
		int index = 0;
		String cleanInput = "";

		cleanInput = input.replaceAll("[\\s]", "");
		cleanInput = cleanInput.replaceAll("[ -',\\.:-<\\>-\\]_-~]", "");

//		System.out.println("DEBUG: Clean: " + cleanInput);
		if (cleanInput.charAt(cleanInput.length() - 1) != '=')
			cleanInput += "=";
		Matcher findSpecials = calcSymbols.matcher(cleanInput);

		while (findSpecials.find()) {
			// System.out.println(findSpecials.start() + " "+ findSpecials.end());
			splitString.add(cleanInput.substring(index, findSpecials.end()));
			index = findSpecials.end();
		}

		return splitString.toArray(new String[splitString.size()]);
	}

	/**
	 * Calls performOperation() for all Operations in calculation in order of
	 * ascending priority
	 */
	public void performCalculation() {
		boolean change = true;
		for (int i = 0; i < 10; i++) {
			if (change)
				printCalculationString();
			change = false;
			for (int j = 0; j < (calculation.size() - 1); j++) {
				Operation op = calculation.get(j);

				if (op.checkPriority(i)) {
					op.performOperation(calculation.get(j + 1));
					calculation.remove(j);
					j--;
					change = true;
				}
			}
		}
		System.out.println("Final Answer: %.3f".formatted(calculation.get(0).getValue()));
	}

	private void printCalculationString() {
		StringBuilder sb = new StringBuilder();
		for (Operation op : calculation) {
			sb.append(op.toString());
		}
		System.out.println(sb.toString());
	}

	public void test() {
		calculation.add(new Addition(2));
		calculation.add(new Addition(5));
		calculation.add(new Multiplication(4));
		calculation.add(new Addition(4));
		calculation.add(new Addition(6));
		calculation.add(new Division(10));
		calculation.add(new Subtraction(5));
		calculation.add(new Equals(2));
		System.out.println("Reached End");
		this.performCalculation();
	}
}

/**
 * Each Operation has a number-operator pair, with the operator coming after.
 * Example of usage: [A + ] [B / ] [C -] [D = ]
 */
abstract class Operation {
	float value;
	protected char symbol;
	protected int priority;

	/**
	 * Updates the value of another Operation with the current operation. e.g. To
	 * perform a - b, a.performOperation(b)
	 */
	abstract void performOperation(Operation o);

	protected void setValue(float value) {
		this.value = value;
	}

	float getValue() {
		return value;
	}

	boolean checkPriority(int priority) {
		return this.priority == priority;
	}

	@Override
	public String toString() {
		return "%.3f %c ".formatted(value, symbol);
	}
}

class Addition extends Operation {
	Addition(float value) {
		this.value = value;
		this.symbol = '+';
		this.priority = 6;
	}

	void performOperation(Operation o) {
		o.setValue(value + o.getValue());
	}
}

class Subtraction extends Operation {
	Subtraction(float value) {
		this.value = value;
		this.symbol = '-';
		this.priority = 6;
	}

	void performOperation(Operation o) {
		o.setValue(value - o.getValue());
	}
}

class Multiplication extends Operation {
	Multiplication(float value) {
		this.value = value;
		this.symbol = '*';
		this.priority = 5;
	}

	void performOperation(Operation o) {
		o.setValue(value * o.getValue());
	}
}

class Division extends Operation {
	Division(float value) {
		this.value = value;
		this.symbol = '/';
		this.priority = 5;
	}

	void performOperation(Operation o) {
		o.setValue(value / o.getValue());
	}
}

class Exponent extends Operation {
	Exponent(float value) {
		this.value = value;
		this.symbol = '^';
		this.priority = 4;
	}

	void performOperation(Operation o) {
		o.setValue((float) Math.pow(value, o.getValue()));

	}
}

/**
 * Warning. No Implementation!
 */
class Equals extends Operation {
	Equals(float value) {
		this.value = value;
		this.symbol = '=';
		this.priority = 9;
	}

	void performOperation(Operation o) {
		o.setValue(value);
	}
}

class CalculatorSim {
	public static void main(String[] args) {
		Calculator c = new Calculator();
//		while(!c.readInput());
		c.readInput();
		c.performCalculation();
		// c.test();
	}
}