import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {

//		private int[] shipCoordinates() {
//			int[] coordinates = new int[this.length];
//
//			if (this.isHorizontal()) {
//				int tempBowRow = this.getBowRow();
//				for (int i = 0; i < this.length; i++) {
//					coordinates[i] = tempBowRow;
//					tempBowRow += 1;
//				}
//			}
//
//			if (!this.isHorizontal()) {
//				int tempBowCol = this.getBowColumn();
//				for (int i = 0; i < this.length; i++) {
//					coordinates[i] = tempBowCol;
//					tempBowCol += 1;
//				}
//			}
//			return coordinates;
//		}
		
		Cruiser c = new Cruiser();
		Ocean o = new Ocean();
		System.out.println(Arrays.toString(c.hit));
		System.out.println(o.isOccupied(0, 0));
		
//		for (int i = 0; i < o.test.length; i++) {
//			System.out.println(Arrays.toString(o.test[0]));
//			
//		}
//		
//		System.out.println(Arrays.toString(o.test[0]));
//		
//		EmptySea e = new EmptySea();
//		System.out.println(e.toString());
//		
//		o.placeAllShipsRandomly();
		
		String t = "test";
		System.out.println(t.substring(1, t.length()));
		
	}
	
}
