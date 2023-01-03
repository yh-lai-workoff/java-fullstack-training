package com.accenture.tutorial.array;

public class ArrayProblem {

	public static void main(String[] args) {
		int[] numbers = new int[] { 2, 3, 4, 5 };
		int target = 7;
		int[] output = new int[2];

		boolean solutionFound = false;

		outside: for (int numIndex = 0; numIndex < numbers.length; numIndex++) {

			for (int otherIndex = numIndex + 1; otherIndex < numbers.length; otherIndex++) {
				if (numIndex != otherIndex && numbers[numIndex] + numbers[otherIndex] == target) {
					System.out.println("The target index is %d and %d".formatted(numIndex, otherIndex));
					output[0] = numIndex;
					output[1] = otherIndex;
					break outside;
//					solutionFound = true;
				}
			}
//			if (solutionFound)
//				break;

		}
	}

}