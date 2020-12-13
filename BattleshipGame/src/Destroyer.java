
public class Destroyer extends Ship {

	public Destroyer() {
		super();
		this.length = 2;
	}

	@Override
	String getShipType() {
		return "destroyer";
	}

}
