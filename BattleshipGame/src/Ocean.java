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

    /**
     * The constructor. Creates an “empty” ocean (fills the ships array 
     * with EmptySeas).Also initializes any game variables, 
     * such as how many shots have been fired.
     */
    public Ocean() {
	shotsFired = 0;
	hitCount = 0;
	shipsSunk = 0;
	for (int i = 0; i < this.ships.length; i++) {
	    for (int j = 0; j < this.ships[i].length; j++) {
		this.test[i][j] = j;
		this.ships[i][j] = new EmptySea();
		this.fired[i][j] = false;
	    }
	}
    }


    /**
     * Place all ten ships randomly on the (initially empty) ocean. 
     * Place larger ships before smaller ones, or you may end up with 
     * no legal place to put a large ship. You will want to use the Random 
     * class in the java.util package, so look that up in the Java API.
     */

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
	    System.out.println(s.getShipType() + " placed correctly");

	}
    }

    /**
     * Returns true if the given location contains a ship, 
     * false if it does not.
     * @param row
     * @param column
     * @return
     */
    boolean isOccupied(int row, int column) {

	//if user inputs invalid coordinates, return false
	if (row < 0 || row > 9 || column < 0 || column > 9) return false;

	//if it's EmptySea return false
	if (this.getShipArray()[row][column] instanceof EmptySea) {
	    return false;
	}

	//otherwise return true
	else{
	    return true;
	}

    }

    /**
     * Returns true if the given location contains a “real” ship, 
     * still afloat, (not an EmptySea), false if it does not. 
     * In addition, this method updates the number of shots that have been 
     * fired, and the number of hits. 
     * Note: If a location contains a ”real” ship, shootAt should return 
     * true every time the user shoots at that same location. 
     * Once a ship has been ”sunk”, additional shots at its location 
     * should return false.
     * @param row
     * @param column
     * @return
     */
    boolean shootAt(int row, int column) {
	//updates shots fired
	shotsFired++;
	
	fired[row][column] = true;

	//update the row and column of the ships if there is a ship hit
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

    /**
     * Returns true if all ships have been sunk, otherwise false.
     * @return
     */
    boolean isGameOver() {
	
	if(this.shipsSunk == 10){
            return true;
        } else{
            return false;
        }
    }

    Ship[][] getShipArray() {
	return this.ships;
    }

    void print() {
	System.out.println("  0 1 2 3 4 5 6 7 8 9");

	//prints the row numbers
	for (int i = 0; i < 10; i++) {
	    System.out.print(i);

	    //for each row, print
	    for (int j = 0; j< 10; j++) {
		if (!fired[i][j]) {
		    System.out.print(" .");
		} 
		else {
		    System.out.print(" " + ships[i][j].toString());
		}
	    }
	    System.out.println(" ");
	}
    }

}
