package golub.flowFree_Golub_Yarmark;

import java.awt.Color;

public class Level1 {

	/*
	 * IDK IF THIS IS A GOOD IDEA OF HOW TO SET UP THE LEVELS SO MIGHT NEED TO
	 * MODIFY THIS
	 * 
	 * IDEA MAKE A HASHMAP WITH LEVEL NUMBER AS KEY INT[][] AS VALUE
	 * 
	 * 1 = GREEN 2 = YELLOW 3 = MAGENTA 4 = RED 5 = BLUE 6 = CYAN
	 */

	private Color[][] board;
	// private int[][] board;
	private Color[] colors;

	public Level1() {
		colors = new Color[6];
		fillcolorArray();
		board = new Color[6][6];
		board[0][0] = colors[1];
		board[0][1] = colors[1];
		board[0][2] = colors[2];
		board[0][4] = colors[3];
		board[0][5] = colors[4];
		board[1][4] = colors[5];
		board[2][2] = colors[2];
		board[3][2] = colors[3];
		board[4][0] = colors[0];
		board[4][2] = colors[5];
		board[5][0] = colors[1];
		board[5][2] = colors[4];
	}

	private void fillcolorArray() {
		colors[0] = Color.GREEN;
		colors[1] = Color.YELLOW;
		colors[1] = Color.MAGENTA;
		colors[3] = Color.RED;
		colors[4] = Color.BLUE;
		colors[5] = Color.CYAN;
	}

	public Color[][] getBoard() {
		return board;
	}

	public Color getColor(int i, int j) {
		return board[i][j];
	}
}
