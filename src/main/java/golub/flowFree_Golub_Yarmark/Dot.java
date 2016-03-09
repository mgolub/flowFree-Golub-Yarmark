package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;


public class Dot extends Piece {

	private static final long serialVersionUID = 1L;


	public Dot(Color color) {
		super(color);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillOval(20, 20, getWidth() - (getWidth() / 2), getHeight() - (getHeight() / 2));
		
	}
}
