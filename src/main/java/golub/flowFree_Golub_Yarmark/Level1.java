package golub.flowFree_Golub_Yarmark;

public class Level1 {
	
	/*IDK IF THIS IS A GOOD IDEA OF HOW TO SET UP THE LEVELS SO 
	 * MIGHT NEED TO MODIFY THIS
	 * 
	 * 1 = GREEN
	 * 2 = YELLOW
	 * 3 = MAGENTA
	 * 4 = RED
	 * 5 = BLUE
	 * 6 = CYAN
	 */
	
	private int[][] board;
	
	public Level1(){
		board = new int[6][6];
		board[0][0] = 1;
		board[0][1] = 2;
		board[0][2] = 3;
		board[0][4] = 4;
		board[0][5] = 5;
		board[1][4] = 6;
		board[2][2] = 3;
		board[3][2] = 4;
		board[4][0] = 1;
		board[4][2] = 6;
		board[5][0] = 2;
		board[5][2] = 5;
	}

	public int[][] getBoard() {
		return board;
	}

}
