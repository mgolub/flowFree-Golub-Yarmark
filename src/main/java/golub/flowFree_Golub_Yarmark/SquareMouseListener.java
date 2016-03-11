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
		}
	}

	public void mouseExited(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Point exit = new Point(event.getX(), event.getY());
			int x = event.getX();
			int y = event.getY();
			int startX, startY, endX, endY;
			if (y == -1) { // (entered from top edge)
				endX = 37;
				endY = -1;
				startX = 37;
				startY = 37;
				square.setPiece2(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (y == 80) {// (entered from bottom edge)
				endX = 37;
				endY = 80;
				startX = 37;
				startY = 37;
				square.setPiece2(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (x == -1) {// (entered from left edge)
				endX = -1;
				endY = 37;
				startX = 37;
				startY = 37;
				square.setPiece2(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
			if (x == 80) {// (entered from right edge)
				endX = 80;
				endY = 37;
				startX = 37;
				startY = 37;
				square.setPiece2(new Line(Color.red, startX, startY, endX, endY));
				square.repaint();
			}
		}

	}

	public void mousePressed(MouseEvent event) {
		System.out.println("mouse pressed");
		square.pushPath();
	}

	public void mouseReleased(MouseEvent arg0) {
		square.clearPathStack();
	}

}
