package testPackage;

public class GameControl {
	public static int selectedLane;
	public static int selectedMinion;
	public static int whosTurn = 0;
	public static int inputAsInt = 0;
	public static int charControls(String input, int turn){
		boolean isInteger = ErrorTrapping.isInteger(input);
		if (isInteger)
			inputAsInt = Integer.parseInt(input);
		else
			inputAsInt = -10;
		if (whosTurn != turn){
			whosTurn = turn;
			selectedMinion = -1;
			selectedLane = -1;
		}
		if (input.equals("t"))
			return 1;
		else if (selectedMinion == -1 && selectedLane == -1) {
			System.out.println(inputAsInt);
			if ( inputAsInt > -1 && inputAsInt < 3) {
				selectedLane = inputAsInt;
				System.out.println("Selected Lane: " + selectedLane);
			}
			else {
				ErrorClass.error(8);
			}
			return 0;
		}
		else if (selectedMinion == -1 && selectedLane != -1) {
			if ( inputAsInt > -1 && inputAsInt < 11) {
				if (MainGameLoop.gameBoard[selectedLane][inputAsInt] != null) {
					if(MainGameLoop.gameBoard[selectedLane][inputAsInt].team == turn) {
						selectedMinion = inputAsInt;
						System.out.println("Selected Minion: " + selectedMinion);
					}
					else
						ErrorClass.error(5);
				}
				else
					ErrorClass.error(4);
			}
			else if (input.equals("c") || input.equals("a") || input.equals("m") ) {
				switch (input){
					case "m": // attempt to spawn a melee minion
						MeleeMinions newMeleeMinion = new MeleeMinions(turn);
						newMeleeMinion.lane = selectedLane;
						int u = newMeleeMinion.spawn(); 
						if (u == 1)
							return 1;
						else {
							newMeleeMinion = null;
							return 0;
						}
					case "c": // attempt to spawn a caster minion
						CasterMinions newCasterMinion = new CasterMinions(turn);
						newCasterMinion.lane = selectedLane;
						int y = newCasterMinion.spawn();
						if (y == 1)
							return 1;
						else {
							newCasterMinion = null;
							return 0;
						}
					case "a": // attempt to spawn an assassin minion
						AssassinMinions newAssassinMinion = new AssassinMinions(turn);
						newAssassinMinion.lane = selectedLane;
						int w = newAssassinMinion.spawn();
						if (w == 1)
							return 1;
						else {
							newAssassinMinion = null;
							return 0;
						}
				}
			}
			else 
				ErrorClass.error(10);
			return 0;
		}
		else {
			switch (input){
				case "e": // attempt to moves selected minion
					if (selectedMinion == -1){
						ErrorClass.error(6);
						return 0;
					}
					else{
						return MainGameLoop.gameBoard[selectedLane][selectedMinion].move();
					}
				case "r": // attempt to attack with selected minion
					if (selectedMinion == -1){
						ErrorClass.error(6);
						return 0;
					}
					else{
						MainGameLoop.gameBoard[selectedLane][selectedMinion].attack();
						return 1;
					}
				case "y": // attempt to use special with selected minion
					if (selectedMinion == -1){
						ErrorClass.error(6);
						return 0;
					}
					else{
						MainGameLoop.gameBoard[selectedLane][selectedMinion].ability();
						return 1;
					}	
				default:
					ErrorClass.error(7);
					return 0;
			}
		}
	}
}
