package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SquareMouseListener implements MouseListener {

	private Square square;

	public SquareMouseListener(Square component) {
		square = component;
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {

		if (!square.getPath().isEmpty()) {
			int x = event.getX();
			int y = event.getY();
			int startX, startY, endX, endY;
			if (y == 0) { // (entered from top edge)
				startX = 37;
				startY = 0;
				endX = 37;
				endY = 37;
				square.setPiece1(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (y == 79) {// (entered from bottom edge)
				startX = 37;
				startY = 79;
				endX = 37;
				endY = 37;
				square.setPiece1(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (x == 0) {// (entered from left edge)
				startX = 0;
				startY = 37;
				endX = 37;
				endY = 37;
				square.setPiece1(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (x == 79) {// (entered from right edge)
				startX = 79;
				startY = 37;
				endX = 37;
				endY = 37;
				square.setPiece1(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			/*
			 * Square previous = square.getPath().peek(); // up if
			 * (square.getRow() - previous.getRow() == -1) { // WILL NEED TO GET
			 * THE COLOR FORM THE PREVIOUS PIECE square.setPiece1(new
			 * Line(Color.RED, square.getWidth())); square.repaint(); } // down
			 * else if (square.getRow() - previous.getRow() == 1) {
			 * square.setPiece1(new Line(Color.RED, square.getWidth()));
			 * square.repaint(); } // right else if (square.getCol() -
			 * previous.getCol() == -1) { square.setPiece1(new Line(Color.RED,
			 * square.getWidth())); square.repaint(); } // left else if
			 * (square.getCol() - previous.getCol() == 1) { square.setPiece1(new
			 * Line(Color.RED, square.getWidth())); square.repaint(); }
			 */
		}
	}

	public void mouseExited(MouseEvent event) {
		Point exit = new Point(event.getX(), event.getY());
		square.addExitLine(exit);

	}

	public void mousePressed(MouseEvent event) {
		System.out.println("mouse pressed");
		square.pushPath();
	}

	public void mouseReleased(MouseEvent arg0) {
		square.clearPathStack();
	}

}
