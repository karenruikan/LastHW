import java.util.Scanner;

/**
 * This class runs the Battleship game
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class BattleshipGame {

	// initialize instance vars and scanner
	private Scanner scanner = new Scanner(System.in);
	int bestScore = 100;

	// main method to run the game
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		while (game.startGame()) {
			continue;
		}
	}

	/**
	 * begins the game and iterates until all ships are sunk
	 * 
	 * @return boolean on whether the game is over
	 */
	public boolean startGame() {

		System.out.println("Welcome to the Battleship Game. Good Luck!");

		Ocean myOcean = new Ocean();

		// place all ships randomly on the board
		myOcean.placeAllShipsRandomly();

		// print out the game board - giving user some cues like the number of ships
		// they have sunk and their current score
		System.out.println();
		System.out.println("Printing game board...");
		System.out.println("You have currently sunk " + myOcean.getShipsSunk() + " ship(s)");
		System.out.println("Your current score is " + myOcean.getShotsFired() + " shot(s)");
		System.out.println();
		myOcean.print();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Arrays.toString(myOcean.getShipArray()[i]));
//		}

		// keep running until all ships are sunk (game over)
		while (!myOcean.isGameOver()) {
			// ask player for their first input
			System.out.println();
			System.out.println("Please choose your next target");
			System.out.println("Enter row number: ");
			int row = getInt();
			System.out.println("Enter column number: ");
			int column = getInt();

			// update Ship and Ocean according to the input
			System.out.println();
			if (myOcean.shootAt(row, column)) {
				System.out.println("You hit a ship");
				Ship[][] ships = myOcean.getShipArray();

				// tells the player if the shot hits anything
				if (ships[row][column].isSunk()) {
					System.out.println("A " + ships[row][column].getShipType() + " is sunk");
				}
			} else {
				System.out.println("You missed");
			}
			// prints the new game board
			System.out.println("You have currently sunk " + myOcean.getShipsSunk() + " ship(s)");
			System.out.println("Your current score is " + myOcean.getShotsFired() + " shots");

			myOcean.print();
		}

		// get current score and best score
		int currentScore = myOcean.getShotsFired();
		bestScore = Math.min(currentScore, bestScore);

		// print final message
		System.out.println();
		System.out.println("Game Finished. Your final score is " + currentScore);
		System.out.println("Current best score is " + bestScore);
		System.out.println("Enter 'yes' if you would like to play again");
		String answer = scanner.nextLine();
		return answer.equals("yes");

	}

	/**
	 * this method checks if the user input is valid
	 * 
	 * @return int that the user has entered for row or column
	 */
	public int getInt() throws IllegalArgumentException{

		String s;
		int sInt;

		while (true) {
			try {
				s = scanner.nextLine();
				sInt = Integer.valueOf(s);
				
				//make sure the number is within bounds of the gameboard
				if (sInt < 0 || sInt > 9) {
					System.out.println("Please enter an integer from 0 to 9");
					continue;
				}
				break;
			} catch (IllegalArgumentException iae) {
				System.out.println("Please enter an integer from 0 to 9, one per line");
			}
		}
		return sInt;
	}

}
