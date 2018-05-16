public class FrontierStack implements Frontier{
    private MyDeque<Location> locations = new MyDeque<>();
    
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
