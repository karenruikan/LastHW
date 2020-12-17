/**
 * This class creates an EmptySea, which inherits the Ship class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class EmptySea extends Ship {

	/**
	 * Constructor for the EmptySea class initialize hit array for length 1
	 */
	public EmptySea() {
		super();
		this.length = 1;
	}

	/**
	 * shootAt always returns false
	 */
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}

	/**
	 * isSunk always returns false
	 */
	@Override
	boolean isSunk() {
		return false;
	}

	/**
	 * toString always returns "-" because a shot here will hit nothing
	 */
	@Override
	public String toString() {
		return "-";
	}

	/**
	 * return ship name
	 */
	@Override
	String getShipType() {
		return "empty";
	}

}
