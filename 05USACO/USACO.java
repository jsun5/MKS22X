import java.util.*;
import java.io.*;

public class USACO{

/*    private int[][] elevations =
    {{28, 25, 20, 32, 34, 36},
     {27, 25, 20, 20, 30, 34},
     {24, 20, 20, 20, 20, 30},
     {20, 20, 14, 14, 20, 20}}; */
    
          private  char[][] map = {{'.','.','.','.','.'},
                                   {'.','.','.','.','.'},
                                   {'.','.','.','.','.'},
                                   {'.','.','.','.','.'},
				   {'.','.','.','.','.'}};
     private int[][] past;
    private int[][] current;
	
     public static int bronze(String fileName) throws FileNotFoundException{
        int R, C, E, R_s, C_s, D_s;
        int[][]elevations;
        

        File text = new File(fileName);
        Scanner inf = new Scanner(text);


        //Instantialize 1st line
        String[] line1 = inf.nextLine().split(" ");
        R = Integer.parseInt(line1[0]);
        C = Integer.parseInt(line1[1]);
        E = Integer.parseInt(line1[2]);
        elevations = new int[R][C];
        
        //Fill in int[][]elevations 2nd... line
        for (int r = 0; r < R; r++){
            String[] row = inf.nextLine().split(" ");
            for (int c = 0; c < C; c++){
                elevations[r][c] = Integer.parseInt(row[c]);
            }
        }
        
        //Commands, changing elevations
        while(inf.hasNextLine()){
            String[] command = inf.nextLine().split(" ");
            R_s = Integer.parseInt(command[0]) - 1;
            C_s = Integer.parseInt(command[1]) - 1;
            D_s = Integer.parseInt(command[2]);
            int largest = 0;
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    if (elevations[R_s + r][C_s + c] > largest){
                        largest = elevations[R_s + r][C_s + c];
                    }
                }
            }
            for (int r = 0; r < 3; r++){
                for (int c = 0; c < 3; c++){
                    if (elevations[R_s + r][C_s + c] > largest - D_s){
                        elevations[R_s + r][C_s + c] = largest - D_s;
                    }
                }
            }
        }
        
        //calculate sum
        int sum = 0;
        for (int r = 0; r < elevations.length; r++){
            for (int c = 0; c < elevations[0].length; c++){
                if (elevations[r][c] < E){
                    sum += E - elevations[r][c];
                }
            }
        }
        return sum * 72 * 72;
     }


/*
    private void stomp(int R_s, int C_s, int D_s){
	R_s--;
	C_s--;
	int largest = 0;
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if (elevations[R_s + r][C_s + c] > largest){
		    largest = elevations[R_s + r][C_s + c];
		}
	    }
	}
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if (elevations[R_s + r][C_s + c] > largest - D_s){
		    elevations[R_s + r][C_s + c] = largest - D_s;
		}
	    }
	}
    }

    public void print(){
	String ans = "";
	for (int r = 0; r < elevations.length; r++){
	    for (int c = 0; c < elevations[0].length; c++){
		ans += elevations[r][c] + " ";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    public int calc(int seaLevel){
	int sum = 0;
	for (int r = 0; r < elevations.length; r++){
	    for (int c = 0; c < elevations[0].length; c++){
	        if (elevations[r][c] < seaLevel){
		    sum += seaLevel - elevations[r][c];
		}
	    }
	}
	return sum * 72 * 72;
    }
*/
    
    
    ////////////////////////////////////////////////////////////////////////////////////////

    public int silver(String fileName) throws FileNotFoundException{
        int rows, cols, time, R1, C1, R2, C2;
        char[][] map;
        int[][] past, current;
        
        File text = new File(fileName);
        Scanner inf = new Scanner(text);

        String[] line1 = inf.nextLine().split(" ");
        rows = Integer.parseInt(line1[0]);
        cols = Integer.parseInt(line1[1]);
        time = Integer.parseInt(line1[2]);
        map = new char[rows][cols];
        past = new int[rows][cols];
        current = new int[rows][cols];
        
        //instantialize map + past at the SAME TIME
        for (int r = 0; r < rows; r ++){
            String row = inf.nextLine();
            for (int c = 0; c < cols ; c++){
      //          System.out.println(row.charAt(c));
                map[r][c] = row.charAt(c);
                if (map[r][c] == '*'){
                    past[r][c] = -1;
                }
            }
        }
        
        String[]lastLine = inf.nextLine().split(" ");
        R1 = Integer.parseInt(lastLine[0])-1;
        C1 = Integer.parseInt(lastLine[1])-1;
        R2 = Integer.parseInt(lastLine[2])-1;
        C2 = Integer.parseInt(lastLine[3])-1;
        past[R1][C1] = 1;
        
        int count = 0;
        while (count < time){
            for (int r = 0; r < rows; r++){
                for (int c = 0; c < cols; c++){    
                    if (past[r][c] == -1){
                        current[r][c] = -1;
                    }
                    else{
                        int sum = 0;
                        if (r > 0 && past[r-1][c] != -1){
                            sum += past[r-1][c];
                        }
                        if (r < rows -1&& past[r+1][c] != -1){
                            sum += past[r+1][c];
                        }
                        if (c > 0 && past[r][c-1] != -1){
                            sum += past[r][c-1];
                        }
                        if (c < cols -1&& past[r][c+1] != -1){
                            sum += past[r][c+1];
                        }
                 //       System.out.println(sum);
                        current[r][c] = sum;
                    }
                }
            }
            count ++;
         //   System.out.println("time" + count);
            past = current;
            current = new int[rows][cols];
          //  printS();
        }
        
        return past[R2][C2];
                
     }
    
    public int silver(int rows,int cols, int time, int R1, int C1, int R2, int C2){
        past = new int[rows][cols];
        current = new int[rows][cols];
        
        R1--;
        C1--;
        
    
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (map[r][c] == '*'){
                    past[r][c] = -1;
                }
            }
        }
        past[R1][C1] = 1;
        printS();
        int count = 0;
        while (count < time){
                update();
                count ++;
                System.out.println("time" + count);
		past = current;
		current = new int[rows][cols];
                printS();
        }
        
        return past[R2-1][C2-1];
                
     }

    public void update(){
        int rows = past.length;
        int  cols = past[0].length;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){    
;
                if (past[r][c] == -1){
                    current[r][c] = -1;
                }
                else{
                    int sum = 0;
                    if (r > 0 && past[r-1][c] != -1){
                        sum += past[r-1][c];
                    }
                    if (r < rows -1&& past[r+1][c] != -1){
                        sum += past[r+1][c];
                    }
                    if (c > 0 && past[r][c-1] != -1){
                        sum += past[r][c-1];
                    }
                    if (c < cols -1&& past[r][c+1] != -1){
                        sum += past[r][c+1];
                    }
		    System.out.println(sum);
                    current[r][c] = sum;
                }
            }
        }
    }
                
    public void printS(){
	String ans = "MAP:\n";
	for (int r = 0; r < map.length; r++){
	    for (int c = 0; c < map[0].length; c++){
		ans += map[r][c] + " ";
	    }
	    ans += "\n";
	}
    ans += "PAST:\n";
    for (int r = 0; r < map.length; r++){
	    for (int c = 0; c < map[0].length; c++){
            ans += past[r][c] + " ";
	    }
	    ans += "\n";
	}
    ans += "CURRENT:\n";
    for (int r = 0; r < map.length; r++){
	    for (int c = 0; c < map[0].length; c++){
		ans += current[r][c] + " ";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    public static void main(String[]args){
        USACO test = new USACO();
//        test.print();
//        test.stomp(1,4,4);
//        test.print();
//        test.stomp(1,1,10);
//        test.print();
//        System.out.println(test.calc(22)); 
    
	       try{
	// System.out.println(bronze("makelake.in"));
	// }
        System.out.println(test.silver("ctravel2.in"));
    }
            catch(FileNotFoundException e){
	 }
    }
}
	

    
		    
	
    
