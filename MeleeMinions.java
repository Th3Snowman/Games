package testPackage;

public class MeleeMinions extends StandardMinion {
	MeleeMinions(int side){
		attack = 2;
		range = 1;
		health = 8;
		team = side;
		speed = 1;
		minionType = 0;
		minionCharacter = 'm';
		MainGameLoop.allMinions.add(this);	
	}
	public int ability() {
		return 1;
	}
}
