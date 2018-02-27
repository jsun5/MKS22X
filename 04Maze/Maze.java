import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    public Maze(){}
    
    public void ReadFile (String fileName){
        try{

        //instead of a try/catch, you can throw the FileNotFoundException.
        File text = new File(fileName);// can be a path like: "/full/path/to/file.txt" 
        
        //inf stands for the input file
        Scanner inf = new Scanner(text);

        String ans;
        int cols;
        int rows;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            cols = line.length();
            System.out.println(line);//hopefully you can do other things with the line
        }       
        }
        catch (FileNotFoundException e){}
    }   
    
    public static void main(String[]args){
        Maze test = new Maze();
        test.ReadFile("Maze1.txt");
    }
}