/**
 * This class creates a Battleship, which inherits the Ship class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class Battleship extends Ship {

	/**
	 * Constructor for the Battleship class initialize hit array for length 4
	 */
	public Battleship() {
		super();
		this.length = 4;
//		this.hit = new boolean[4];
	}

	/**
	 * return ship name
	 */
	@Override
	String getShipType() {
		return "battleship";
	}

}
