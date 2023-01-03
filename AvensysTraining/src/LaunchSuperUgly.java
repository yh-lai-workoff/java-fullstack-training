import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LaunchSuperUgly {
	public static void main(String[] args) {
		System.out.println("Example 1: "+getSuperUgly(12,new int[] {2,7,13,19}));
		System.out.println("Example 2: "+getSuperUgly(1,new int[] {1,2,3,5}));
		System.out.println("Example 3: "+getSuperUgly(50,new int[] {2,3,5}));
		System.out.println("Example 4: "+getSuperUgly(9,new int[] {3,5,7,11,13}));
	}
	
	public static int getSuperUgly(int n, int[] primes) {
		int out = 1;
		
		ArrayList<Integer> countSet = new ArrayList<>();
		countSet.add(1);
		
		for (int i = 1, count = 2; i < n; count++) {
			int value = count;
			outer: while (true) {
				boolean loop = false;
				for (int prime : primes) {
					if (value == 1) {
						countSet.add(count);
						i++;
//						System.out.println("DEBUG: Found Value! "+count);
						out = count;
						break outer;
					}
					if (value%prime == 0) {
						value/=prime;
						loop = true;
					}
				}
				if (!loop)
					break;
			}
		}
		System.out.println("DEBUG: Final Set: "+countSet.toString());
		return out;
	}
}