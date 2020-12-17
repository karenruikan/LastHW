/**
 * This class creates a Destroyer, which inherits the Ship class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class Destroyer extends Ship {

	/**
	 * Constructor for the Destroyer class initialize hit array for length 2
	 */
	public Destroyer() {
		super();
		this.length = 2;
	}

	/**
	 * return ship name
	 */
	@Override
	String getShipType() {
		return "destroyer";
	}

}
