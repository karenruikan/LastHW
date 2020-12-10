
public class Ship {

    //the row (0 to 9) which contains the bow (front) of the ship.
    int bowRow;
    //the column (0 to 9) which contains the bow (front) of the ship.
    int bowColumn;
    //the number of squares occupied by the ship. An ”empty sea” location has length 1.
    int length; 
    //true if the ship occupies a single row, false otherwise.
    boolean horizontal;
    //an array of booleans telling whether that part of the ship has been hit. 
    //Only battleships use all four locations; 
    //cruisers use the first three; destroyers 2; 
    //submarines 1; and ”empty sea” either one or none.
    boolean [] hit = new boolean[4]; 
    
    //Returns the length of this particular ship. 
    int getLength()
   
    int getBowRow()
    int getBowColumn()
    boolean isHorizontal()
    
    //Sets the value of bowRow
    void setBowRow(int row)
    //Sets the value of bowColumn
    void setBowColumn(int column)
    //Sets the value of the instance variable hori- zontal.
    void setHorizontal(boolean horizontal)
    
    abstract String getShipType()
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean)
    
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean)

    boolean shootAt(int row, int column)
    
    boolean isSunk()
    
    @Override
    public String toString()
    
    
   
}
