package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SquareMouseListener2 implements MouseListener {

	private Square square;
	private Gui gui;
	private final int center = 38;

	public SquareMouseListener2(Square component, Gui gui) {
		square = component;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {

		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			Color lineColor = previous.getLineColor();
			int startX, startY, endX, endY;

			// (entered from top edge)
			if (square.getRow() - previous.getRow() == -1 && square.getCol() == previous.getCol()) {

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, previous, square, center, 79, center, center);
				} else if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, previous, square, center, 79, center, center);
				}
			}

			// (entered from bottom edge)
			else if (square.getRow() - previous.getRow() == 1 && square.getCol() == previous.getCol()) {

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, previous, square, center, 0, center, center);
				} else if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, previous, square, center, 0, center, center);
				}
			}

			// (entered from left edge)
			else if (square.getCol() - previous.getCol() == -1 && square.getRow() == previous.getRow()) {

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, previous, square, 79, center, center, center);
				} else if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, previous, square, 79, center, center, center);
				}
			}

			// (entered from right edge)
			else if (square.getCol() - previous.getCol() == 1 && square.getRow() == previous.getRow()) {

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, previous, square, 0, center, center, center);
				} else if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, previous, square, 0, center, center, center);
				}
			}
		}
	}

	public void mouseExited(MouseEvent event) {
		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			Color lineColor = previous.getLineColor();
			int startX, startY, endX, endY;
			/*
			 * // (exited from top edge) // new square is up/down/right/left of
			 * previous if (square.getRow() - previous.getRow() == -1 &&
			 * square.getCol() == previous.getCol()) { startX = center; startY =
			 * center; endX = center; endY = 0; previous.setPiece2(new
			 * Line(lineColor, startX, startY, endX, endY)); previous.repaint();
			 * square.getPath().push(square); endX = center; endY = -1; startX =
			 * center; startY = center;
			 * System.out.println("remember to use or delete the next line");
			 * previous.repaint(); square.setPiece2(new Line(lineColor, startX,
			 * startY, endX, endY)); square.repaint(); // } } // (exited from
			 * bottom edge) if (square.getRow() - previous.getRow() == 1 &&
			 * square.getCol() == previous.getCol()) { if (previous.getPiece1()
			 * != null) { endX = center; endY = 80; startX = center; startY =
			 * center; square.setPiece2(new Line(lineColor, startX, startY,
			 * endX, endY)); square.repaint(); }
			 * 
			 * } // (exited from left edge) if (square.getCol() -
			 * previous.getCol() == -1 && square.getRow() == previous.getRow())
			 * { if (previous.getPiece1() != null) { endX = -1; endY = center;
			 * startX = center; startY = center; square.setPiece2(new
			 * Line(lineColor, startX, startY, endX, endY)); square.repaint(); }
			 * 
			 * } // (exited from right edge) if (square.getCol() -
			 * previous.getCol() == 1 && square.getRow() == previous.getRow()) {
			 * if (previous.getPiece1() != null) { endX = 80; endY = center;
			 * startX = center; startY = center; square.setPiece2(new
			 * Line(lineColor, startX, startY, endX, endY)); square.repaint(); }
			 * 
			 * }
			 */
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

	private void drawLine(Color lineColor, Square previousSquare, Square currentSquare, int startX, int startY,
			int endX, int endY) {
		square.setLineColor(lineColor);
		square.getPath().push(this.square);
		previousSquare.setPiece1(new Line(Color.orange, startX, startY, endX, endY));
		square.setPiece1(new Line(lineColor, startX, startY, endX, endY));
		square.repaint();
	}
}
