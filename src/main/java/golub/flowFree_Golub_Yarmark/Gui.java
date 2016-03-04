package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

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

	private JButton[][] gameBoard;
	private JButton restart;

	private Square[][] squareGrid;
	private Level1 level1;
	private int[][] level;

	public Gui() {
		setTitle("Flow Free");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPanels();
		setLabelButtons();
		setBoardGame();

		completePanel.add(topPanel, BorderLayout.NORTH);
		completePanel.add(boardGrid, BorderLayout.CENTER);
		getContentPane().add(completePanel);
		pack();
	}

	private void setBoardGame() {
		gameBoard = new JButton[6][6];
		squareGrid = new Square[6][6];
		level1 = new Level1();
		level = level1.getBoard();

		BufferedImage circleImg = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = circleImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 4;
		int y = x;
		int width = 60 - 2 * x;
		int height = 60 - 2 * y;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				squareGrid[i][j] = new Square();// do we need this line of
												// code???
				gameBoard[i][j] = new JButton();
				gameBoard[i][j].setBackground(Color.BLACK);
				gameBoard[i][j].setPreferredSize(new Dimension(80, 80));
				gameBoard[i][j].setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
				boardGrid.add(gameBoard[i][j]);

				// TEMP
				// GOING TO HAVE TO SWITCH THIS WHEN DOT PIECE FINISHED
				switch (level[i][j]) {
				case 1:
					g2.setColor(Color.GREEN);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				case 2:
					g2.setColor(Color.YELLOW);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				case 3:
					g2.setColor(Color.MAGENTA);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				case 4:
					g2.setColor(Color.RED);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				case 5:
					g2.setColor(Color.BLUE);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				case 6:
					g2.setColor(Color.CYAN);
					g2.fillOval(x, y, width, height);
					g2.dispose();
					gameBoard[i][j].setIcon(new ImageIcon(circleImg));
					break;
				}

			}
		}

	}

	public void drawCenteredCircle(Graphics2D g, int x, int y, int r, Color color) {
		x = x - (r / 2);
		y = y - (r / 2);
		g.setColor(color);
		g.fillOval(x, y, r, r);
	}

	private void setLabelButtons() {
		title = new JLabel("Flow Free");
		title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 48));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(title, BorderLayout.CENTER);

		levelNum = new JLabel("Level 1");
		southTopPanel.add(levelNum, BorderLayout.WEST);
		movesNum = new JLabel("Moves: 0");
		southTopPanel.add(movesNum, BorderLayout.EAST);
		topPanel.add(southTopPanel, BorderLayout.SOUTH);
	}

	private void setPanels() {
		completePanel = new JPanel(new BorderLayout());
		topPanel = new JPanel(new BorderLayout());
		boardGrid = new JPanel(new GridLayout(6, 6));
		southTopPanel = new JPanel(new BorderLayout());
	}

}
