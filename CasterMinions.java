package testPackage;

public class CasterMinions extends StandardMinion {
	CasterMinions(int side){
		attack = 3;
		range = 3;
		health = 3;
		team = side;
		speed = 1;
		minionType = 1;
		minionCharacter = 'c';
		MainGameLoop.allMinions.add(this);	
	}
	public int ability() {
		return 1;
	}
}
