public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
    maze = new Maze(mazeText);
  }

  //Default to BFS
    public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
    public boolean solve(int mode){ 
        if(mode == 0){
        frontier = new FrontierQueue();
        }
        if(mode == 1){
            frontier = new FrontierStack();
        }
        boolean done = false;
        frontier.add(maze.getStart());
        while (!done && frontier.hasNext()){
            Location next = frontier.next();
            if (next.equals(maze.getEnd())){
                done = true;
            }
            else{
                Location[] loc = maze.getNeighbors(next);
                for(int i = 0; i < 4; i++){
                    if (loc[i] != null){
                        frontier.add(loc[i]);
                    }    
                }
            
            }
        }
        return done;
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
  }

  public String toString(){
    return maze.toString();
  }
  
  public static void main(String[] args){
	    MazeSolver m = new MazeSolver("data1.dat");
	    System.out.println(m.solve(0));
	    System.out.println(m);

	
    }
}
