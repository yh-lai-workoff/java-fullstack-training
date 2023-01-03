package Day9;

import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LaunchPasswordGen {

	public static void main(String[] args) {
		System.out.println("Input password Length:");

		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		StringBuilder output = new StringBuilder();
		Random r = new Random();
		
		String lower = unicodeGen(97,26);
		String upper = unicodeGen(65,26);
		String nums = unicodeGen(48,10);
		String special = unicodeGen(33, 15) + unicodeGen(58,7) + unicodeGen(91, 6) + unicodeGen(123,4);
		
		String selected = "";
		System.out.println("Select lowercase? (y/n)");
		
		if(scanner.next().toLowerCase().charAt(0)=='y') {
			selected += lower;
		}
		System.out.println("Select uppercase? (y/n)");
		if(scanner.next().toLowerCase().charAt(0)=='y') {
			selected += upper;
		}
		System.out.println("Select numbers? (y/n)");
		if(scanner.next().toLowerCase().charAt(0)=='y') {
			selected += nums;
		}
		System.out.println("Select special chars? (y/n)");
		if(scanner.next().toLowerCase().charAt(0)=='y') {
			selected += special;
		}
		
		while (selected.length() >0 && length > 0) {
			char next;
			next = selected.charAt(r.nextInt(selected.length()));
			

			output.append(next);

			length--;
		}
		System.out.println(output.toString());
	}
	
	public static String unicodeGen (int start, int range) {
		StringBuilder output = new StringBuilder();
		while (range > 0 ) {
			output.append((char)(start + range -1));
			range--;
		}
		
		
		return output.toString();
	}
}
