
public class Submarine extends Ship {

	public Submarine() {
		super();
		this.length = 1;
	}

	@Override
	String getShipType() {
		return "submarine";
	}
}
