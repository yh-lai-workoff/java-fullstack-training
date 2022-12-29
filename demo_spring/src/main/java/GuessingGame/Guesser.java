package GuessingGame;

import java.util.Random;

public class Guesser {
	int gNum;
	public int guessNum() {
		System.out.println("Guesser's turn to guess");
//		Scanner scan = new Scanner(System.in);
//		gNum = scan.nextInt();
		Random r = new Random();
		gNum = r.nextInt(0, 10);
		System.out.println("Guesser: "+gNum);
		return gNum;
	}
}
