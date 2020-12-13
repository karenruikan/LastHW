
public class Cruiser extends Ship {

	public Cruiser() {
		super();
		this.length = 3;
	}

	@Override
	String getShipType() {
		return "cruiser";
	}

}
