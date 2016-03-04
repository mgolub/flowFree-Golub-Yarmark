package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

;
public class Square extends JComponent {

	private static final long serialVersionUID = 1L;

	private final Color color = Color.BLACK;

	private SquareMouseListener listener;
	private Piece piece1;
	private Piece piece2;
	private Point middle;
	private Point enterPoint;
	private Point exitPoint;

	public Square() {
		this.listener = new SquareMouseListener();
		setLayout(new BorderLayout());
	}

	public void setPiece1(Piece piece1) {
		if (piece1 != this.piece2 /* && this.piece1 != "dot" */) {
			this.piece1 = piece1;
		}
	}

	public void setPiece2(Piece piece2) {
		if (piece2 != this.piece1 /* && this.piece2 != "dot" */) {
			this.piece2 = piece2;
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
			this.add(piece1);
		}
	}
}
