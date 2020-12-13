
public class Battleship extends Ship {

	public Battleship() {
		super();
		this.length = 4;
	}

	@Override
	String getShipType() {
		return "battleship";
	}

}
