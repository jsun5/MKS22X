import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;
    private int[][] moveSet = {{0,1,0,-1},
                               {1,0,-1,0}};
    public Maze(String filename) throws FileNotFoundException{
	setAnimate(false);
	ReadFile(filename);
    }
    
    public void ReadFile (String fileName) throws FileNotFoundException{

        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File(fileName);// can be a path like: "/full/path/to/file.txt" 
        
        //inf stands for the input file
        Scanner inf = new Scanner(text);

        String ans = "";
        int cols = 0;
        int rows = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            cols = line.length();
	    rows++;
	    ans += line;
            System.out.println(line);//hopefully you can do other things with the line
        }
	maze = new char[rows][cols];
	int i = 0;
    int numS = 0;
    int numE = 0;
	for (int r = 0; r < rows; r ++){
	    for (int c = 0; c < cols; c++){
		    maze[r][c] = ans.charAt(i);
            if (ans.charAt(i) == 'S'){
                numS++;
            }
            if (ans.charAt(i) == 'E'){
                numE++;
            }
		i++;
	    }
	}
    if (numS != 1 || numE != 1){
    throw new IllegalStateException("num of S and E incorrect!");
    }
    }
       
    public String toString(){
	String ans = "";
	for (int r = 0; r < maze.length; r ++){
	    for (int c = 0; c < maze[0].length; c++){
		ans += maze[r][c];
	    }
	    ans += "\n";
	}
	return ans;
    }
     private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*        Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.*/
    
      public int solve(){
	for (int r = 0; r < maze.length; r ++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze[r][c] == 'S'){
		    maze[r][c] = ' ';
		    return solve(r,c);
		}
		    
	    }
	}
	return -1;
     
	
            //find the location of the S. 

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
      }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
        maze[row][col] = '@';
        

	for (int i = 0; i < 4; i++){
	    int nextRow = row + moveSet[0][i];
	    int nextCol = col + moveSet[1][i];
            if (maze[nextRow][nextCol] == 'E'){
                    return 1;
            }
            if (maze[nextRow][nextCol] == ' '){
                maze[nextRow][nextCol] = '@';
                int length = solve(nextRow,nextCol);
                if(length != -1){
                        return length + 1;
                }
                                maze[nextRow][nextCol] = '.';
            }
            
    }
        return -1; //so it compiles
    } 

    
  public static void main(String[]args){
      try{
	     Maze test = new Maze("Maze1.txt");
	     test.ReadFile("Maze1.txt");
	     System.out.println(test);
         test.setAnimate(true);
         System.out.println(test.solve());
      }catch(FileNotFoundException e){
	  System.out.println("File not found!");
	      }
    }

}
