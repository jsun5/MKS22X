public class Location implements Comparable<Location>{
  private int x, y;
  private Location previous;
  private int priority, dist;
  
      public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
	dist = 0;
    priority = 0;
    }
  
  public Location(int _x, int _y, Location prev, int distance, int prevDist){
    x = _x;
    y = _y;
    previous = prev;
    priority = distance;
    dist = prevDist;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public Location getPrev(){
    return previous;
  }
  public String toString(){
    return x + " " +y;
  }
  public boolean equals(Location o){
    return x == o.getX() && y == o.getY();
  }
  public int compareTo(Location o){
    return getPriority() - o.getPriority();
  }
  public int getPriority(){
    return priority;
  }
  public int getDist(){
    return dist;
  }
}
