import java.util.Scanner;

/*
 The Game class is used to run this Game.
 It provides users two modes for this game.
 Default mode customMode in which a user can specify the mine field dimensions, i.e. how many tiles per row 
 and how many tiles per column
 Classic mode specifies three levels for users. In this mode, they can choose different Game levels(Easy, Medium, Hard)
 */
public class Game {
	public static void main(String args[]) {
		if (args.length > 0 && args[0].equals("classic")) {
			startGameClassic();
		} else {
			startGame();
		}
	}
	
	// Set game as customMode. Users can customize their own grid(rows x columns).
	public static void startGame() {
		
		// Input row and columns for grid.
		System.out.println("How many rows do you want?");
		Scanner input = new Scanner(System.in);  // Reading from System.in
		int row = (int)input.nextInt();  
		
		System.out.println("How many columns do you want?");
		int col = input.nextInt();
		input.close();
		
		// Deal with invalid input. If any input number is less than or equal to 0, print error information
		if (row <= 0) {
			System.out.println("Invalid input!");
			return;
		}
		if (col <= 0) {
			System.out.println("Invalid input!");
			return;
		} 

		Minesweeper.buttonNumRow = row;
		Minesweeper.buttonNumCol = col;
		Minesweeper.MINES_NUM = (row * col) / 4;
		new Minesweeper();
	}

	// Set game as classicMode. Users can choose three difficulties: Easy, Medium, and Hard.
	public static void startGameClassic() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a level:");
		System.out.println("0 -- Easy\n1 -- Medium\n2 -- Hard");
		int level = (int)input.nextInt();
		
		// Different game level based on user's input.
		// 0 represents easy,
		// 1 represents medium,
		// 2 represents hard.
		// otherwise print error information
		switch(level) {
		case 0:
			Minesweeper.buttonNumRow = 5;
			Minesweeper.buttonNumCol = 5;
			Minesweeper.MINES_NUM = 7;
			new Minesweeper();
			break;
		case 1:
			Minesweeper.buttonNumRow = 10;
			Minesweeper.buttonNumCol = 10;
			Minesweeper.MINES_NUM = 30;
			new Minesweeper();
			break;
		case 2:
			Minesweeper.buttonNumRow = 15;
			Minesweeper.buttonNumCol = 15;
			Minesweeper.MINES_NUM = 35;
			new Minesweeper();
			break;
		default:
			System.out.println("Invalid input!");
		}
	}
}
