package testPackage;

public class ErrorClass {
	public static void error(int errorCode){
		switch (errorCode){
			case 1:
				System.out.println("Error Code '" + errorCode + "': No valid targets to attack found");
				break;
			case 2:
				System.out.println("Error Code '" + errorCode + "': There is already a minion in the spawn position, minion cannot be spawned");
				break;
			case 3:
				System.out.println("Error Code '" + errorCode + "': The specified space to move to is already occupied by a minion, current minion cannot move");
				break;
			case 4:
				System.out.println("Error Code '" + errorCode + "': There is no minion to be selected in that space");
				break;
			case 5:
				System.out.println("Error Code '" + errorCode + "': The minion in that space is not on your team");
				break;
			case 6:
				System.out.println("Error Code '" + errorCode + "': There is no minion selected");
				break;
			case 7:
				System.out.println("Error Code '" + errorCode + "': That was not a valid input command");
				break;
			case 8:
				System.out.println("Error Code '" + errorCode + "': Not a valid lane to be selected (0-2) try again");
				break;
			case 9:
				System.out.println("Error Code '" + errorCode + "': the minion is already in this lane try again");
				break;
			case 10:
				System.out.println("Error Code '" + errorCode + "': gameControl did not recieve valid input");
				break;
			default:
				System.out.println("Error Code '" + errorCode + "': Invalid Error Code");
				break;
		}
	}
}
