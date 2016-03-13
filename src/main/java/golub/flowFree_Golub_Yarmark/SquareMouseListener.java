package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class SquareMouseListener implements MouseListener {

	private Square square;
	private Gui gui;

	public SquareMouseListener(Square component, Gui gui) {
		square = component;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Color lineColor = square.getPath().peek().getLineColor();
			int x = event.getX();
			int y = event.getY();
			int startX, startY, endX, endY;
			if (y >= 0 && y < 10) { // (entered from top edge)
				startX = 38;
				startY = 0;
				endX = 38;
				endY = 38;
				square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			else if (y <= 79 && y > 69) {// (entered from bottom edge)
				startX = 38;
				startY = 79;
				endX = 38;
				endY = 38;
				square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			else if (x >= 0 && x < 10) {// (entered from left edge)
				startX = 0;
				startY = 38;
				endX = 38;
				endY = 38;
				square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			else if (x <= 79 && x > 69) {// (entered from right edge)
				startX = 79;
				startY = 38;
				endX = 38;
				endY = 38;
				square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
		}
	}

	public void mouseExited(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Color lineColor = square.getPath().peek().getLineColor();
			Point exit = new Point(event.getX(), event.getY());
			int x = event.getX();
			int y = event.getY();
			int startX, startY, endX, endY;
			if (y >= -1 && y < 9) { // (entered from top edge)
				endX = 38;
				endY = -1;
				startX = 38;
				startY = 38;
				square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			if (y <= 80 && y > 70) {// (entered from bottom edge)
				endX = 38;
				endY = 80;
				startX = 38;
				startY = 38;
				square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			if (x >= -1 && x < 9) {// (entered from left edge)
				endX = -1;
				endY = 38;
				startX = 38;
				startY = 38;
				square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
			if (x <= 80 && x > 70) {// (entered from right edge)
				endX = 80;
				endY = 38;
				startX = 38;
				startY = 38;
				square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
				square.repaint();
			}
		}

	}

	public void mousePressed(MouseEvent event) {
		if (square.getPiece1() != null){
		square.pushPath();
		Square s = square.getPath().peek();
		// only need a getPiece1 method because piece2's color will always be
		// based on piece1
		s.setLineColor(s.getPiece1().getColor());
		gui.addMoveNum();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		square.clearPathStack();
		
		
	}

}
