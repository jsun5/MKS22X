import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue<Location> locations = new PriorityQueue<>();
    
    public Location next(){
        return locations.remove();
    }
    
    public void add(Location n){
        locations.add(n);
    }
    
    public boolean hasNext(){
        return locations.size() != 0;
    }
}
