import java.util.*;

/*
 The Matrix class is used to distribute mines in grid,
 meanwhile, the matrix also results the number of adjacent mines for each non-mine tile(button).
 if a tile is SAFE, keep it as default value 0.
 if a tile contains a mine, value it 9.
 */
public class Matrix {
    // Get the number of mines.
    final static int minesNum = Minesweeper.MINES_NUM;
    
    // 9 represents mine(danger).
    final static int MINE = 9;
    
    // Get the row and column value for matrix.
    static int row = Minesweeper.buttonNumRow;
    static int col = Minesweeper.buttonNumCol;
    
    // Initialize a matrix.
    public static int matrix[][] = new int[row][col];
    
    // Get random mines in matrix.
    public static int[][] distributeMines(){
        int currMine = 0;
        while(currMine < minesNum) {
            int currentRow = (int) (Math.random() * row) + 1;
            for(int r = 0; r < matrix.length; r++) {
                if(r != currentRow) {
                    continue;
                }
                int currentCol = (int) (Math.random() * col) + 1;
                for (int c = 0; c < matrix[0].length; c++) {
                    if(c != currentCol) {
                        continue;
                    }
                    if(matrix[currentRow][currentCol] != 0){
                        continue;
                    }
                    matrix[r][c] = MINE;
                    currMine++;
                }
            }
        }
        
        // Update matrix: check if there's at least 1 mine nearby
        // If the tile(button) is in Caution state, compute its total number of adjacent mines.
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                int count = 0;
                if(matrix[r][c] == MINE){
                    continue;
                }
                // Check its up-left tile.
                if(r > 0 && c > 0 && matrix[r-1][c-1] == MINE) {
                    count++;
                }
                // Check its up tile.
                if(r > 0 && matrix[r-1][c] == MINE) {
                    count++;
                }
                // Check its up-right tile.
                if(r > 0 && c < matrix[0].length - 1 && matrix[r-1][c+1] == MINE) {
                    count++;
                }
                // Check its right tile.
                if(c < matrix[0].length - 1 && matrix[r][c+1] == MINE) {
                    count++;
                }
                // Check its down-right tile.
                if(r < matrix.length - 1 && c < matrix[0].length - 1 && matrix[r+1][c+1] == MINE) {
                    count++;
                }
                // Check its down tile.
                if(r < matrix.length - 1 && matrix[r+1][c] == MINE) {
                    count++;
                }
                // Check its down-left tile.
                if(r < matrix.length - 1 && c > 0 && matrix[r+1][c-1] == MINE) {
                    count++;
                }
                // Check its left tile
                if(c > 0 && matrix[r][c-1] == MINE) {
                    count++;
                }
                matrix[r][c] = count;
            }
        }
        return matrix;
    }
}
