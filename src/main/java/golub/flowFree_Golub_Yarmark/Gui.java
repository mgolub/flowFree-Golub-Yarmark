package golub.flowFree_Golub_Yarmark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Gui extends JFrame{
	
	private JPanel completePanel;
	private JPanel topPanel;
	private JPanel boardGrid;
	private JPanel southTopPanel;
	
	private JLabel title;
	private JLabel level;
	private JLabel moves;
	
	private JButton[][] gameBoard;
	private JButton restart;

	
	public Gui(){
		setTitle("Flow Free");
		setSize(800,600);
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
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 6; j++){
				gameBoard[i][j] = new JButton("Square");
				gameBoard[i][j].setPreferredSize(new Dimension(80, 80));
				gameBoard[i][j].setBorder(new LineBorder(Color.BLACK, 1));
				boardGrid.add(gameBoard[i][j]);
			}
		}
		
	}


	private void setLabelButtons() {
		title = new JLabel("Flow Free");
		title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 48));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(title, BorderLayout.CENTER);
		
		level = new JLabel ("Level 1");
		southTopPanel.add(level, BorderLayout.WEST);
		moves = new JLabel ("Moves: 0");
		southTopPanel.add(moves, BorderLayout.EAST);
		topPanel.add(southTopPanel, BorderLayout.SOUTH);	
	}


	private void setPanels() {
		completePanel = new JPanel(new BorderLayout());
		topPanel = new JPanel (new BorderLayout());
		boardGrid = new JPanel(new GridLayout(6,6));
		southTopPanel = new JPanel(new BorderLayout());	
	}
	
	

}
