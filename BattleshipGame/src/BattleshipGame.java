import java.util.Scanner;

public class BattleshipGame {

	private Scanner scanner = new Scanner(System.in);
	int bestScore = 100;

	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		while (game.startGame()) {
			continue;
		}
	}

	public boolean startGame() {

		System.out.println("Welcome to the Battleship Game. Good Luck!");

		Ocean myOcean = new Ocean();

		// place all ships randomly on the board
		myOcean.placeAllShipsRandomly();


		// print out the game board;
		System.out.println();
		System.out.println("Printing game board...");
		System.out.println("You have currently sunk " + myOcean.getShipsSunk() + " ship(s)");
		System.out.println();
		myOcean.print();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(Arrays.toString(myOcean.getShipArray()[i]));
//		}

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
			myOcean.print();
		}

		int currentScore = myOcean.getShotsFired();
		bestScore = Math.min(currentScore, bestScore);
		
		//print final message
		System.out.println();
		System.out.println("Game Finished. Your final score is " + currentScore);
		System.out.println("Current best score is " + bestScore);
		System.out.println("Enter 'yes' if you would like to play again");
		String answer = scanner.nextLine();
		return answer.equals("yes");

	}

	public int getInt() {

		String s;
		int sInt;

		while (true) {
			try {
				s = scanner.nextLine();
				sInt = Integer.valueOf(s);
				if (sInt < 0 || sInt > 9) {
					System.out.println("Please enter an integer from 0 to 9");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an integer from 0 to 9, one per line");
			}
		}
		return sInt;
	}

}
