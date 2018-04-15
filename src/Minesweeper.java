import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 Minesweeper Class is used to set up the game frame. 
 In this class, I also created a panel which will take care of all the buttons.
 */
public class Minesweeper extends JFrame implements ActionListener{
	static int FRAME_SIZE = 700;
	static int buttonNumRow = 5;
	static int buttonNumCol = 5;
	static int MINES_NUM = 5;

	// Create a JPanel which is used to layout all buttons.
	JPanel panel = new JPanel(); 

	// Create a 2D array. It contains all tiles(buttons).
	ButtonState buttonState[][] = new ButtonState[buttonNumRow][buttonNumCol]; 
	int[][] mat = new int[buttonNumRow][buttonNumCol];

	// Constructor
	public Minesweeper(){
		// Set up the frame's name and size.
		// Function setResizable() is used to check if users can resize the frame.
		// When close window, the game ends.
		super("Minesweeper");
		setSize(FRAME_SIZE, FRAME_SIZE);
		setResizable(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		// Set and create grid
		panel.setLayout(new GridLayout(buttonNumRow, buttonNumCol));
		for(int i = 0; i < buttonState.length; i++) {
			for(int j = 0; j < buttonState[0].length; j++){
				buttonState[i][j] = new ButtonState();
				buttonState[i][j].addActionListener(this);
				panel.add(buttonState[i][j]);
			}
		}
		add(panel);
		
		// Call method in Matrix class to distribute mines and compute the number of mines surrounding a specific button.
		mat = new Matrix().distributeMines();

		// Set the frame visible
		setVisible(true);
		
		// Print the result(matrix) in Console.
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}

	// Implement the actionPerformed() method in ActionListener so that when a user clicks a button, 
	// the button will update its state to Safe, Danger, or Caution(Number).
	// In switch method:
	//     case 0 represents SAFE condition,
	//     case 1-8 represents the number of mines surrounding a certain button,
	//     case 9 represents DANGER(MINE).
	@Override
	public void actionPerformed(ActionEvent event) {
		ButtonState buttons = new ButtonState();
		for(int i = 0; i < buttonState.length; i++) {
			for(int j = 0; j < buttonState[0].length; j++) {
				if (!event.getSource().equals(buttonState[i][j])) {
					continue;
				}
				switch (mat[i][j]) {
				case 0:
					buttonState[i][j].setIcon(buttons.S);
					break;
				case 1:
					buttonState[i][j].setIcon(buttons.ONE);
					break;
				case 2:
					buttonState[i][j].setIcon(buttons.TWO);
					break;
				case 3:
					buttonState[i][j].setIcon(buttons.THREE);
					break;
				case 4:
					buttonState[i][j].setIcon(buttons.FOUR);
					break;
				case 5:
					buttonState[i][j].setIcon(buttons.FIVE);
					break;
				case 6:
					buttonState[i][j].setIcon(buttons.SIX);
					break;
				case 7:
					buttonState[i][j].setIcon(buttons.SEVEN);
					break;
				case 8:
					buttonState[i][j].setIcon(buttons.EIGHT);
					break;
				case 9:
					buttonState[i][j].setIcon(buttons.D);
				}
			}
		}
	}
}
