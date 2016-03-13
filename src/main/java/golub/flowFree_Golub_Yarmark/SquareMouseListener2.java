package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SquareMouseListener2 implements MouseListener {

	private Square square;
	private Gui gui;

	public SquareMouseListener2(Square component, Gui gui) {
		square = component;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			Color lineColor = square.getPath().peek().getLineColor();
			int startX, startY, endX, endY;
			// (entered from top edge)
			if (square.getRow() - previous.getRow() == -1) {
				// if current square does not have any pieces
				if (square.getPiece1() == null) {
					square.setLineColor(lineColor);
					square.getPath().push(this.square);
					startX = 38;
					startY = 79;
					endX = 38;
					endY = 38;
					square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (entered from bottom edge)
			else if (square.getRow() - previous.getRow() == 1) {
				if (square.getPiece1() == null) {
					square.setLineColor(lineColor);
					square.getPath().push(this.square);
					startX = 38;
					startY = 0;
					endX = 38;
					endY = 38;
					square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (entered from left edge)
			else if (square.getCol() - previous.getCol() == -1) {
				if (square.getPiece1() == null) {
					square.setLineColor(lineColor);
					square.getPath().push(this.square);
					startX = 79;
					startY = 38;
					endX = 38;
					endY = 38;
					square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (entered from right edge)
			else if (square.getCol() - previous.getCol() == 1) {
				if (square.getPiece1() == null) {
					square.setLineColor(lineColor);
					square.getPath().push(this.square);
					startX = 0;
					startY = 38;
					endX = 38;
					endY = 38;
					square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
		}
	}

	public void mouseExited(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			Color lineColor = square.getPath().peek().getLineColor();
			int startX, startY, endX, endY;
			// (exited from top edge)
			if (square.getRow() - previous.getRow() == -1) {
				if (square.getPiece1() == null) {
					endX = 38;
					endY = -1;
					startX = 38;
					startY = 38;
					square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (exited from bottom edge)
			if (square.getRow() - previous.getRow() == 1) {
				if (square.getPiece1() == null) {
					endX = 38;
					endY = 80;
					startX = 38;
					startY = 38;
					square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (exited from left edge)
			if (square.getCol() - previous.getCol() == -1) {
				if (square.getPiece1() == null) {
					endX = -1;
					endY = 38;
					startX = 38;
					startY = 38;
					square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
			// (exited from right edge)
			if (square.getCol() - previous.getCol() == 1) {
				if (square.getPiece1() == null) {
					endX = 80;
					endY = 38;
					startX = 38;
					startY = 38;
					square.setPiece2(new Line(lineColor, startX, startY, endX, endY));
					square.repaint();
				}
			}
		}

	}

	public void mousePressed(MouseEvent event) {
		if (square.getPiece1() != null) {
			square.pushPath();
			Square s = square.getPath().peek();
			// only need a getPiece1 method because piece2's color will always
			// be based on piece1
			s.setLineColor(s.getPiece1().getColor());
			gui.addMoveNum();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		square.clearPathStack();

	}

}
