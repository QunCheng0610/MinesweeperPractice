# MinesweeperPractice
1. There are two modes for this game: classic and custom.
   In classic mode, you can pick three difficulty (Easy, Medium, and Hard). 
   Run this game in Terminal with the following commands:
   ```
   $> cd src
   $> javac Game.java
   $> java Game classic
   ```
   In custom mode which is also the default mode, you can define row number and column number for your grid. 
   Similarly, run this game with the following commands:
   ```
   $> cd src
   $> javac Game.java
   $> java Game
   ```

2. Number of mines:
   In classic mode, the number of mines at each difficult level is constant. I use 7 mines at Easy level,
   10 mines at Medium level, and 15 mines at Hard level.
   In customized mode, I simply determine its number by (row * column) / 4, i.e. if there's a 5 * 5 grid, 
   there will be 6 mines under tiles.

3. Tile number limitation:
   As the number of tiles increase, the game still works, but the process time also increases. 
   i.e. it may take a while to generate the panel if I customize a 100 * 100 grid.
   
4. Future Improvements: 
    1) Exit issue: currently, if you click a mine, the window will close, and provides ending information
               "BOMB! GAME OVER:)". An improvement could be when the user click the mine, the window is still there,
               but the game ends.
    2) Design issue: another future improvement is to use MVC design pattern so that code can be managed in a more clear way.
    3) Raw data: Currently, Terminal will show up the raw data containing the generated matrix after distributing mines. To make debugging easier,
		 create one more mode used 

5. Reference:
	1) Icon website: https://www.flaticon.com/search?word=number
	2) How to scale images: https://stackoverflow.com/questions/13810213/java-stretch-icon-to-fit-button
	3) Create frame and panel: based on previous class lab
	```
	JFrame frame = new JFrame();
	frame.getContentPane().add(new Animation());
	frame.setBackground(Color.gray);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(frameWidth, frameHeight);
	frame.setVisible(true);
	```
	4) Create grid on panel:https://www.youtube.com/watch?v=Db3cC5iPrOM
	5) Distribute random mines on Matrix: based on previous class lab
	```
	string** Matrix::battleShip(){
	//string **array = matrix();
		int i = 0;
		while(i < 5) {
			int currentRow = rand() % length;
			for(int r = 0; r < length; r++) {
				if(r == currentRow) {
					int currentCol = rand() % width;
					for (int c = 0; c < width; c++) {
						if(c == currentCol && mat[currentRow][currentCol] == "0"){
							mat[r][c] = "x";
							i ++;
						}
					}
				}
			}
		}
		return mat;
	}
			
