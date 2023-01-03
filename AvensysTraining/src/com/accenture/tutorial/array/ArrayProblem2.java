package com.accenture.tutorial.array;

import java.util.Arrays;

public class ArrayProblem2 {
	public static void main(String[] args) {
		int[] input = new int[] { 4, 2, 1, 7 };
		int[] output = new int[input.length];

		for (int selfIndex = 0; selfIndex < input.length; selfIndex++) {
			output[selfIndex] = 1;
			for (int otherIndex = 0; otherIndex < input.length; otherIndex++) {
				if (selfIndex != otherIndex)
					output[selfIndex] *= input[otherIndex];
			}
		}
		System.out.println(Arrays.toString(output));

	}
}
