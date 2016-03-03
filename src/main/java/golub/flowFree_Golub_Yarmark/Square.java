package golub.flowFree_Golub_Yarmark;

import java.awt.Point;

import javax.swing.JPanel;

public class Square extends JPanel {

	private CanvasMouseListener listener;
	private Piece piece1;
	private Piece peice2;
	private Point middle;
	
	
	
	public void setPiece1(Piece piece1) {
		this.piece1 = piece1;
	}
	public void setPeice2(Piece peice2) {
		this.peice2 = peice2;
	}
}
