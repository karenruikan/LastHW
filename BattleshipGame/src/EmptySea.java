
public class EmptySea extends Ship {

	public EmptySea() {
		super();
		this.length = 1;
	}

	@Override
	boolean shootAt(int row, int column) {
		return false;
	}

	@Override
	boolean isSunk() {
		return false;
	}

	//TODO: Need to update this method
	@Override
	public String toString() {
		return "-";
	}

	@Override
	String getShipType() {
		return "empty";
	}

}
