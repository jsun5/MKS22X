public class KnightBoard{
    private int[][] board;
    private int[][] moveSet = {{-2,-1,1,2,2,1,-1,-2},
                               {1,2,2,1,-1,-2,-2,-1}};

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

    
/*    public static void main( String[]args){
	KnightBoard test = new KnightBoard(5,5);
      	System.out.println(test);
	System.out.println(test.solve(0,0));
	System.out.println(test);
    }
}*/
/*public static void main(String[] args){
    KnightBoard a = new KnightBoard(3,3);


    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    } //prints nothing

    System.out.println(a.countSolutions(0,0)); //prints 0



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"



    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304

  } */

  }

