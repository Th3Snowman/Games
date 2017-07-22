package testPackage;

import java.util.LinkedList;
import java.util.Scanner;

/*
 *TODO: convert 1-10 switch to one case
 *		figure out how to delete stuff and implement in GameControl and death()
 *		finish assassin ability
 *		figure out abilities for other minions types	
*/

public class MainGameLoop {
	
	public static LinkedList<StandardMinion> allMinions;
	public static int turn = 1;
	public static Scanner gameInput;
	public static StandardMinion[][] gameBoard;
	
	public static void main(String[] args) {
		SetupGame.setup();
		
		for (int x = 0; x < 100; x++){
			System.out.println("Player " + turn + "'s turn:");
			String next = gameInput.next();
			
			int nextTurn = GameControl.charControls(next, turn);
			if (nextTurn == 1 && turn == 1)
				turn = 2;
			else if (nextTurn == 1 && turn == 2)
				turn = 1;
			PrintBoard.printBoard();
		}
	}
}
