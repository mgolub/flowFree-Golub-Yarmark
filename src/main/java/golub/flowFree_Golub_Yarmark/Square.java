package golub.flowFree_Golub_Yarmark;

import java.awt.Point;

import javax.swing.JPanel;

public class Square extends JPanel {

	private CanvasMouseListener listener;
	private Piece piece1;
	private Piece piece2;
	private Point middle;
	private Point enterPoint;
	private Point exitPoint;

	public void setPiece1(Piece piece1) {
		if (piece1 != this.piece2 /* && this.piece1 != "dot" */) {
			this.piece1 = piece1;
		}
	}

	public void setPiece2(Piece piece2) {
		if (piece2 != this.piece1 /* && this.piece2 != "dot" */ ) {
			this.piece2 = piece2;
		}
	}
}
