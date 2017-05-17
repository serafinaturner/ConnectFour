/**
 * plays the game Connect Four, represents the base logic for the game
 * @author 18turner
 * @version 5-30-17
 */
public class ConnectFour implements BoardGame{
	private int[][] board;
	private int currentPlayer;
	private Position[] winningPositions;
	private int winner;
	
	/**
	 * no args constructor
	 */
	public ConnectFour(){
		board = new int[7][6];
		winningPositions = new Position[4]; //does this  work?
		currentPlayer = 0;
		winner = 0;
	}
	
	 /**
     * Prepares the board for a new game.7
     */
	public void newGame(){
		
	}
	
	/**
    * Is the game over?
    * @return true if the game is over, false otherwise
    */
    public boolean gameOver(){
    	return false;
    }
	
    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    public int getWinner(){
    	return 0;
    }
    
    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public Position[] getWinningPositions(){
    	return null;
    }
    
    /**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
   public boolean columnFull(int column){
    	boolean full = true;
    	for(int i = 0; i < board[column].length; i++) {
    		if(board[column][i] == 0)
    			full = false;
    	}
    	return full;
    }
    /**
     * Change the game to reflect the current player placing a piece in the column.
     * @param column the column number
     */
    public void play(int column){
    	
    }
    
	 /**
     * What is the current board configuration?
     * @return for each cell on the board grid: 
     *   0 if it is not filled, 
	 *   1 if it is filled by the first player's piece, 
	 *   2 if it is filled by the second player's piece.
     */
    public int[][] getBoard(){
    	return null;
    }
}
