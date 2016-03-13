package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends Piece {

	public Dot(Color color) {
		super(color);
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		g.setColor(getColor());
		g.fillOval(20, 20, width - (width / 2), height - (height / 2));

	}
}
