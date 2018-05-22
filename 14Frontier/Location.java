public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int  distance, distanceSoFar, priority;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
	distance = 0;
    distanceSoFar = 0;
    priority = 0;
    }

    public Location(int _x, int _y, Location prev, int d, int dSoFar){
	x = _x;
	y = _y;
	previous = prev;
    distance = dSoFar;
    priority = d;
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

    public int getDistance(){
	return distance;
    }

    public int getPriority(){
	return priority;
    }

    public int compareTo(Location other){
	return getPriority() - other.getPriority();
    }
}
