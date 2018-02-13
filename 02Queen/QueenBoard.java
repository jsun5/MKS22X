public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
        board = new int[size][size];
    }

    private boolean addQueen(int r, int c){
        if (board[r][c] != 0){
            return false;
        }
        addDirection(1,r,c,1,0);
        addDirection(1,r,c,1,1);
        addDirection(1,r,c,1,-1);
//        addDirection(1,r,c,-1,0);
  //      addDirection(1,r,c,-1,1);
    //    addDirection(1,r,c,-1,-1);
        addDirection(1,r,c,0,1);
       // addDirection(1,r,c,0,-1);
        
        board[r][c] = -1;
        return true;
    }

    private boolean removeQueen(int r, int c){
        if (board[r][c] != -1){
            return false;
        }
        addDirection(-1,r,c,1,0);
        addDirection(-1,r,c,1,1);
        addDirection(-1,r,c,1,-1);
        addDirection(-1,r,c,0,1);
        board[r][c] = 0;
        return true;
    }

    private void addDirection(int toBeAdded,int r, int c, int xdir, int ydir){
        while (r >= 0 && c >= 0 && r < board.length && c < board[0].length){
            board[r][c] += toBeAdded;
            r += ydir;
            c += xdir;
        }
    } 
    
    public String toString(){
        String ans = "";
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c <board[0].length; c++){
                if (board[r][c] < 0){
                    ans += "Q ";
                }
                else{
                    ans += "_ ";
                }
            }
            ans += "\n"; 
        }
        return ans;
    }
        

    public boolean solve(){
    //    if (board.length == 2 || board.length == 3 ){
  //          return false;
//        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if (board[r][c] != 0){
                    throw new IllegalStateException("don't start with any nonzeros");
                }
            }
        }
        if (board.length == 0){
            return true;
        }
        return solver(0);
    }
    
    public boolean solver(int c){

        if (c == board[0].length){
            return true;
        }
        for (int r = 0; r < board.length; r++){
            if (addQueen(r,c)){
                if( solver(c + 1)){
                    return true;
                }
                else{
                    removeQueen(r,c);
                }
            }
        }
        return false;
    }
    
    public int countSolutions(){
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board.length; c++){
                if (board[r][c] != 0){
                    throw new IllegalStateException("don't start with any nonzeros");
                }
            }
       }
        if (board.length == 0){
            return 1;
        }
       return counter(0);
    }
   
    public int counter(int c){
        int total = 0;
        if (c == board[0].length){
                return 1;
        }
        for (int r = 0; r < board.length; r++){
            if (addQueen(r,c)){
                total += counter(c + 1);
                removeQueen(r,c);
            }
        }
        return total;
}


/*    public static void main(String[]args){
        QueenBoard test = new QueenBoard(8);
        System.out.println(test);
        test.addQueen(4,4);
	   System.out.println(test);
	   test.addQueen(7,5);
	   System.out.println(test);
	   test.addQueen(6,1);
	   System.out.println(test);
	// test.removeQueen(4,4);  
	       System.out.println(test);
	//System.out.println(test.solve());
      //  System.out.println(test);
        
        QueenBoard test2 = new QueenBoard(2);
        System.out.println(test2.solve());
        System.out.println(test2); 
        
	    QueenBoard b = new QueenBoard(4);

	   System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
               Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      
       System.out.println(a); //prints out an empty i by i grid of underscores       
    }
    }*/
}
