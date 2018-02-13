public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public String toString(){}

    public boolean solve(int startR, int startC){
	solver(startR, startC, 1);
    }

    private boolean solver(int row, int col, int level){
	board[row][col]= level;
	int[] validMoves = new int[16];
    }

    private int[]  validate(int row, int col){
	int[] validMoves = new int[16];
	if (row - 3, col + 1){}
	if (row - 1, col + 3){}
	if (row + 1, col + 3){}
	if (row + 3, col + 1){}
      	if (row + 3, col - 1){}
	if (row + 1, col - 3){}
	if (row - 1, col - 3){}
	if (row - 3, col - 1){}
    }

    public int countSolutions(){}
}
