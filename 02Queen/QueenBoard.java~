public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){
	addDirection(1,r,c,1,0);
	addDirection(1,r,c,1,-1);
	board[r][c] = -1;
    }
	
    private boolean removeQueen(int r, int c){
	addDirection(-1,r,c,1,0);
	addDirection(-1,r,c,1,-1);
    }

    private void addDirection(int toBeAdded,int r, int c, int xdir, int ydir){
	for (int row = r; row < r.length; r + ydir){
	    for (int col = c; col < c.length; col + xdir){
		board[row][col] += toBeAdded;
	    }
	}
    }

    public String toString();

		 //    public boolean solve(){
		 //	if (board.length == 2 && board.length == 3){
		 //	    return false;
	}
	//	for (int r = 0; r < board.length; r ++){
	    //   for (int 


    public int countSolutions();
