/**
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */
public abstract class Ship {
    
    public Ship() {
	
    }
    
    int bowRow;
    int bowColumn;
    int length; 
    boolean horizontal;

    boolean [] hit = new boolean[4]; 
    
    //get ship length
    int getLength() {
	return this.length;
    }
    //get ship bow row number
    int getBowRow() {
	return this.bowRow;
    }
    //get ship bow column number
    int getBowColumn() {
	return this.bowColumn;
    }
    //check if the ship is horizontal
    boolean isHorizontal() {
	return this.horizontal;
    }
    
    //Sets the value of bowRow
    void setBowRow(int row) {
	this.bowRow = row;
    }
    //Sets the value of bowColumn
    void setBowColumn(int column) {
	this.bowColumn = column;
    }
    //Sets the value of the instance variable horizontal.
    void setHorizontal(boolean horizontal) {
	this.horizontal = horizontal;
    }
    
    //This is an abstract method and it has no body.
    abstract String getShipType() {
	
    }
    
    /**
     * Returns true if it is okay to put a ship of this length with its bow in this location, 
     * with the given orientation, and returns false otherwise. 
     * The ship must not overlap another ship, 
     * or touch another ship (vertically, horizontally, or diagonally), 
     * and it must not ”stick out” beyond the array. 
     * Does not actually change either the ship or the Ocean, 
     * just says whether it is legal to do so.
     * 
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	if horizontal == true 
    }
    
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean)

    boolean shootAt(int row, int column)
    
    boolean isSunk()
    
    @Override
    public String toString()
    
    
   
}
