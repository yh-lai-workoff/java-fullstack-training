package GuessingGame;

import java.util.Random;

public class Player {
	public int id;
	int gNum;
	
	public int guessNum() {
		System.out.println("Player "+id+"'s turn to guess");
//		Scanner scan = new Scanner(System.in);
//		gNum = scan.nextInt();
		
		Random r = new Random();
		gNum = r.nextInt(0, 10);
		System.out.println("Player "+id+"'s Number: "+gNum);
		
		return gNum;
	}
}
