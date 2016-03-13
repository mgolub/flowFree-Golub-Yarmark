package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel completePanel;
	private JPanel topPanel;
	private JPanel boardGrid;
	private JPanel southTopPanel;

	private JLabel title;
	private JLabel levelNum;
	private JLabel movesNum;
	private int movesCount;

	private JButton restart;
	private JButton prevLevel;
	private JButton nextLevel;

	private Square[][] squareGrid;
	private Level1 level1;
	private Color[][] level;

	private Stack<Square> squaresPath; // this will keep track of the squares
										// you go into as you create a path

	public Gui() {
		setTitle("Flow Free");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setPanels();
		setLabelButtons();
		setBoardGame();

		squaresPath = new Stack<Square>();

		completePanel.add(topPanel, BorderLayout.NORTH);
		completePanel.add(boardGrid, BorderLayout.CENTER);
		add(completePanel);
		// This must be last in Gui constructor
		getContentPane();
		setVisible(true);
		pack();
	}

	private void setBoardGame() {
		squareGrid = new Square[6][6];
		level1 = new Level1();
		level = level1.getBoard();

		BufferedImage circleImg = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = circleImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 4;
		int y = x;
		// int width = 60 - 2 * x;
		// int height = 60 - 2 * y;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JPanel squarePanel = new JPanel(new BorderLayout());
				squareGrid[i][j] = new Square(this, i, j);
				squareGrid[i][j].addMouseListener(new SquareMouseListener(squareGrid[i][j], this));
				if (level[i][j] != null) {
					Piece dot = (new Dot(level1.getColor(i, j)));
					squareGrid[i][j].setPiece1(dot);

				}

				squarePanel.add(squareGrid[i][j], BorderLayout.CENTER);
				squarePanel.setPreferredSize(new Dimension(80, 80));
				boardGrid.add(squarePanel);
			}
		}

	}

	public Square[][] getSquareGrid() {
		return squareGrid;
	}

	public void setSquareGrid(Square[][] squareGrid) {
		this.squareGrid = squareGrid;
	}

	public void pushPath(Square sq) {
		this.squaresPath.push(sq);
	}

	public Stack<Square> getPath() {
		return this.squaresPath;
	}

	private void setLabelButtons() {
		title = new JLabel("Flow Free");
		title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 60));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(title, BorderLayout.CENTER);

		levelNum = new JLabel("          Level 1");
		levelNum.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 16));
		southTopPanel.add(levelNum, BorderLayout.WEST);
		movesCount = 0;
		movesNum = new JLabel("Moves: " + movesCount + "          " );
		movesNum.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 16));
		southTopPanel.add(movesNum, BorderLayout.EAST);
		restart = new JButton(new ImageIcon("restart.png"));
		restart.setBackground(Color.WHITE);
		prevLevel = new JButton (new ImageIcon ("prev.png"));
		prevLevel.setBackground(Color.WHITE);
		nextLevel = new JButton (new ImageIcon ("next.png"));
		nextLevel.setBackground(Color.WHITE);
		JPanel midSouth = new JPanel();
		midSouth.setBackground(Color.WHITE);
		midSouth.add(prevLevel);midSouth.add(restart);midSouth.add(nextLevel);
		southTopPanel.add(midSouth, BorderLayout.CENTER);
		JPanel south = new JPanel();south.setBackground(Color.BLACK);
		south.setPreferredSize(new Dimension(2,2));
		southTopPanel.add(south, BorderLayout.SOUTH);
		topPanel.add(southTopPanel, BorderLayout.SOUTH);
	}

	private void setPanels() {
		completePanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.WHITE);
		boardGrid = new JPanel(new GridLayout(6, 6));
		boardGrid.setBorder(new LineBorder(Color.WHITE, 30));
		southTopPanel = new JPanel(new BorderLayout());
		southTopPanel.setBackground(Color.WHITE);
	}

	public void clearPathStack() {
		this.squaresPath = new Stack<Square>();
	}
	
	public void addMoveNum(){
		movesCount++;
		movesNum.setText("Moves: " + movesCount + "         ");
	}

}
