/**
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */
public abstract class Ship {

    public Ship() {
    }

    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal;

    boolean[] hit = new boolean[4];

    // get ship length
    int getLength() {
	return this.length;
    }

    // get ship bow row number
    int getBowRow() {
	return this.bowRow;
    }

    // get ship bow column number
    int getBowColumn() {
	return this.bowColumn;
    }

    // check if the ship is horizontal
    boolean isHorizontal() {
	return this.horizontal;
    }

    // Sets the value of bowRow
    void setBowRow(int row) {
	this.bowRow = row;
    }

    // Sets the value of bowColumn
    void setBowColumn(int column) {
	this.bowColumn = column;
    }

    // Sets the value of the instance variable horizontal.
    void setHorizontal(boolean horizontal) {
	this.horizontal = horizontal;
    }

    // This is an abstract method and it has no body.
    abstract String getShipType();

    /**
     * Returns true if it is okay to put a ship of this length with its bow in this
     * location, with the given orientation, and returns false otherwise. The ship
     * must not overlap another ship, or touch another ship (vertically,
     * horizontally, or diagonally), and it must not ”stick out” beyond the array.
     * Does not actually change either the ship or the Ocean, just says whether it
     * is legal to do so.
     * 
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	// get the current ship array using the getShipArray method from Ocean class

	// horizontal
	// if the ship is horizontal, must make sure the cells surrounding the ship
	// are all empty. If the ship is 3 cells long, need to make sure the 3*5 area
	// around the ship are all empty.
	if (horizontal) {
	    //if ship is out of the map area
	    if (column + this.getLength() - 1 > 9) return false;

	    for (int j = column - 1; j <= column + this.getLength(); j++) {
		for (int i = row - 1; i <= row + 1; i++) {
		    if (ocean.isOccupied(i, j))
			return false;
		}
	    }
	    return true;
	}

	// not horizontal
	else {
	    //if ship is out of the map area
	    if (row + this.getLength() - 1 > 9) return false;

	    for (int i = row - 1; i <= row + this.getLength(); i++) {
		for (int j = column - 1; j <= column + 1; j++) {
		    if (ocean.isOccupied(i, j))
			return false;
		}
	    }
	    return true;
	}

    }

    /**
     * "puts” the ship in the ocean
     * 
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

	Ship[][] theShip = ocean.getShipArray();

	if (this.okToPlaceShipAt(row, column, horizontal, ocean)) {
	    this.setBowRow(row);
	    this.setBowColumn(column);
	    this.setHorizontal(horizontal);

	    if (!horizontal) {
		for (int i = row; i < (row + this.getLength()); i++) {
		    theShip[i][column] = this; // putting a reference to the ship in each of 1 or more locations
		}
	    }

	    if (horizontal) {
		for (int j = column; j < (column + this.getLength()); j++) {
		    theShip[row][j] = this; // putting a reference to the ship in each of 1 or more locations
		}
	    }
	}

    }

    boolean shootAt(int row, int column) {

	if(!this.isSunk()) {
	    if (this.isHorizontal()) {
		this.hit[row - this.getBowRow()] = true;
		return true;
		    
	    }
	    else {
		this.hit[column - this.getBowColumn()] = true;
		return true;
	    }
	}
	return false;
    }

    boolean isSunk() {
	for (boolean b : this.hit) {
	    if (!b) {
		return false;
	    }
	}
	return true;
    }

    @Override
    public String toString() {
	if (isSunk()) {
	    return "x";
	} else {
	    return "S";
	}
    }

}
