package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Piece extends JComponent {

	private static final long serialVersionUID = 1L;

	Color color;
	private int centerX;
	private int centerY;

	public Piece(Color color) {
		this.color = color;
	}
}
