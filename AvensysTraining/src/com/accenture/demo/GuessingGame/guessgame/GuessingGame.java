package com.accenture.demo.GuessingGame.guessgame;

import com.accenture.demo.GuessingGame.umpire.Umpire;

public class GuessingGame {
	public static void main(String[] args) {
		Umpire u = new Umpire();
		u.getGuesserNum();
		u.getPlayersNum();
		u.compareResults();
	}
}


//Umpire and a Guesser and 3 Players (p1,p2,p3)
//Umpire has to collect number from all 3 players
//Umpire first instructs guesser to guess 1 number
//Guesser will tell umpire the number (return)
//Umpire will then tell player 1 to guess the number
//Player 1 will return the number to the umpire



