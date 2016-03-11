package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

import javax.swing.JComponent;

public class Square extends JComponent {

	private static final long serialVersionUID = 1L;

	private final Color color = Color.BLACK;
	private Piece piece1;
	private Piece piece2;
	private Gui wholeBoard;
	private int row;
	private int col;

	public Square(Gui gui, int row, int col) {
		setLayout(new BorderLayout());
		this.wholeBoard = gui;
		this.row = row;
		this.col = col;
	}

	public void setPiece1(Piece piece1) {
		if (piece1 != this.piece2) {
			this.piece1 = piece1;
			repaint();
		}
	}

	public void setPiece2(Piece piece2) {
		if (piece2 != this.piece1 /* && this.piece2 != "dot" */) {
			this.piece1 = piece2;
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(this.color);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		g.drawRect(0, 0, getWidth(), getHeight());
		if (piece1 != null) {
			
			piece1.draw(g, getWidth(), getHeight());
			
//			if (piece1.getClass().equals(Dot.class)) {
//				Dot dot = (Dot) piece1;
//				dot(g);
//			} else if (piece1.getClass().equals(Line.class)) {
//				this.add(piece1);
//				this.add(piece1, BorderLayout.NORTH);
//				System.out.println("draw square");
//			}
		}
		if ( piece2 != null ) {
			piece2.draw(g, getWidth(), getHeight());
		}
	}

	public void addExitLine(Point exit) {
	}

	public void pushPath() {
		wholeBoard.pushPath(this);
	}

	public Stack<Square> getPath() {
		return wholeBoard.getPath();
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void clearPathStack() {
		this.wholeBoard.clearPathStack();
	}
}
