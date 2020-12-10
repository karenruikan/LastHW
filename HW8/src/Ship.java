/**
 * 
 * @author Karen Kan, Sarah Shamsie
 *
 */
public abstract class Ship {

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
    
    
    
    
    
    
}
