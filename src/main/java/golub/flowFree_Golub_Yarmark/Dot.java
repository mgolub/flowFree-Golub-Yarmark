package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends Piece {

	public Dot(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		g.setColor(getColor().darker());
		g.fillOval(12, 12, width - (width / 3), height - (height / 3));

	}
}
