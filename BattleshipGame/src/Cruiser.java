
public class Cruiser extends Ship {

	public Cruiser() {
		super();
		this.length = 3;
		this.hit = new boolean[3];
	}

	@Override
	String getShipType() {
		return "cruiser";
	}

}
