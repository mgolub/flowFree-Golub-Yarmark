package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private int levelCount;

	private Square[][] squareGrid;
	private Levels levels;
	private Color[][] level;
	private boolean won;
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
		setRestartButton();
		setNextButton();
		setPrevButton();

		squaresPath = new Stack<Square>();

		completePanel.add(topPanel, BorderLayout.NORTH);
		completePanel.add(boardGrid, BorderLayout.CENTER);
		add(completePanel);
		// This must be last in Gui constructor
		getContentPane();
		pack();
	}

	public boolean isWinner() {
		won = true;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (squareGrid[i][j].getPiece1() == null || squareGrid[i][j].getPiece2() == null) {
					won = false;
					break;
				}
			}
		}

		if (won == true) {
			String message = "PERFECT! \n You completed the level in " + movesCount + " moves";
			JOptionPane.showMessageDialog(completePanel, message, "Level Complete", JOptionPane.PLAIN_MESSAGE);
			nextLevel.doClick();
		}
		return won;
	}

	private void setPrevButton() {
		prevLevel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				nextLevel.setEnabled(true);
				levelCount--;
				if (levelCount == 1) {
					prevLevel.setEnabled(false);
				}
				levelNum.setText("           Level " + levelCount);
				level = (Color[][]) levels.getBoard().get(levelCount - 1);
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						squareGrid[i][j].setPiece1(null);
						squareGrid[i][j].setPiece2(null);
						if (level[i][j] != null) {
							Piece dot = (new Dot(level[i][j]));
							squareGrid[i][j].setPiece1(dot);
						}
						squareGrid[i][j].repaint();
					}
				}
				clearMoves();
			}
		});
	}

	private void setNextButton() {
		nextLevel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				prevLevel.setEnabled(true);
				levelCount++;
				if (levelCount == 5) {
					nextLevel.setEnabled(false);
				}
				levelNum.setText("           Level " + levelCount);
				level = (Color[][]) levels.getBoard().get(levelCount - 1);
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						squareGrid[i][j].setPiece1(null);
						squareGrid[i][j].setPiece2(null);
						if (level[i][j] != null) {
							Piece dot = (new Dot(level[i][j]));
							squareGrid[i][j].setPiece1(dot);
						}
						squareGrid[i][j].repaint();
					}
				}
				clearMoves();
			}
		});
	}

	private void setRestartButton() {
		restart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				level = (Color[][]) levels.getBoard().get(levelCount - 1);
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 6; j++) {
						squareGrid[i][j].setPiece1(null);
						squareGrid[i][j].setPiece2(null);
						if (level[i][j] != null) {
							Piece dot = (new Dot(level[i][j]));
							squareGrid[i][j].setPiece1(dot);
						}
						squareGrid[i][j].repaint();
					}
				}
				clearMoves();
			}
		});
	}

	private void setBoardGame() {
		squareGrid = new Square[6][6];
		levels = new Levels();
		level = (Color[][]) levels.getBoard().get(levelCount - 1);

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JPanel squarePanel = new JPanel(new BorderLayout());
				squareGrid[i][j] = new Square(this, i, j);
				squareGrid[i][j].addMouseListener(new SquareMouseListener(squareGrid[i][j], this));
				if (level[i][j] != null) {
					Piece dot = (new Dot(level[i][j]));
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
		levelCount = 1;
		levelNum = new JLabel("          Level " + levelCount);
		levelNum.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 16));
		southTopPanel.add(levelNum, BorderLayout.WEST);
		movesCount = 0;
		movesNum = new JLabel("Moves: " + movesCount + "          ");
		movesNum.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 16));
		southTopPanel.add(movesNum, BorderLayout.EAST);
		// restart = new JButton(new ImageIcon("restart.png"));

		restart = new JButton();
		ImageIcon ii = new ImageIcon(this.getClass().getResource("restart.png"));
		Image image = ii.getImage();
		restart.setIcon(ii);
		restart.setBackground(Color.WHITE);
		/*
		 * String fileName = "restart.png"; ImageIcon image = new
		 * ImageIcon(fileName); restart = new JButton(new ImageIcon(fileName));
		 */
		prevLevel = new JButton(new ImageIcon("prev.png"));
		prevLevel.setBackground(Color.WHITE);
		prevLevel.setEnabled(false);
		nextLevel = new JButton(new ImageIcon("next.png"));
		nextLevel.setBackground(Color.WHITE);
		JPanel midSouth = new JPanel();
		midSouth.setBackground(Color.WHITE);
		midSouth.add(prevLevel);
		midSouth.add(restart);
		midSouth.add(nextLevel);
		southTopPanel.add(midSouth, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.setBackground(Color.BLACK);
		south.setPreferredSize(new Dimension(2, 2));
		southTopPanel.add(south, BorderLayout.SOUTH);
		topPanel.add(southTopPanel, BorderLayout.SOUTH);
		won = false;
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

	public void addMoveNum() {
		movesCount++;
		movesNum.setText("Moves: " + movesCount + "       ");
	}

	public void clearMoves() {
		movesCount = 0;
		movesNum.setText("Moves: " + movesCount + "       ");
	}
}
