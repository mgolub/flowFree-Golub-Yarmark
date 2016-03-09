package golub.flowFree_Golub_Yarmark;

import java.awt.Color;

import javax.swing.JComponent;

public class Piece extends JComponent {

	private static final long serialVersionUID = 1L;

	Color color;
	private int centerX;
	private int centerY;

	public Piece(Color color) {
		this.color = color;
		centerX = this.getWidth() / 2;
		centerY = this.getHeight() / 2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

}
