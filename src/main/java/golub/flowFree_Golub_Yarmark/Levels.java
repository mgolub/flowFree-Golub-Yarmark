package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.util.ArrayList;

public class Levels {

	private ArrayList<Color[][]> levels;
	private Color[][] level1;
	private Color[][] level2;
	private Color[][] level3;
	private Color[][] level4;
	private Color[][] level5;
	private Color[] colors;

	public Levels() {
		levels = new ArrayList<Color[][]>();
		colors = new Color[6];
		fillcolorArray();
		level1 = level1();
		level2 = level2();
		level3 = level3();
		level4 = level4();
		level5 = level5();

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

	private Color[][] level2() {
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

	private Color[][] level3() {
		level3 = new Color[6][6];
		level3[1][1] = colors[1];
		level3[1][4] = colors[0];
		level3[2][3] = colors[3];
		level3[4][2] = colors[1];
		level3[4][3] = colors[4];
		level3[4][4] = colors[0];
		level3[5][2] = colors[4];
		level3[5][3] = colors[3];
		return level3;
	}

	private Color[][] level4() {
		level4 = new Color[6][6];
		level4[0][0] = colors[0];
		level4[2][0] = colors[1];
		level4[2][3] = colors[3];
		level4[2][4] = colors[1];
		level4[3][4] = colors[4];
		level4[4][1] = colors[4];
		level4[4][4] = colors[3];
		level4[5][4] = colors[0];
		return level4;
	}

	private Color[][] level5() {
		level5 = new Color[6][6];
		level5[1][0] = colors[4];
		level5[1][1] = colors[3];
		level5[1][2] = colors[1];
		level5[1][3] = colors[2];
		level5[2][0] = colors[3];
		level5[2][3] = colors[0];
		level5[3][0] = colors[0];
		level5[3][5] = colors[4];
		level5[4][1] = colors[1];
		level5[4][4] = colors[2];
		level5[4][5] = colors[5];
		level5[5][3] = colors[5];
		return level5;
	}

	public ArrayList<Color[][]> getBoard() {
		return levels;
	}

}
