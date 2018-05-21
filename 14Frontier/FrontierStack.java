import java.util.*;

public class FrontierStack implements Frontier{
    private LinkedList<Location> locations = new LinkedList<>();
    
    public Location next(){
        return locations.removeFirst();
    }
    
    public void add(Location n){
        locations.addFirst(n);
    }
    
    public boolean hasNext(){
        return locations.size() != 0;
    }
}
