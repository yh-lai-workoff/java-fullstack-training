package com.accenture.spring.GuessingGame;

public class Umpire {
	int guesserNum;
	int[] playerNums = new int[3];
	private Player p1;
	private Player p2;
	private Player p3;
	private Guesser g;
	
//	public Umpire() {
//		g = new Guesser();
//		p1 = new Player();
//		p2 = new Player();
//		p3 = new Player();
//	}
	
	public Umpire(Player p1, Player p2, Player p3, Guesser g) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.g = g;
	}
	
	public void getGuesserNum() {
		
		guesserNum = g.guessNum();
	}
	
	public void getPlayersNum() {
		
		playerNums[0] = p1.guessNum();
		playerNums[1] = p2.guessNum();
		playerNums[2] = p3.guessNum();
		
	}
	
	public void compareResults() {
		boolean winnerFound = false;
		for(int i = 0; i < playerNums.length; i++) {
			if (guesserNum == playerNums[i]) {
				System.out.println("Player "+ (i+1) +" is a winner!");
				winnerFound = true;
			}
		}
		if (!winnerFound)
			System.out.println("No Winners have been found!");
	}

}
