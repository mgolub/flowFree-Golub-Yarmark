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
		Point p = new Point(event.getX(), event.getY());
		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			// up
			if (square.getRow() - previous.getRow() == -1) {
				// WILL NEED TO GET THE COLOR FORM THE PREVIOUS PIECE
				square.setPiece1(new Line(Color.RED, p, square.getWidth()));
				square.repaint();
			}
			// down
			else if (square.getRow() - previous.getRow() == 1) {
				square.setPiece1(new Line(Color.RED, p, square.getWidth()));
				square.repaint();
			}
			// right
			else if (square.getCol() - previous.getCol() == -1) {
				square.setPiece1(new Line(Color.RED, p, square.getWidth()));
				square.repaint();
			}
			// left
			else if (square.getCol() - previous.getCol() == 1) {
				square.setPiece1(new Line(Color.RED, p, square.getWidth()));
				square.repaint();
			}
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
