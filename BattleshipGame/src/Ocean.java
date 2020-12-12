/**
 * 
 * @author Sarah Shamsie, Karen Kan
 *
 */
public class Ocean {

	// instance vars
	Ship[][] ships = new Ship[10][10];
	int shotsFired;
	int hitCount;
	int shipsSunk;

	public Ocean() {
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				this.ships[i][j] = new EmptySea();
			}
		}
	}

	void placeAllShipsRandomly() {

	}

	boolean isOccupied(int row, int column) {
		return true;
	}

	boolean shootAt(int row, int column) {
		return true;
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

	}

}
