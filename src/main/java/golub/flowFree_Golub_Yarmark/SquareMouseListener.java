package golub.flowFree_Golub_Yarmark;

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

	}

	public void mouseExited(MouseEvent event) {
		Point exit = event.getPoint();
		square.addExitLine(exit);

	}

	public void mousePressed(MouseEvent event) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
