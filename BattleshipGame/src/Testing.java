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
		System.out.println(Arrays.toString(c.hit));
		
	}
	
}
