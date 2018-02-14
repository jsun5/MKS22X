public class KnightBoard{
    private int[][] board;
    private int[][] moveSet = {{-2,1}
			       {-2,-1}
			       {-1,2}
			       {-1,-2}
	                       {1,2}
			       {1,-2}
			       {2,1}
			       {2,-1}};

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

    private boolean  validate(int row, int col){
	for (int i = 0; i < moveSet.length; i++){
	    if (board[row + moveSet[i][0]] [col + moveSet[i][1]] == 0){
		
