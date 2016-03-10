package golub.flowFree_Golub_Yarmark;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Piece {
	private static final long serialVersionUID = 1L;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public Line(Color color, Point p, int squareSize) {
		super(color);

		int x = p.getX();
		int y = p.getY();

		// right
		if (x == 0) {
			System.out.println("right");
			startX = 0;
			startY = squareSize / 2;
			endX = squareSize / 2;
			endY = squareSize / 2;
		}

		// left
		if (x == squareSize) {
			startX = squareSize / 2;
			startY = squareSize / 2;
			endX = squareSize;
			endY = squareSize / 2;
		}

		// up
		if (y == squareSize) {
			startX = squareSize / 2;
			startY = squareSize / 2;
			endX = squareSize / 2;
			endY = squareSize;
		}

		// down
		if (y == 0) {
			System.out.println("this should be down");
			startX = squareSize / 2;
			startY = squareSize / 2;
			endX = squareSize / 2;
			endY = squareSize;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		// Graphics2D g2 = (Graphics2D) g;
		// super.paintComponent(g2);
		// g2.setStroke(new BasicStroke(3));
		// g2.setColor(this.color);
		// g2.drawLine(startX, startY, endX, endY);
		g.drawLine(startX, startY, endX, endY);
		System.out.println("draw line");
	}
}
