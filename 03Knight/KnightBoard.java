public class KnightBoard{
    private int[][] board;
    private int[][] moveSet = {{-2,1},
			       {-2,-1},
			       {-1,2},
			       {-1,-2},
	                       {1,2},
			       {1,-2},
			       {2,1},
			       {2,-1}};

    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException("both args > 0");
	}
	board = new int[startingRows][startingCols];
    }

    public String toString(){
	String ans = "";
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board[0].length; c ++){
		ans += board[r][c] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public boolean solve(int startR, int startC){
	return solver(startR, startC, 1);
    }

    private boolean solver(int row, int col, int level){
	board[row][col]= level;
		if (level == board.length * board[0].length){
	  return true;
	}
	for (int i = 0; i < moveSet.length; i++){
	    try{
		if (board[row + moveSet[i][0]] [col + moveSet[i][1]] == 0){
		    if( solver(row + moveSet[i][0], col + moveSet[i][1], level + 1)){
			return true;
		    }
		       else{
			   board[row][ col] = 0;
		     }
		}
			
	    }
	    catch(ArrayIndexOutOfBoundsException e){}
	}	
	return false;
    }

    public static void main( String[]args){
	KnightBoard test = new KnightBoard(3,5);
      	System.out.println(test);
	System.out.println(test.solve(0,0));
	System.out.println(test);
    }
}

		
