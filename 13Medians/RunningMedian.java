import java.util.*;

public class RunningMedian{
    private MyHeap<Double> less, more;
    private int size;
    
    public RunningMedian(){
        less = new MyHeap<Double>();
        more = new MyHeap<Double>(false);
        size = 0;
    }
    
    public void add(Double data){
        if(more.size() > less.size() + 1){
            less.add(more.remove());
        }
        else if(size() == 0 || data < less.peek()){
            less.add(data);
        }
        else if(data > less.peek()){
            more.add(data);
        }
        size++;
    }
    
    public Double getMedian(){
        if(less.size() > more.size()){
            return less.peek();
        }
        else if (less.size() < more.size()){
            return more.peek();
        }
        else{
            return (more.peek() + less.peek())/2;
        }
    }
    
    public int size(){
        return size;
    }
    
    public String toString(){
        return "Less: " + less + "\nMore: " + more;
    }
    
    public static void main(String[]args){
        RunningMedian test = new RunningMedian();
        test.add(0.);
        test.add(13.);
        test.add(9.);
        test.add(123.);
        test.add(5.);
        test.add(63.);
        test.add(3.);
        test.add(13.);
        test.add(74.);
        test.add(13.);
        
        
        
        
        
        System.out.println(test);
        System.out.println(test.getMedian());
    }
    
}