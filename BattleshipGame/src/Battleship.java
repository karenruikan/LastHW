
public class Battleship extends Ship {

	public Battleship() {
		super();
		this.length = 4;
		this.hit = new boolean[4];
	}

	@Override
	String getShipType() {
		return "battleship";
	}

}
