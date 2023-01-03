package com.accenture.objectorientation;

public class Day5 {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 2, 1, 2, 1, 4, 5, 5, 3, 3, 8 };
		Logic logic = new Logic();
		logic.printUnique(nums);
	}
}

class Logic {

	void printUnique(int[] nums) {
		outerLoop: for (int selfIndex = 0; selfIndex < nums.length; selfIndex++) {
			for (int otherIndex = 0; otherIndex < nums.length; otherIndex++) {
				if (selfIndex != otherIndex && nums[selfIndex] - nums[otherIndex] == 0) {
//					System.out.println("Debug: Duplicate Found, skipping now.");
					continue outerLoop;
				}
			}
			System.out.println(nums[selfIndex]);
		}
	}

}
