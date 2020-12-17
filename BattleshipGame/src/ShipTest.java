import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Ship class and subclasses
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

class ShipTest {

	// create some mock Ship objects for the test cases
	Ship battleshipTest;
	Ship cruiserTest;
	Ship destroyerTest;
	Ship subTest;
	Ship emptySeaTest;

	String errMessRow = "invalid row coordinates - need to enter a number between 0 and 9";
	String errMessCol = "invalid column coordinates - need to enter a number between 0 and 9";
	String errMessAll = "invalid row and column coordinates - need to enter a number between 0 and 9";

	final double DELTA = 0.001;

	@BeforeEach
	void setUp() throws Exception {
		this.battleshipTest = new Battleship();
		this.cruiserTest = new Cruiser();
		this.destroyerTest = new Destroyer();
		this.subTest = new Submarine();
		this.emptySeaTest = new EmptySea();
	}

	@Test
	void testShip() {

		// test that these are valid subclass objects of the Ship class
		assertTrue(this.battleshipTest instanceof Ship);
		assertTrue(this.cruiserTest instanceof Ship);
		assertTrue(this.destroyerTest instanceof Ship);
		assertTrue(this.subTest instanceof Ship);
		assertTrue(this.emptySeaTest instanceof Ship);

	}

	@Test
	void testGetLength() {
		// test that the length of each ship type is returned correctly
		assertEquals(this.battleshipTest.getLength(), 4);
		assertEquals(this.cruiserTest.getLength(), 3);
		assertEquals(this.destroyerTest.getLength(), 2);
		assertEquals(this.subTest.getLength(), 1);
		assertEquals(this.emptySeaTest.getLength(), 1);
	}

	@Test
	void testGetBowRow() {

		// check valid cases - set bowRow to valid numbers and test that
		// they are equal in the loop
		for (int i = 0; i < 10; i++) {
			this.battleshipTest.setBowRow(i);
			assertEquals(this.battleshipTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.cruiserTest.setBowRow(i);
			assertEquals(this.cruiserTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.destroyerTest.setBowRow(i);
			assertEquals(this.destroyerTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.subTest.setBowRow(i);
			assertEquals(this.subTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.emptySeaTest.setBowRow(i);
			assertEquals(this.emptySeaTest.getBowRow(), i);
		}

	}

	@Test
	void testGetBowColumn() {
		// check valid cases - set bowColumn to valid numbers and test that
		// they are equal in the loop
		for (int i = 0; i < 10; i++) {
			this.battleshipTest.setBowColumn(i);
			assertEquals(this.battleshipTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.cruiserTest.setBowColumn(i);
			assertEquals(this.cruiserTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.destroyerTest.setBowColumn(i);
			assertEquals(this.destroyerTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.subTest.setBowColumn(i);
			assertEquals(this.subTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.emptySeaTest.setBowColumn(i);
			assertEquals(this.emptySeaTest.getBowColumn(), i);
		}
	}

	@Test
	void testIsHorizontal() {

		// check that the boolean value for horizontal is returning correctly
		boolean testHor = true;

		this.battleshipTest.setHorizontal(testHor);
		this.cruiserTest.setHorizontal(!testHor);
		this.destroyerTest.setHorizontal(testHor);
		this.subTest.setHorizontal(!testHor);
		this.emptySeaTest.setHorizontal(testHor);

		assertEquals(this.battleshipTest.isHorizontal(), true);
		assertEquals(this.cruiserTest.isHorizontal(), false);
		assertEquals(this.destroyerTest.isHorizontal(), true);
		assertEquals(this.subTest.isHorizontal(), false);
		assertEquals(this.emptySeaTest.isHorizontal(), true);

	}

	@Test
	void testSetBowRow() {
		// check valid cases - set bowRow to valid numbers and test that
		// they are equal in the loop
		for (int i = 0; i < 10; i++) {
			this.battleshipTest.setBowRow(i);
			assertEquals(this.battleshipTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.cruiserTest.setBowRow(i);
			assertEquals(this.cruiserTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.destroyerTest.setBowRow(i);
			assertEquals(this.destroyerTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.subTest.setBowRow(i);
			assertEquals(this.subTest.getBowRow(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.emptySeaTest.setBowRow(i);
			assertEquals(this.emptySeaTest.getBowRow(), i);
		}

		// check some invalid cases
		Throwable badRowBattleship = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowRow(-1);
		});
		assertTrue(errMessRow.equals(badRowBattleship.getMessage()));

		Throwable badRowSub = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowRow(10);
		});
		assertTrue(errMessRow.equals(badRowSub.getMessage()));

		Throwable badRowEmpty = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowRow(15);
		});
		assertTrue(errMessRow.equals(badRowEmpty.getMessage()));

	}

	@Test
	void testSetBowColumn() {
		// check valid cases - set bowColumn to valid numbers and test that
		// they are equal in the loop
		for (int i = 0; i < 10; i++) {
			this.battleshipTest.setBowColumn(i);
			assertEquals(this.battleshipTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.cruiserTest.setBowColumn(i);
			assertEquals(this.cruiserTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.destroyerTest.setBowColumn(i);
			assertEquals(this.destroyerTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.subTest.setBowColumn(i);
			assertEquals(this.subTest.getBowColumn(), i);
		}

		for (int i = 0; i < 10; i++) {
			this.emptySeaTest.setBowColumn(i);
			assertEquals(this.emptySeaTest.getBowColumn(), i);
		}

		// check some invalid cases
		Throwable badColBattleship = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowColumn(-1);
		});
		assertTrue(errMessCol.equals(badColBattleship.getMessage()));

		Throwable badColSub = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowColumn(10);
		});
		assertTrue(errMessCol.equals(badColSub.getMessage()));

		Throwable badColEmpty = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.setBowColumn(15);
		});
		assertTrue(errMessCol.equals(badColEmpty.getMessage()));

	}

	@Test
	void testSetHorizontal() {
		// check that the boolean value for horizontal is returning correctly
		boolean testHor = true;

		this.battleshipTest.setHorizontal(testHor);
		this.cruiserTest.setHorizontal(!testHor);
		this.destroyerTest.setHorizontal(testHor);
		this.subTest.setHorizontal(!testHor);
		this.emptySeaTest.setHorizontal(testHor);

		assertEquals(this.battleshipTest.isHorizontal(), true);
		assertEquals(this.cruiserTest.isHorizontal(), false);
		assertEquals(this.destroyerTest.isHorizontal(), true);
		assertEquals(this.subTest.isHorizontal(), false);
		assertEquals(this.emptySeaTest.isHorizontal(), true);

	}

	@Test
	void testGetShipType() {
		assertTrue(this.battleshipTest.getShipType().equals("battleship"));
		assertTrue(this.cruiserTest.getShipType().equals("cruiser"));
		assertTrue(this.destroyerTest.getShipType().equals("destroyer"));
		assertTrue(this.subTest.getShipType().equals("submarine"));
		assertTrue(this.emptySeaTest.getShipType().equals("empty"));
	}

	@Test
	void testOkToPlaceShipAt() {
		Ocean oceanTest = new Ocean();
		// first check an invalid case
		Throwable badPlace = assertThrows(IllegalArgumentException.class, () -> {
			this.battleshipTest.okToPlaceShipAt(-10, 0, true, oceanTest);
		});
		assertTrue(errMessAll.equals(badPlace.getMessage()));

		// now create a mock ocean object and manually place some ships
		// horizontal battleship
		oceanTest.ships[1][0] = new Battleship();
		oceanTest.ships[1][1] = new Battleship();
		oceanTest.ships[1][2] = new Battleship();
		oceanTest.ships[1][3] = new Battleship();

		// horizontal cruiser
		oceanTest.ships[5][3] = new Cruiser();
		oceanTest.ships[5][4] = new Cruiser();
		oceanTest.ships[5][5] = new Cruiser();

		// vertical destroyer
		oceanTest.ships[8][7] = new Destroyer();
		oceanTest.ships[9][7] = new Destroyer();

		// horizontal sub
		oceanTest.ships[2][7] = new Submarine();

		// check some valid cases
		assertEquals(this.battleshipTest.okToPlaceShipAt(5, 1, false, oceanTest), true);
		assertEquals(this.cruiserTest.okToPlaceShipAt(4, 8, false, oceanTest), true);

		// check invalid cases all around the mock sub
		assertEquals(this.subTest.okToPlaceShipAt(1, 7, false, oceanTest), false); // directly above
		assertEquals(this.subTest.okToPlaceShipAt(3, 8, false, oceanTest), false); // diagonally down
		assertEquals(this.subTest.okToPlaceShipAt(2, 6, false, oceanTest), false); // to the left
		assertEquals(this.destroyerTest.okToPlaceShipAt(1, 8, false, oceanTest), false); // to the right
		assertEquals(this.cruiserTest.okToPlaceShipAt(3, 4, true, oceanTest), false); // below
		assertEquals(this.battleshipTest.okToPlaceShipAt(2, 6, false, oceanTest), false); // below

		// check invalid cases around mock battleship
		assertEquals(this.destroyerTest.okToPlaceShipAt(0, 0, false, oceanTest), false); // directly above
		assertEquals(this.cruiserTest.okToPlaceShipAt(3, 4, true, oceanTest), false); // diagonally up
		assertEquals(this.subTest.okToPlaceShipAt(1, 4, false, oceanTest), false); // to the right
		assertEquals(this.cruiserTest.okToPlaceShipAt(0, 4, true, oceanTest), false); // below

		// check invalid cases around mock cruiser
		assertEquals(this.cruiserTest.okToPlaceShipAt(4, 3, true, oceanTest), false); // directly above
		assertEquals(this.destroyerTest.okToPlaceShipAt(4, 1, true, oceanTest), false); // diagonally up
		assertEquals(this.battleshipTest.okToPlaceShipAt(5, 3, false, oceanTest), false); // to the left
		assertEquals(this.subTest.okToPlaceShipAt(6, 4, true, oceanTest), false); // below

		// check invalid cases around mock destroyer
		assertEquals(this.battleshipTest.okToPlaceShipAt(7, 4, true, oceanTest), false); // directly above
		assertEquals(this.destroyerTest.okToPlaceShipAt(7, 8, true, oceanTest), false); // diagonally up
		assertEquals(this.subTest.okToPlaceShipAt(9, 8, false, oceanTest), false); // to the right
		assertEquals(this.cruiserTest.okToPlaceShipAt(8, 4, true, oceanTest), false); // to the right

		// invalid cases in general - out of the board
		assertEquals(this.cruiserTest.okToPlaceShipAt(2, 8, true, oceanTest), false);
		assertEquals(this.battleshipTest.okToPlaceShipAt(7, 3, true, oceanTest), false);
		assertEquals(this.destroyerTest.okToPlaceShipAt(5, 9, true, oceanTest), false);
	}

	@Test
	void testPlaceShipAt() {

		// create a mock ocean object to place the ships in
		Ocean oceanTest = new Ocean();

		// place a horizontal battleship and check that the instance at each of the
		// locations in the ocean are occupied
		this.battleshipTest.placeShipAt(1, 0, true, oceanTest);
		for (int i = 0; i < 4; i++) {
			assertTrue(oceanTest.getShipArray()[1][i] instanceof Battleship);
		}

		// place a horizontal cruiser
		this.cruiserTest.placeShipAt(5, 3, true, oceanTest);
		for (int i = 3; i < 6; i++) {
			assertTrue(oceanTest.getShipArray()[5][i] instanceof Cruiser);
		}

		// place a vertical destroyer
		this.destroyerTest.placeShipAt(8, 7, false, oceanTest);
		for (int i = 8; i < 10; i++) {
			assertTrue(oceanTest.getShipArray()[i][7] instanceof Destroyer);
		}

		// place a vertical sub
		this.subTest.placeShipAt(2, 7, false, oceanTest);
		for (int i = 2; i < 3; i++) {
			assertTrue(oceanTest.getShipArray()[i][7] instanceof Submarine);
		}

	}

	@Test
	void testShootAt() {

		// create a mock ocean object to place the ships in
		Ocean oceanTest = new Ocean();

		// place a horizontal battleship
		this.battleshipTest.placeShipAt(1, 0, true, oceanTest);
		// place a horizontal cruiser
		this.cruiserTest.placeShipAt(5, 3, true, oceanTest);
		// place a vertical destroyer
		this.destroyerTest.placeShipAt(8, 7, false, oceanTest);
		// place a vertical sub
		this.subTest.placeShipAt(2, 7, false, oceanTest);

		// this ship is ready to be sunk and so shootAt should return false
		boolean[] bSunk = { true, true, true, true };
		boolean[] cSunk = { true, true, true, false };
		boolean[] dSunk = { true, true, false, false };
		boolean[] sSunk = { true, false, false, false };

		this.battleshipTest.hit = bSunk;
		assertEquals(this.battleshipTest.shootAt(1, 2), false);
		this.cruiserTest.hit = cSunk;
		assertEquals(this.cruiserTest.shootAt(5, 4), false);
		this.destroyerTest.hit = dSunk;
		assertEquals(this.destroyerTest.shootAt(8, 7), false);
		this.subTest.hit = sSunk;
		assertEquals(this.subTest.shootAt(2, 7), false);

		// this ship is not ready to be sunk
		boolean[] bNotSunk = { false, true, false, false };
		boolean[] cNotSunk = { true, false, true, false };
		boolean[] dNotSunk = { false, true, false, false };
		boolean[] sNotSunk = { false, false, false, false };

		this.battleshipTest.hit = bNotSunk;
		assertEquals(this.battleshipTest.shootAt(1, 2), true);
		this.cruiserTest.hit = cNotSunk;
		assertEquals(this.cruiserTest.shootAt(5, 4), true);
		this.destroyerTest.hit = dNotSunk;
		assertEquals(this.destroyerTest.shootAt(8, 7), true);
		this.subTest.hit = sNotSunk;
		assertEquals(this.subTest.shootAt(2, 7), true);

		// test specifically for the EmptySea class, which should always return false
		assertEquals(this.emptySeaTest.shootAt(7, 2), false);
		assertEquals(this.emptySeaTest.shootAt(4, 7), false);

	}

	@Test
	void testIsSunk() {
		// this ship is ready to be sunk
		boolean[] bSunk = { true, true, true, true };
		boolean[] cSunk = { true, true, true, false };
		boolean[] dSunk = { true, true, false, false };
		boolean[] sSunk = { true, false, false, false };

		this.battleshipTest.hit = bSunk;
		assertEquals(this.battleshipTest.isSunk(), true);
		this.cruiserTest.hit = cSunk;
		assertEquals(this.cruiserTest.isSunk(), true);
		this.destroyerTest.hit = dSunk;
		assertEquals(this.destroyerTest.isSunk(), true);
		this.subTest.hit = sSunk;
		assertEquals(this.subTest.isSunk(), true);

		// this ship is not ready to be sunk
		boolean[] bNotSunk = { false, false, false, false };
		boolean[] cNotSunk = { true, false, true, false };
		boolean[] dNotSunk = { false, true, false, false };
		boolean[] sNotSunk = { false, false, false, false };

		this.battleshipTest.hit = bNotSunk;
		assertEquals(this.battleshipTest.isSunk(), false);
		this.cruiserTest.hit = cNotSunk;
		assertEquals(this.cruiserTest.isSunk(), false);
		this.destroyerTest.hit = dNotSunk;
		assertEquals(this.destroyerTest.isSunk(), false);
		this.subTest.hit = sNotSunk;
		assertEquals(this.subTest.isSunk(), false);

		// test specifically for the EmptySea class, which should always return false
		assertEquals(this.emptySeaTest.isSunk(), false);
	}

	@Test
	void testToString() {

		// these ships are sunk and so should return "x"
		boolean[] bSunk = { true, true, true, true };
		this.battleshipTest.hit = bSunk;
		assertTrue(this.battleshipTest.toString().equals("x"));

		boolean[] cSunk = { true, true, true, false };
		this.cruiserTest.hit = cSunk;
		assertTrue(this.cruiserTest.toString().equals("x"));

		// these ships are not sunk and so should return "S"
		boolean[] bNotSunk = { false, false, false, false };
		this.battleshipTest.hit = bNotSunk;
		assertTrue(this.battleshipTest.toString().equals("S"));

		boolean[] cNotSunk = { true, false, true, false };
		this.cruiserTest.hit = cNotSunk;
		assertTrue(this.cruiserTest.toString().equals("S"));

		// test specifically for the EmptySea class, which should always return "-"
		assertEquals(this.emptySeaTest.toString(), "-");

	}

}
