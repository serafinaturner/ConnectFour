/**
 * plays the game Connect Four, represents the base logic for the game
 * @author 18turner/18capehart
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
		board = new int[6][7];
		winningPositions = new Position[4];
		winningPositions[0] = new Position(-1, -1);
		winningPositions[1] = new Position(-1, -1);
		winningPositions[2] = new Position(-1, -1);
		winningPositions[3] = new Position(-1, -1);
		currentPlayer = 1;
	}
	
	 /**
     * Prepares the board for a new game
     */
	public void newGame(){
		for(int i = 0; i < board.length; i++) {
			for(int k = 0; k < board[0].length; k++) {
				board[i][k] = 0;
			}
		}
		winner = 0;
		winningPositions = new Position[4];
		winningPositions[0] = new Position(-1, -1);
		winningPositions[1] = new Position(-1, -1);
		winningPositions[2] = new Position(-1, -1);
		winningPositions[3] = new Position(-1, -1);
		currentPlayer = 1;
	}
	
	/**
    * Is the game over?
    * @return true if the game is over, false otherwise
    */
    public boolean gameOver(){
    	if(getWinner() != 0) {
    		winner = getWinner();
    		return true;
    	}
    	else {
    		for(int i = 0; i < 6; i++) {
        		for(int k = 0; k < 7; k++) {
        			if(board[i][k] == 0)
        				return false;
        		}
        		
        	}
    		return true;
    	}
    }
	
    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    public int getWinner(){

    	//start of winner via row
    	for(int k = 0; k < board.length; k++) {
    		for(int i = 0; i < 4; i++) {
    			if(board[k][i] == board[k][i+1] && board[k][i+1] == board[k][i+2] && board[k][i+2] == board[k][i+3] && board[k][i+3] != 0) {
    				winningPositions[0] = new Position(k, i);
    				winningPositions[1] = new Position(k, i+1);
    				winningPositions[2] = new Position(k, i+2);
    				winningPositions[3] = new Position(k, i+3);
    				return board[k][i+3];
    			}
    		}
    	}
    	//end of winner via row
    	
    	//start of winner via column
    	for(int j = 0; j < 3; j++) {
    		for(int h = 0; h < board[0].length; h++) {
    			if(board[j][h] == board[j+1][h] && board[j+1][h] == board[j+2][h] && board[j+2][h] == board[j+3][h] && board[j+2][h] != 0) {
    				winningPositions[0] = new Position(j, h);
    				winningPositions[1] = new Position(j+1, h);
    				winningPositions[2] = new Position(j+2, h);
    				winningPositions[3] = new Position(j+3, h);
    				return board[j+2][h];
    			}
    		}
    	}
    	//end of winner via column
    	
    	//start of winner via left diagonal 
    	for(int k = 0; k < 3; k++) {
    		for(int i = 3; i < board[0].length; i++) {
    			if(board[k][i] == board[k+1][i-1] && board[k+1][i-1] == board[k+2][i-2] && board[k+2][i-2] == board[k+3][i-3] && board[k][i] != 0) {
    				winningPositions[0] = new Position(k, i);
    				winningPositions[1] = new Position(k+1, i-1);
    				winningPositions[2] = new Position(k+2, i-2);
    				winningPositions[3] = new Position(k+3, i-3);
    				return board[k][i];
    			}
    		}
    	}
    	//end of winner via left diagonal
    	
    	//start of winner via right diagonal
    	for(int k = 0; k < 3; k++) {
    		for(int i = 0; i < 4; i++) {
    			if(board[k][i] == board[k+1][i+1] && board[k+1][i+1] == board[k+2][i+2] && board[k+2][i+2] == board[k+3][i+3] && board[k][i] != 0) {
    				winningPositions[0] = new Position(k, i);
    				winningPositions[1] = new Position(k+1, i+1);
    				winningPositions[2] = new Position(k+2, i+2);
    				winningPositions[3] = new Position(k+3, i+3);
    				return board[k][i];
    			}
    		}
    	}
    	//end of winner via right diagonal
    	
    	return winner;
    }
    
    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    public Position[] getWinningPositions(){
    	return winningPositions;
    }
    
    /**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
    public boolean columnFull(int column){
    	if(board[0][column] != 0) {
    		return true;
    	}
    	else
    		return false;
    }
    
    /**
     * Change the game to reflect the current player placing a piece in the column and changes the player.
     * @param column the column number
     */
    public void play(int column){
    	if(!columnFull(column)) {
    		for(int k = board.length-1; k >= 0; k--) {
    			if(board[k][column] == 0) {
    				board[k][column] = currentPlayer;
    				break;
    			}
    		}
    	}
    	if(currentPlayer == 1)
    		currentPlayer = 2;
    	else 
    		currentPlayer = 1;
    }
    
    /**
     * What is the current board configuration?
     * @return for each cell on the board grid: 
     *   0 if it is not filled, 
     *   1 if it is filled by the first player's piece, 
     *   2 if it is filled by the second player's piece.
     */
    public int[][] getBoard(){
    	return board;
    }
	
}
