import java.util.Random;

/**
 * 
 * @author Sarah Shamsie, Karen Kan
 *
 */
public class Ocean {

    // instance vars
    Ship[][] ships = new Ship[10][10];
    int[][] test = new int[10][10];
    
    boolean[][] fired = new boolean[10][10];

    int shotsFired;
    int hitCount;
    int shipsSunk;

    public Ocean() {
	for (int i = 0; i < this.ships.length; i++) {
	    for (int j = 0; j < this.ships[i].length; j++) {
		this.test[i][j] = j;
		this.ships[i][j] = new EmptySea();
	    }
	}
    }

    void placeAllShipsRandomly() {
	// place 1 battleship, 2 cruisers, 3 destroyers, 4 subs
	Random rand = new Random();

	// create ordered array of ships to place
	Ship[] shipsToPlace = { new Battleship(), new Cruiser(), new Cruiser(), new Destroyer(), new Destroyer(),
		new Destroyer(), new Submarine(), new Submarine(), new Submarine(), new Submarine() };

	int placeRow = rand.nextInt(9 - 0) + 0;
	int placeCol = rand.nextInt(9 - 0) + 0;
	boolean placeHor = rand.nextBoolean();

	for (Ship s : shipsToPlace) {

	    while (!s.okToPlaceShipAt(placeRow, placeCol, placeHor, this)) {
		placeRow = rand.nextInt(9 - 0) + 0;
		placeCol = rand.nextInt(9 - 0) + 0;
		placeHor = rand.nextBoolean();

		System.out.println(placeRow + " " + placeCol + " " + placeHor);
	    }

	    s.placeShipAt(placeRow, placeCol, placeHor, this);
	    System.out.println(s.getShipType() + " placec correctly");

	}
    }

    boolean isOccupied(int row, int column) {
	
	if (row < 0 || row > 9 || column < 0 || column > 9) return false;

	if (this.getShipArray()[row][column].getClass().isInstance(EmptySea.class)) {
	    return false;
	}
	return true;
    }

    boolean shootAt(int row, int column) {
	shotsFired++;
	fired[row][column] = true;
	
	if (ships[row][column].shootAt(row, column)) {
	    hitCount++;
	    return true;
	} 
	else return false;   
	
    }

    int getShotsFired() {
	return this.shotsFired;
    }

    int getHitCount() {
	return this.hitCount;
    }

    int getShipsSunk() {
	return this.shipsSunk;
    }

    boolean isGameOver() {
	return true;
    }

    Ship[][] getShipArray() {
	return this.ships;
    }

    void print() {
	System.out.println("0 1 2 3 4 5 6 7 8 9");
	
	//? how to find out if that location is been fired upon? 
	for (int i = 0; i < 10; i++) {
	    System.out.print(i);
	    
	    for (int j = 0; j< 10; j++) {
		if (!fired[i][j]) {
		    System.out.println(" .");
		} 
		else {
		    System.out.print(" " + ships[i][j].toString());
		}
	    }
	}
    }

}
