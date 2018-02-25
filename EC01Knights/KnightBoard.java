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
     //   movePrint();
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

    public boolean solveFast(int startR, int startC){
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
        return faster(startR, startC, 1);
    }
    
    private boolean faster(int row, int col, int level){
        if (board[row][col] != 0){
            return false;
        }
        if (level == board.length * board[0].length){
            board[row][col] = level;
            return true;
        }

        int min = 8;
        for (int i = 0; i < 8; i++){
            int nextRow = row + moveSet[0][i];
            int nextCol = col + moveSet[1][i];
            //                    print();
           //         movePrint();
            if (isValid(nextRow, nextCol) ){
                moveBoard[nextRow][nextCol] --;
                if (moveBoard[nextRow][nextCol] < min && board[nextRow] [nextCol] == 0){
                    min = moveBoard[nextRow][nextCol];
                }
                
            }
        }
        for (int i = 0; i < 8; i++){
            int nextRow = row + moveSet[0][i];
            int nextCol = col + moveSet[1][i];
            if (isValid(nextRow, nextCol)){
                if (moveBoard[nextRow] [nextCol] == min){
                    board[row] [col] = level;
              //      print();
             //       movePrint();
                    if( faster(nextRow, nextCol, level + 1)){
                        return true;
                    }
                   board[row] [col] = 0;
                   moveBoard[nextRow][nextCol] = min;
                }
            }
        }
        return false;
    }
}
            
/*    public static void main(String[] args){
        KnightBoard test = new KnightBoard(5,5);
        System.out.println(test);
        System.out.println(test.solve(4,0));
                System.out.println(test);
        test = new KnightBoard(5,5);
                System.out.println(test);
        System.out.println(test.solveFast(4,0));
               System.out.println(test);
               
        KnightBoard test2 = new KnightBoard(51,51);
    //    System.out.println(test2);
      //  System.out.println(test2.solve(0,0));
       //         System.out.println(test2);
       // test2 = new KnightBoard(8,8);
                        System.out.println(test2);
        System.out.println(test2.solveFast(0,0));
               System.out.println(test2);
    }
}*/