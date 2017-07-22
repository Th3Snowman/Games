package testPackage;

public class AssassinMinions extends StandardMinion{
	AssassinMinions(int side){
		attack = 5;
		range = 1;
		health = 2;
		team = side;
		speed = 1;
		minionType = 2;
		minionCharacter = 'a';
		MainGameLoop.allMinions.add(this);	
	}
	public int ability() {
		System.out.println("What lane would you like to jump to?");
		int laneToJumpTo = MainGameLoop.gameInput.nextInt();
		if (laneToJumpTo == lane) {
			ErrorClass.error(9);
			return 0;
		}
		else if (laneToJumpTo > -1 && laneToJumpTo < 3) {
			if (MainGameLoop.gameBoard[laneToJumpTo][position] == null) {
				MainGameLoop.gameBoard[lane][position] = null;
				lane = laneToJumpTo;
				MainGameLoop.gameBoard[lane][position] = this;
				return 1;
			}
			else {
				ErrorClass.error(3);
				return 0;
			}
		}
		else {
			ErrorClass.error(8);
			return 0;
		}
	}
}
