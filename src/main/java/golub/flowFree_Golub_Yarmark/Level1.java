package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.util.ArrayList;

public class Level1 {

	private ArrayList<Color[][]> levels;
	private Color[][] level1;
	private Color[][] level2;
	private Color[][] level3;
	private Color[][] level4;
	private Color[][] level5;
	private Color[] colors;

	public Level1() {
		levels = new ArrayList<Color[][]>();
		colors = new Color[6];
		fillcolorArray();
		level1 = level1();
		level2 = level2();

		levels.add(level1);
		levels.add(level2);
		levels.add(level3);
		levels.add(level4);
		levels.add(level5);
	}

	private void fillcolorArray() {
		colors[0] = Color.GREEN;
		colors[1] = Color.YELLOW;
		colors[2] = Color.MAGENTA;
		colors[3] = Color.RED;
		colors[4] = Color.BLUE;
		colors[5] = Color.CYAN;
	}

	private Color[][] level1() {
		level1 = new Color[6][6];
		level1[0][0] = colors[0];
		level1[0][1] = colors[1];
		level1[0][2] = colors[2];
		level1[0][4] = colors[3];
		level1[0][5] = colors[4];
		level1[1][4] = colors[5];
		level1[2][2] = colors[2];
		level1[3][2] = colors[3];
		level1[4][0] = colors[0];
		level1[4][2] = colors[5];
		level1[5][0] = colors[1];
		level1[5][2] = colors[4];
		return level1;
	}
	
	private Color[][] level2(){
		level2 = new Color[6][6];
		level2[0][1] = colors[2];
		level2[0][2] = colors[4];
		level2[0][5] = colors[0];
		level2[2][2] = colors[1];
		level2[2][3] = colors[3];
		level2[2][5] = colors[0];
		level2[3][3] = colors[5];
		level2[3][5] = colors[4];
		level2[4][1] = colors[3];
		level2[4][2] = colors[1];
		level2[4][4] = colors[5];
		level2[4][5] = colors[2];
		return level2;
	}

	public ArrayList getBoard() {
		return levels;
	}

	public Color getColor(int i, int j) {
		return level1[i][j];
	}
}
