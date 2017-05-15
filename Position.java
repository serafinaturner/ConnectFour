/**
 * Position class that creates a position object to represent a spot on the board
 * @author 18turner
 * @version 5-30-17
 */
public class Position {
	private int row;
	private int col;
	
	
	/**
	 * constructor for position
	 * @param r
	 * @param c
	 */
	public Position(int r, int c){
		row = r;
		col =c;
	}
	
	/**
	 * accessor method for row
	 * @return
	 */
	public int getRow(){return row;}
	
	/**
	 * accessor method for col
	 * @return
	 */
	public int getColumn(){return col;}
	
	/**
	 * mutator method for row
	 * @param r
	 */
	public void setRow(int r){this.row = r;}
	
	/**
	 * mutator method for col
	 * @param c
	 */
	public void setCol(int c){
		this.col = c;
	}
	
	/**
	 *  overrides the equals method in the Object class
	 *  @return true if the object is a Position object and the row and col of both object are equal, false otherwise 
	 */
	public boolean equals(Object other){
		if(other instanceof Position){
				return this.row == ((Position)other).getRow() && this.col == ((Position) other).getColumn();
		}
		else
			return false;
		
	}

}
