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
        board[r][c] = -1;
        return true;
    }

    private boolean removeQueen(int r, int c){
        if (board[r][c] != -1){
            return false;
        }
        addDirection(-1,r,c,1,0);
        addDirection(-1,r,c,1,1);
        board[r][c] = 0;
        return true;
    }

    private void addDirection(int toBeAdded,int r, int c, int xdir, int ydir){
        while (r < board.length && c < board[0].length){
            board[r][c] += toBeAdded;
            r += ydir;
            c += xdir;
        }
    }

    public String toString(){
        String ans = "";
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c <board[0].length; c++){
                /*if (board[r][c] < 0){
                    ans += "Q ";
                }
                else{
                    ans += "_ ";
                }*/
             ans += board[r][c] + " ";}
            ans += "\n";
        }
        return ans;
    }
        

    public boolean solve(){
    //    if (board.length == 2 || board.length == 3 ){
  //          return false;
//        }
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

    public static void main(String[]args){
        QueenBoard test = new QueenBoard(8);
        System.out.println(test);
        test.addQueen(4,4);
        System.out.println(test);
        test.removeQueen(4,4);
        System.out.println(test);
        System.out.println(test.solve());
        System.out.println(test);
        
        QueenBoard test2 = new QueenBoard(2);
        System.out.println(test2.solve());
        System.out.println(test2);
    }
}
