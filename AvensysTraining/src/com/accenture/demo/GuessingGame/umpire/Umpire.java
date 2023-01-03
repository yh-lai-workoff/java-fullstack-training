package com.accenture.demo.GuessingGame.umpire;

import com.accenture.demo.GuessingGame.guesser.Guesser;
import com.accenture.demo.GuessingGame.player.Player;

public class Umpire {
	int guesserNum;
	int[] playerNums = new int[3];
	
	public void getGuesserNum() {
		Guesser g = new Guesser();
		guesserNum = g.guessNum();
	}
	
	public void getPlayersNum() {
		Player p1 = new Player();
		p1.id = 1;
		Player p2 = new Player();
		p2.id = 2;
		Player p3 = new Player();
		p3.id = 3;
		
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
