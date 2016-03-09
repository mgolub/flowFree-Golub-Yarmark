package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;


public class SquareMouseListener implements MouseListener {
	
	private Square square;

	public SquareMouseListener(Square component) {
		square = component;
	}

	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
		Piece line = (new Line(Color.WHITE, 1, 35));
		square.setBackground(Color.WHITE);
		square.validate();
		square.repaint();	
	}

	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		Point exit = event.getPoint();
		square.addExitLine(exit);
		
		
	}

	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
