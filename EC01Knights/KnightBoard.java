public class KnightBoard{
    private int[][] board;
    private int[][] moveBoard;
    private int[][] moveSet = {{-2,-1,1,2,2,1,-1,-2},
                               {1,2,2,1,-1,-2,-2,-1}};

    public KnightBoard(int startingRows, int startingCols){
        if (startingRows < 0 || startingCols < 0){
            throw new IllegalArgumentException("both args > 0");
        }
        board = new int[startingRows][startingCols];
        moveBoard = new int[startingRows][startingCols];
        for (int r = 0; r < moveBoard.length; r ++){
            for (int c = 0; c < moveBoard[0].length; c ++){
                int count = 0;
                for (int i = 0; i < 8; i ++){
                    int nextRow = r + moveSet[0][i];
                    int nextCol = c + moveSet[1][i];
                    if (isValid(nextRow, nextCol)){
                        count ++;
                    }
                }
                moveBoard[r][c] = count;
            }
        }
        movePrint();
    }

    public String toString(){
        String ans = "";
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c < board[0].length; c ++){
                if (board[r][c] == 0){
                    ans += "_ ";
                }
                else if (board[r][c] < 10){
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
    
    public void movePrint(){
        String ans = "";
        for (int r = 0; r < moveBoard.length; r ++){
            for (int c = 0; c < moveBoard[0].length; c ++){
                ans += moveBoard[r][c] + " ";
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
        if (level == board.length * board[0].length){
            board[row][col] = level;
            return true;
        }
        for (int i = 0; i < 8; i++){
            int nextRow = row + moveSet[0][i];
            int nextCol = col + moveSet[1][i];
            if (isValid(nextRow, nextCol)){
                if (board[nextRow] [nextCol] == 0){
                    board[row] [col] = level;
                    //print();
                    if( solver(nextRow, nextCol, level + 1)){
                        return true;
                    }
                   board[row] [col] = 0;
                }
            }
        }
        return false;
    }
    
    private boolean isValid (int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
    
    public int countSolutions (int startR, int startC){
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
        return counter(startR, startC, 1);
    }
    
    private int counter (int row, int col, int level ){
        int total = 0;
        if (level == board.length * board[0].length){
            board[row][col] = 0;
            return 1;
        }
        for (int i = 0; i < 8; i++){
            int nextRow = row + moveSet[0][i];
            int nextCol = col + moveSet[1][i];
            if (isValid(nextRow, nextCol)){
                if (board[nextRow] [nextCol] == 0){
                    board[row] [col] = level;
                    //print();
                    total += counter(nextRow, nextCol, level + 1);
                }
                board[row] [col] = 0;
            }
        }
    
        return total;
    }

    


        
    public static void main(String[] args){
        KnightBoard test = new KnightBoard(6,6);
        System.out.println(test);
    }
}

    

