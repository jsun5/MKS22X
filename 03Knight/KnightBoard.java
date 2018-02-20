public class KnightBoard{
    private int[][] board;
    private int[][] moveSet = {{-2,-2,-1,-1,1,1,2,2},
                               {1,-1,2,-2,2,-2,1,-1}};

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
                if (board[r][c] < 10){
                    ans += " " + board[r][c] + " ";
                }
                else{
                    ans += board[r][c] + " ";
                }
            }
            ans += "\n";
        }
        return ans;
    }
    
        public void print(){
        String ans = "";
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c < board[0].length; c ++){
                ans += board[r][c] + " ";
            }
            ans += "\n";
        }
        System.out.println( ans);
    }

    public boolean solve(int startR, int startC){
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c < board[0].length; c ++){
                if (board[r][c] != 0){
                    throw new IllegalStateException("start w zeros!");
                }
            }
        }
        
        if (startR < 0 || startC < 0){
            throw new IllegalArgumentException("no negative lengths either");
        }
        return solver(startR, startC, 1);
    }

    private boolean solver(int row, int col, int level){
        if (level > board.length * board[0].length){
            return true;
        }
        for (int i = 0; i < 8; i++){
            try{
                if (board[row + moveSet[0][i]] [col + moveSet[1][i]] == 0){
                    board[row + moveSet[0][i]] [col + moveSet[1][i]] = level;
                    print();
                    if( solver(row + moveSet[0][i], col + moveSet[1][i], level + 1)){
                        return true;
                    }
                    board[row + moveSet[0][i]] [col + moveSet[1][i]] = 0;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){}
        }	
        return false;
    }

    public static void main( String[]args){
	KnightBoard test = new KnightBoard(5,4);
      	System.out.println(test);
	System.out.println(test.solve(3,2));
	System.out.println(test);
    }
}

		
