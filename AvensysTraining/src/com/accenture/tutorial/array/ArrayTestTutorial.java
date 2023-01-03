package com.accenture.tutorial.array;

import java.util.Scanner;

public class ArrayTestTutorial {

	public static void main(String[] args) {

		// Even 3D Array Declarations:
//		int[][][] arr = new int[2][3][2];

		// Uneven 3D Array Declarations:
		int[][][] arr = new int[2][][];
		arr[0] = new int[][] { { 0, 0 }, { 0, 0, 0 } };
		arr[1] = new int[][] { { 0, 0, 0 }, { 0, 0 }, { 0, 0 } };

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.print("Please input marks of School %d, Class %d, Student %d: ".formatted(i, j, k));
					arr[i][j][k] = scan.nextInt();
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.println("Marks of School %d, Class %d, Student %d: %d".formatted(i, j, k, arr[i][j][k]));
				}

			}
		}

	}

}
