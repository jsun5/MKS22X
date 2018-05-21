import java.util.*;

public class FrontierQueue implements Frontier{
    private LinkedList<Location> locations = new LinkedList<>();
    
    public Location next(){
        return locations.removeFirst();
    }
    
    public void add(Location n){
        locations.addLast(n);
    }
    
    public boolean hasNext(){
        return locations.size() != 0;
    }
}
