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

			// (entered from bottom edge)
			if (square.getRow() - previous.getRow() == -1 && square.getCol() == previous.getCol()) {

				// if previous square is dot
				if ((previous.getPiece1().getClass().equals(Dot.class) && square.getPiece1() == null)) {
					drawLine(lineColor, previous, center, 0, center, center);
				}

				// if current square does not have any pieces
				if (square.getPiece1() == null) {
					drawLine(lineColor, square, center, 79, center, center);
				}

				// if the current square is a dot
				if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, square, center, 79, center, center);
				}
			}

			// (entered from top edge)
			else if (square.getRow() - previous.getRow() == 1 && square.getCol() == previous.getCol()) {

				// if previous square is dot
				if ((previous.getPiece1().getClass().equals(Dot.class) && square.getPiece1() == null)) {
					drawLine(lineColor, previous, center, center, center, 79);
				}

				// if current square does not have any pieces
				if (square.getPiece1() == null) {
					drawLine(lineColor, square, center, 0, center, center);
				}

				// if the current square is a dot
				if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, square, center, 0, center, center);
				}
			}

			// (entered from left edge)
			else if (square.getCol() - previous.getCol() == -1 && square.getRow() == previous.getRow()) {

				// if previous square is dot
				if ((previous.getPiece1().getClass().equals(Dot.class) && square.getPiece1() == null)) {
					drawLine(lineColor, previous, 0, center, center, center);
				}

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, square, 79, center, center, center);
				}

				// if the current square is a dot
				if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, square, 79, center, center, center);
				}
			}

			// (entered from right edge)
			else if (square.getCol() - previous.getCol() == 1 && square.getRow() == previous.getRow()) {

				// if previous square is dot
				if ((previous.getPiece1().getClass().equals(Dot.class) && square.getPiece1() == null)) {
					drawLine(lineColor, previous, center, center, 79, center);
				}

				// if current square does not have any pieces or it is a dot
				if (square.getPiece1() == null) {
					drawLine(lineColor, square, 0, center, center, center);
				}

				// if the current square is a dot
				if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
						.equals(previous.getLineColor()))) {
					drawLine(lineColor, square, 0, center, center, center);
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

	// up 38, 38, 38, 0
	// up 38, 38, 0, 38
	// down 38, 38, 38, 79
	// down 38, 79, 38, 38
	// from left 0, 38, 38, 38
	// from left 79, 38, 38, 38
	// to right 38, 38, 38, 79
	// to right 0, 38, 38, 38
	private void drawLine(Color lineColor, Square currentSquare, int startX, int startY, int endX, int endY) {
		currentSquare.setLineColor(lineColor);
		square.getPath().push(this.square);
		// if (previousSquare.getPiece1().getClass().equals(Dot.class)) {
		// previousSquare.setPiece1(new Line(Color.orange, ));
		// previousSquare.repaint();
		// }
		currentSquare.setPiece1(new Line(lineColor, startX, startY, endX, endY));
		currentSquare.repaint();
	}
}
