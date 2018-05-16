public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> locations = new MyHeap<>();
    
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
