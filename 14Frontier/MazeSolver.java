//Huge thanks to Damian for filling me in on notes for the days I was gone and helping me understand the lab!!

public class MazeSolver{
  private Maze maze;
  private Frontier frontier;
  private boolean animate;
  private boolean isAStar = false;

  public MazeSolver(String mazeText){
    maze = new Maze(mazeText);
  }

  //Default to BFS
    public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  //2: Greedy
  //3: A*
    public boolean solve(int mode){ 
        if(mode == 0){
        frontier = new FrontierQueue();
        }
        if(mode == 1){
            frontier = new FrontierStack();
        }
        if(mode == 2){
            frontier = new FrontierPriorityQueue();
        }
        if(mode == 3){
            frontier = new FrontierPriorityQueue();
            setAStar(true);
        }
        frontier.add(maze.getStart());
        while (frontier.hasNext()){
            Location next = frontier.next();
        //    System.out.println(maze.toStringColor(15));
            Location[] valid = maze.getNeighbors(next,isAStar);
            if (!next.equals(maze.getStart())){
                maze.set(next.getX(), next.getY(), '.');
            }
            for(Location L : valid) {
                
                if(L != null){
                    if(L.equals(maze.getEnd())){
                        while(!next.equals(maze.getStart())){
                            maze.set(next.getX(), next.getY(), '@');
                            next = next.getPrev();
                        }
                    //    System.out.println(maze.toStringColor(15));
                        return true;
                    }
                    frontier.add(L);
                    maze.set(L.getX(),L.getY(),'?');
                }                
            }
        }
       // System.out.println(maze);
        return false;
    }
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
  
  public void setAStar(boolean A){
      isAStar = A;
  }

  public String toString(){
    return maze.toString();
  }
  
  public static void main(String[] args){
	    MazeSolver m = new MazeSolver("data2.dat");
        //m.maze;
	    System.out.println(m.solve(0));
		System.out.println(m.solve(2));
		System.out.println(m.solve(3));
	    //System.out.println(m);

	
    }
}
