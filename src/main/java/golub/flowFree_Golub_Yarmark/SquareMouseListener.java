package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
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
		// this method is called when the mouse moves into a Square
		// even without clicking
		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			// up
			if (square.getRow() - previous.getRow() == -1) {
				// WILL NEED TO GET THE COLOR FORM THE PREVIOUS PIECE
				square.setPiece1(new Line(Color.RED, BorderLayout.NORTH));
				square.repaint();
				System.out.println("got there!");
			}
			// down
			else if (square.getRow() - previous.getRow() == 1) {
			}
			// right
			else if (square.getCol() - previous.getCol() == -1) {
			}
			// left
			else if (square.getCol() - previous.getCol() == 1) {
			}
			square.repaint();
		}
	}

	public void mouseExited(MouseEvent event) {
		Point exit = event.getPoint();
		square.addExitLine(exit);

	}

	public void mousePressed(MouseEvent event) {
		System.out.println("mouse pressed");
		square.pushPath();
	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
