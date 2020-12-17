/**
 * This class creates a Submarine, which inherits the Ship class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

public class Submarine extends Ship {

	/**
	 * Constructor for the Submarine class initialize hit array for length 1
	 */
	public Submarine() {
		super();
		this.length = 1;
		this.hit = new boolean[1];
	}

	/**
	 * return ship name
	 */
	@Override
	String getShipType() {
		return "submarine";
	}

}
