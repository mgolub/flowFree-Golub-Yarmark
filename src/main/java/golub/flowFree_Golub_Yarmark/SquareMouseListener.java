package golub.flowFree_Golub_Yarmark;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class SquareMouseListener implements MouseListener {

	private Square square;
	private Gui gui;
	private final int center = 38;

	public SquareMouseListener(Square component, Gui gui) {
		square = component;
		this.gui = gui;
	}

	public void mouseClicked(MouseEvent event) {
	}

	public void mouseEntered(MouseEvent event) {

		if (!square.getPath().isEmpty()) {
			Square previous = square.getPath().peek();
			Color lineColor = previous.getLineColor();
			boolean backtrack = false;

			// (entered from bottom edge)
			if (square.getRow() - previous.getRow() == -1 && square.getCol() == previous.getCol()) {

				if (checkPreviousDot(previous)) {
					drawLine(lineColor, previous, center, 0, center, center);
				}

				if (checkCurrentSquare(previous)) {
					drawLine(lineColor, previous, center, 0, center, center);
					drawLine(lineColor, square, center, 79, center, center);
				} else {
					if (square.getPath().size() > 1) {
						backtrack = checkBacktrack();
					}
				}

				if (checkCurrentDot(previous)) {
					if (!backtrack) {
						drawLine(lineColor, previous, center, 0, center, center);
						drawLine(lineColor, square, center, 79, center, center);
						square.getPath().clear();
					}
				}
			}

			// (entered from top edge)
			else if (square.getRow() - previous.getRow() == 1 && square.getCol() == previous.getCol()) {

				if (checkPreviousDot(previous)) {
					drawLine(lineColor, previous, center, center, center, 79);
				}

				if (checkCurrentSquare(previous)) {
					drawLine(lineColor, previous, center, center, center, 79);
					drawLine(lineColor, square, center, 0, center, center);
				} else {
					if (square.getPath().size() > 1) {
						backtrack = checkBacktrack();
					}
				}

				if (checkCurrentDot(previous)) {
					if (!backtrack) {
						drawLine(lineColor, previous, center, center, center, 79);
						drawLine(lineColor, square, center, 0, center, center);
						square.getPath().clear();
					}
				}
			}

			// (entered from left edge)
			else if (square.getCol() - previous.getCol() == -1 && square.getRow() == previous.getRow()) {

				if (checkPreviousDot(previous)) {
					drawLine(lineColor, previous, 0, center, center, center);
				}

				if (checkCurrentSquare(previous)) {
					drawLine(lineColor, previous, 0, center, center, center);
					drawLine(lineColor, square, 79, center, center, center);
				} else {
					if (square.getPath().size() > 1) {
						backtrack = checkBacktrack();
					}
				}

				if (checkCurrentDot(previous)) {
					if (!backtrack) {
						drawLine(lineColor, previous, 0, center, center, center);
						drawLine(lineColor, square, 79, center, center, center);
						square.getPath().clear();
					}
				}
			}

			// (entered from right edge)
			else if (square.getCol() - previous.getCol() == 1 && square.getRow() == previous.getRow()) {

				if (checkPreviousDot(previous)) {
					drawLine(lineColor, previous, center, center, 79, center);
				}

				if (checkCurrentSquare(previous)) {
					drawLine(lineColor, previous, center, center, 79, center);
					drawLine(lineColor, square, 0, center, center, center);
				} else {
					if (square.getPath().size() > 1) {
						backtrack = checkBacktrack();
					}
				}

				if (checkCurrentDot(previous)) {
					if (!backtrack) {
						drawLine(lineColor, previous, center, center, 79, center);
						drawLine(lineColor, square, 0, center, center, center);
						square.getPath().clear();
					}
				}
			}
		}
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
		if (square.getPiece1() != null) {
			gui.setCursor(Cursor.HAND_CURSOR);
			square.pushPath();
			Square s = square.getPath().peek();
			// only need a getPiece1 method because piece2's color will always
			// be based on piece1
			s.setLineColor(s.getPiece1().getColor());
			gui.addMoveNum();
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		gui.setCursor(Cursor.DEFAULT_CURSOR);
		square.clearPathStack();
		gui.isWinner();
	}

	private void drawLine(Color lineColor, Square currentSquare, int startX, int startY, int endX, int endY) {
		currentSquare.setLineColor(lineColor);
		if (square.getPath().peek() != square) {
			square.getPath().push(this.square);
		}
		if (currentSquare.getPiece1() == null) {
			currentSquare.setPiece1(new Line(lineColor, startX, startY, endX, endY));
		} else {
			currentSquare.setPiece2(new Line(lineColor, startX, startY, endX, endY));
		}
		currentSquare.repaint();
	}

	private boolean checkPreviousDot(Square previous) {
		// if previous square is dot
		if ((previous.getPiece1().getClass().equals(Dot.class) && square.getPiece1() == null)) {
			return true;
		}
		return false;
	}

	private boolean checkCurrentSquare(Square previous) {
		// if current square does not have any pieces
		if (square.getPiece1() == null) {
			return true;
		} else if (square.getPiece1().getClass() != Dot.class && square.getPiece2() == null
				&& square.getLineColor().equals(previous.getLineColor())) {
			square.setPiece2(square.getPiece1());
			square.setPiece1(null);
			return true;
		}
		return false;
	}

	private boolean checkCurrentDot(Square previous) {
		// if the current square is a dot
		if ((square.getPiece1().getClass().equals(Dot.class) && square.getPiece1().getColor()
				.equals(previous.getLineColor()))) {
			return true;
		}
		return false;
	}

	private boolean checkBacktrack() {
		// check for backtrack
		// the 2nd element from top of stack will = current square
		Stack<Square> stack = square.getPath();
		if (this.square.equals(stack.get(stack.size() - 2))) {
			Square previousSquare = square.getPath().pop();

			previousSquare.setPiece1(null);
			square.setPiece2(null);
			previousSquare.repaint();
			square.repaint();
			return true;
		}
		return false;
	}
}
