package testPackage;

abstract class StandardMinion { // super class for all the minion types
	protected int health; // various stats for the minions
	protected int attack;
	protected int speed;
	protected int range;
	protected int position;
	protected int team;
	protected int minionType;
	protected char minionCharacter;
	protected int lane;
	
	public int move(){ // function to make a minion move
		if (team == 1 && MainGameLoop.gameBoard[lane][position + speed] == null && (position+speed) != 10){ // moves based on team and minion speed
			MainGameLoop.gameBoard[lane][position] = null; // move the minion to the next spot
			position+=speed;
			MainGameLoop.gameBoard[lane][position] = this;
			return 1;
		}
		else if (team == 2 && MainGameLoop.gameBoard[lane][position - speed] == null && (position-speed) != 1){
			MainGameLoop.gameBoard[lane][position] = null;
			position-=speed;
			MainGameLoop.gameBoard[lane][position] = this;
			return 1;
		}
		else { // if there is already a minion in the spot its supposed to move to
			ErrorClass.error(3);
			return 0;
		}
	}
	public int spawn(){ // function to spawn a minion onto the gameboard once it has been instantiated
		if (team == 1 && MainGameLoop.gameBoard[lane][1] == null){ // check team for spawn side and if theres is room for the spawn
			position = 1;
			MainGameLoop.gameBoard[lane][position] = this;
			return 1;
		}
		else if (team == 2 && MainGameLoop.gameBoard[lane][10] == null){
			position = 10;
			MainGameLoop.gameBoard[lane][position] = this;
			return 1;
		}
		else{ // if there isnt room for the spawn
			ErrorClass.error(2);
			return 0;
		}
	}
	public void attack(){ // function for attacking
		int validEnemy = -1 ; // assume no valid minion to attack by default
		for (int x = 1; x < (range+1); x++ ){ // checks if there is a valid minion to attack based on position, team and range
			if (team == 1 && (position+x) < 12 && MainGameLoop.gameBoard[lane][position+x] != null){
				if (MainGameLoop.gameBoard[lane][position+x].team == 2 && validEnemy == -1)
					validEnemy = position+x;
			}
			if (team == 2 && (position-x) > -1 && MainGameLoop.gameBoard[lane][position-x] != null){
				if (MainGameLoop.gameBoard[lane][position-x].team == 1 && validEnemy == -1){
					validEnemy = position-x;
				}
			}
		}
		if (validEnemy == -1) // if there isn't a valid minion to attack
			ErrorClass.error(1);
		else { // if there is a valid minion to attack then reduce their health by this minions attack
			MainGameLoop.gameBoard[lane][validEnemy].health-=attack;
			if (MainGameLoop.gameBoard[lane][validEnemy].health < 1)
				MainGameLoop.gameBoard[lane][validEnemy].death();
		}
	}
	public void death(){ // if the minions health drops to or below zero then remove it from the game
		System.out.println("The minion on team " + team + " at position " + position + " has been slain");
		MainGameLoop.gameBoard[lane][position] = null;
		MainGameLoop.allMinions.remove(this);
		position = -1;
	}
	public abstract int ability();
}
