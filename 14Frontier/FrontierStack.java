public class FrontierStack implements Frontier{
    private MyDeque<Location> locations = new MyDeque<>();
    
    public Location next(){
        return locations.removeLast();
    }
    
    public void add(Location n){
        locations.addLast(n);
    }
    
    public boolean hasNext(){
        return locations.size() != 0;
    }
}
