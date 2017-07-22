package testPackage;

public class CastleMinions extends StandardMinion{
	CastleMinions(int side){
		attack = 0;
		range = 0;
		health = 20;
		team = side;
		speed = 0;
		minionType = 3;
		minionCharacter = '|';
		MainGameLoop.allMinions.add(this);	
	}
	@Override
	public int spawn(){ // spawning base
		if (team == 1 && MainGameLoop.gameBoard[0][0] == null && MainGameLoop.gameBoard[1][0] == null && MainGameLoop.gameBoard[2][0] == null){ // check team for spawn side and if theres is room for the spawn
			position = 0; // spawn on different sides of the board depending upon which team
			MainGameLoop.gameBoard[0][position] = this; // make it the last minion at the end of every lane so it is attacked by any minion at the end of any lane
			MainGameLoop.gameBoard[1][position] = this;
			MainGameLoop.gameBoard[2][position] = this;
			return 1;
		}
		else if (team == 2 && MainGameLoop.gameBoard[0][11] == null && MainGameLoop.gameBoard[1][11] == null && MainGameLoop.gameBoard[2][11] == null){
			position = 11;
			MainGameLoop.gameBoard[0][position] = this;
			MainGameLoop.gameBoard[1][position] = this;
			MainGameLoop.gameBoard[2][position] = this;
			return 1;
		}
		else{ // if there isnt room for the spawn
			ErrorClass.error(2);
			return 0;
		}
	}
	@Override
	public void death(){ // if a base it destroyed then the game ends
		if (team == 1){
			System.out.println("Player 2 wins!");
			System.exit(0);
		}
		if (team == 2){
			System.out.println("Player 1 wins!");
			System.exit(0);
		}
	}
	public int ability() {
		return 1;
	}
}
