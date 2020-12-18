import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Ocean class
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */

class OceanTest {

	// create a mock Ocean objects for the test cases
	Ocean oceanTestManual;
	Ocean oceanTestAuto;
	final double DELTA = 0.001;

	@BeforeEach
	void setUp() throws Exception {
		// to manually manipulate so we are not reliant on Ship.java methods
		this.oceanTestManual = new Ocean();
		// horizontal battleship
		this.oceanTestManual.ships[1][0] = new Battleship();
		this.oceanTestManual.ships[1][1] = new Battleship();
		this.oceanTestManual.ships[1][2] = new Battleship();
		this.oceanTestManual.ships[1][3] = new Battleship();

		// horizontal cruiser
		this.oceanTestManual.ships[5][3] = new Cruiser();
		this.oceanTestManual.ships[5][4] = new Cruiser();
		this.oceanTestManual.ships[5][5] = new Cruiser();

		// vertical destroyer
		this.oceanTestManual.ships[8][7] = new Destroyer();
		this.oceanTestManual.ships[9][7] = new Destroyer();

		// horizontal sub
		this.oceanTestManual.ships[2][7] = new Submarine();

		// will be reliant on some methods from Ship.java
		this.oceanTestAuto = new Ocean();
		// place a horizontal battleship
		new Battleship().placeShipAt(1, 0, true, this.oceanTestAuto);
		// place a horizontal cruiser
		new Cruiser().placeShipAt(5, 3, true, this.oceanTestAuto);
		// place a vertical destroyer
		new Destroyer().placeShipAt(8, 7, false, this.oceanTestAuto);
		// place a vertical sub
		new Submarine().placeShipAt(2, 7, false, this.oceanTestAuto);
	}

	@Test
	void testOcean() {
		assertTrue(this.oceanTestManual instanceof Ocean);
		assertTrue(this.oceanTestAuto instanceof Ocean);
	}

	// cannot test this method (Piazza post @410)
//	@Test
//	void testPlaceAllShipsRandomly() {
//		fail("Not yet implemented");
//	}

	@Test
	void testIsOccupied() {
		// test these using the manual ocean
		// test for if occupied
		assertEquals(this.oceanTestManual.isOccupied(1, 0), true);
		assertEquals(this.oceanTestManual.isOccupied(1, 3), true);
		assertEquals(this.oceanTestManual.isOccupied(5, 4), true);
		assertEquals(this.oceanTestManual.isOccupied(8, 7), true);
		assertEquals(this.oceanTestManual.isOccupied(2, 7), true);

		// test for not occupied
		assertEquals(this.oceanTestManual.isOccupied(1, 4), false);
		assertEquals(this.oceanTestManual.isOccupied(5, 6), false);
		assertEquals(this.oceanTestManual.isOccupied(8, 6), false);
		assertEquals(this.oceanTestManual.isOccupied(2, 8), false);
		assertEquals(this.oceanTestManual.isOccupied(3, 2), false);

		// test these using the auto ocean
		// test for if occupied
		assertEquals(this.oceanTestAuto.isOccupied(1, 0), true);
		assertEquals(this.oceanTestAuto.isOccupied(1, 3), true);
		assertEquals(this.oceanTestAuto.isOccupied(5, 4), true);
		assertEquals(this.oceanTestAuto.isOccupied(8, 7), true);
		assertEquals(this.oceanTestAuto.isOccupied(2, 7), true);

		// test for not occupied
		assertEquals(this.oceanTestAuto.isOccupied(1, 4), false);
		assertEquals(this.oceanTestAuto.isOccupied(5, 6), false);
		assertEquals(this.oceanTestAuto.isOccupied(8, 6), false);
		assertEquals(this.oceanTestAuto.isOccupied(2, 8), false);
		assertEquals(this.oceanTestAuto.isOccupied(3, 2), false);

		// test for invalid inputs
		assertEquals(this.oceanTestManual.isOccupied(-1, 10), false);
		assertEquals(this.oceanTestManual.isOccupied(4, -3), false);
		assertEquals(this.oceanTestManual.isOccupied(14, 14), false);
		assertEquals(this.oceanTestAuto.isOccupied(-1, 10), false);
		assertEquals(this.oceanTestAuto.isOccupied(4, -3), false);
		assertEquals(this.oceanTestAuto.isOccupied(14, 14), false);

	}

	@Test
	void testShootAt() {

		// test these using the manual ocean
		// test for successful hits
		assertEquals(this.oceanTestAuto.shootAt(1, 0), true);
		assertEquals(this.oceanTestAuto.shootAt(1, 3), true);
		assertEquals(this.oceanTestAuto.shootAt(5, 4), true);
		assertEquals(this.oceanTestAuto.shootAt(8, 7), true);
		assertEquals(this.oceanTestAuto.shootAt(2, 7), true);

		// test for unsuccessful hits
		assertEquals(this.oceanTestAuto.shootAt(3, 4), false);
		assertEquals(this.oceanTestAuto.shootAt(6, 8), false);
		assertEquals(this.oceanTestAuto.shootAt(0, 5), false);

		assertEquals(this.oceanTestAuto.getShotsFired(), 8); // 8 shots were just fired
		assertEquals(this.oceanTestAuto.getHitCount(), 5); // 5 shots hit a ship
		assertEquals(this.oceanTestAuto.getShipsSunk(), 1); // the sub was sunk

		// now try sinking the battleship so we can increment some instance vars
		assertEquals(this.oceanTestAuto.shootAt(1, 1), true);
		assertEquals(this.oceanTestAuto.shootAt(1, 2), true);

		assertEquals(this.oceanTestAuto.getShotsFired(), 10); // 8 shots were just fired
		assertEquals(this.oceanTestAuto.getHitCount(), 7); // 5 shots hit a ship
		assertEquals(this.oceanTestAuto.getShipsSunk(), 2); // the sub was sunk
	}

	@Test
	void testIsGameOver() {

		// test if the game is not over (not all 10 ships have been sunk)
		this.oceanTestAuto.shipsSunk = 5;
		assertEquals(this.oceanTestAuto.isGameOver(), false);

		this.oceanTestAuto.shipsSunk = 0;
		assertEquals(this.oceanTestAuto.isGameOver(), false);

		// test if the game is over (all 10 ships have been sunk)
		this.oceanTestAuto.shipsSunk = 10;
		assertEquals(this.oceanTestAuto.isGameOver(), true);
	}

	// not going to unit test this method since it is pure i/o
//	@Test
//	void testPrint() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetShotsFired() {

		// test getter for shotsFired
		this.oceanTestManual.shotsFired = 147;
		assertEquals(this.oceanTestManual.getShotsFired(), 147);

		this.oceanTestAuto.shotsFired = 32;
		assertEquals(this.oceanTestAuto.getShotsFired(), 32);

		this.oceanTestAuto.shotsFired = 0;
		assertEquals(this.oceanTestAuto.getShotsFired(), 0);

	}

	@Test
	void testGetHitCount() {

		// test getter for hitCount
		this.oceanTestManual.hitCount = 20;
		assertEquals(this.oceanTestManual.getHitCount(), 20);

		this.oceanTestAuto.hitCount = 14;
		assertEquals(this.oceanTestAuto.getHitCount(), 14);

		this.oceanTestAuto.hitCount = 0;
		assertEquals(this.oceanTestAuto.getHitCount(), 0);
	}

	@Test
	void testGetShipsSunk() {

		// test getter for shipsSunk
		this.oceanTestManual.shipsSunk = 10;
		assertEquals(this.oceanTestManual.getShipsSunk(), 10);

		this.oceanTestAuto.shipsSunk = 5;
		assertEquals(this.oceanTestAuto.getShipsSunk(), 5);

		this.oceanTestAuto.shipsSunk = 0;
		assertEquals(this.oceanTestAuto.getShipsSunk(), 0);

	}

	@Test
	void testGetShipArray() {
		Ocean emptyOcean = new Ocean();

		// test that the emptyOcean is in fact empty
		for (int i = 0; i < emptyOcean.getShipArray().length; i++) {
			for (int j = 0; j < emptyOcean.getShipArray()[i].length; j++) {
				assertTrue(emptyOcean.getShipArray()[i][j] instanceof EmptySea);
			}
		}

	}

}
