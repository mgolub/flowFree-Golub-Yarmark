package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Piece {
	private static final long serialVersionUID = 1L;

	private int lineWidth;
	private int lineHeight;
	private int startX;
	private int startY;

	public Line(Color color, Point p, int parentWidth, int parentHeight) {
		super(color);
		this.lineWidth = parentWidth / 3;
		this.lineHeight = parentHeight / 3;
		setSize(lineWidth, lineHeight);

		int x = p.getX();
		int y = p.getY();
		// left
		if (x == 0) {
			startX = 0;
			startY = lineHeight;
		}
		// right
		if (x == parentWidth) {
			startX = lineWidth;
			startY = lineHeight;
		}
		// up
		if (y == 0) {
			startX = lineWidth;
			startY = 0;
		}
		// down
		if (y == parentHeight) {
			startX = lineWidth;
			startY = lineHeight;
		}
		this.startX = p.getX();
		this.startY = p.getY();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		 g.fillRect(startX, startY, lineWidth, lineHeight);
	}
}
