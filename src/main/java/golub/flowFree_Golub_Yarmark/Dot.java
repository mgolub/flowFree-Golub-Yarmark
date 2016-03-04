package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Dot extends JButton{
	
	
	private static final long serialVersionUID = 1L;
	private Color color;
	private int x;
	private int y;
	
	public Dot(int x, int y, Color color){
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(x, y, 40, 40);
	}
}
