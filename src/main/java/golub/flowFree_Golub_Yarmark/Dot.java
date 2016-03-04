package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Dot extends Piece {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	public Dot(Color color) {
		super(color);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillOval(10, 10, getWidth() - (getWidth() / 10), getHeight() - (getHeight() / 10));
	}
}
