package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Piece {
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;

	public Line(Color color, String direction) {
		super(color, direction);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillRect(x, y, (getWidth() - (getWidth() / 2)), 10);
	}
}
