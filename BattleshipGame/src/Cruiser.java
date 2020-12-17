/**
 * This class creates a Cruiser, which inherits the Ship class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class Cruiser extends Ship {

	/**
	 * Constructor for the Cruiser class initialize hit array for length 3
	 */
	public Cruiser() {
		super();
		this.length = 3;
		this.hit = new boolean[3];
	}

	/**
	 * return ship name
	 */
	@Override
	String getShipType() {
		return "cruiser";
	}

}
