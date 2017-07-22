package testPackage;

import java.util.LinkedList;
import java.util.Scanner;

public class SetupGame {
	public static void setup() {
		
		StandardMinion[][] gameBoard = new StandardMinion[3][12]; // declaring the gameboard
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 12; x++){
				gameBoard[y][x] = null;
			}
		}
		MainGameLoop.gameBoard = gameBoard; // passing the newly created gameboard back to the main game loop
		
		MainGameLoop.gameInput = new Scanner(System.in); // creating a scanner so input can be taken and passing it back to the main game loop
		
		LinkedList<StandardMinion> team = new LinkedList<StandardMinion>();
		
		MainGameLoop.allMinions = team;
	
		
		CastleMinions team1Castle = new CastleMinions(1); // creating the bases on either side of the gameboard and spawning them
		CastleMinions team2Castle = new CastleMinions(2);
		team1Castle.spawn();
		team2Castle.spawn();
	}
}
