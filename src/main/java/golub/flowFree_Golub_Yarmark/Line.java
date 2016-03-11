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

	public Line(Color color, int startX, int startY, int endX, int endY) {
		super(color);
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		g.setColor(getColor());
		g.drawLine(startX, startY, endX, endY);
		System.out.println("draw line");

	}
}
