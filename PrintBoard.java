package testPackage;

public class PrintBoard {
	public static void printBoard(){ // function to print the gameboard out with minions
		System.out.print("\n ");
		for (int x = 1; x < 11; x++){
			if (MainGameLoop.gameBoard[0][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].health);
			}
		}
		System.out.print(" \n ");
		for (int x = 1; x < 11; x++){
			if (MainGameLoop.gameBoard[0][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].minionCharacter);
			}
		}
		System.out.print("\n");
		if (MainGameLoop.gameBoard[1][0].health < 10)
			System.out.print(MainGameLoop.gameBoard[1][0].health + " ");
		else
			System.out.print(MainGameLoop.gameBoard[1][0].health);
		for (int x = 0; x < 9; x++)
			System.out.print(" ");
		System.out.print(MainGameLoop.gameBoard[1][11].health);
		System.out.print("\n^");
		for (int x = 1; x < 11; x++){
			if (MainGameLoop.gameBoard[1][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].health);
			}
		}
		System.out.print("^\n");
		for (int x = 0; x < 12; x++){
			if (MainGameLoop.gameBoard[1][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].minionCharacter);
			}
		}
		System.out.print("\n ");
		for (int x = 1; x < 11; x++){
			if (MainGameLoop.gameBoard[2][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].health);
			}
		}
		System.out.print(" \n ");
		for (int x = 1; x < 11; x++){
			if (MainGameLoop.gameBoard[2][x] == null){
				System.out.print(" ");
			}
			else{
				System.out.println(MainGameLoop.gameBoard[0][x].minionCharacter);
			}
		}
		System.out.print("\n");
		System.out.print(" ");
		for (int x = 1; x < 11; x++)
			System.out.print(x);
		System.out.print(" \n");
	}
}
