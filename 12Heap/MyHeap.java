import java.util.*;

public class MyHeap{
    private int size;
    private String[] heap;
    private boolean isMax;
    
    public MyHeap(){
        size = 0;
        heap = new String[10];
        isMax = true;
    }
    
    public MyHeap(boolean Max){
        this();
        isMax = Max;
    }
    
    public void add(String s){
        if(size() >= heap.length){
            resize();
        }
        heap[size()] = s;
        //int index = (size() - 1)/2;
        adder(s, size());
        size++;
        System.out.println("add: " + s + "size: " + size());
        System.out.println(toString()); 
        
    }
    
    public void adder(String s, int index){
        int next = (index - 1)/2;
        if(s.compareTo(heap[next]) > 0){
            pushUp(index);
            adder(s,next);
        }
    }
    
    public String remove(){
        String ans = heap[0];
        heap[0] = heap[size()-1];
        remover(peek(),0);
        heap[size()-1] = null;
        size--;
        System.out.println("subtract: " + peek() + "size: " + size());
        System.out.println(toString()); 
        return ans;
    }
    
    public void remover(String s, int index){
        int next = index*2;

        if(next + 2 < size() && s.compareTo(heap[next + 2]) < 0){
            pushDownRight(index);
            remover(s, next + 2);
        }
           else if(next + 1 < size() && s.compareTo(heap[next + 1]) < 0){
            pushDownLeft(index);
            remover(s, next + 1);
        
        }
    }
    
    private void swap(int prev, int next){
        String temp = heap[prev];
        heap[prev] = heap[next];
        heap[next] = temp;
    }
    
    private void pushUp(int i){
            swap(i, (i-1)/2);
    }
    
    private void pushDownLeft(int i){
        swap(i, 2*i + 1);
    }
    
    private void pushDownRight(int i){
        swap(i, 2*i + 2);
    }
    
    private String getTree(int n){
        return heap[(n - 1) /2];
    }
    
    private String getLeft(int n){
        if(n + n + 1 > size()){
           // return false;
        }
        return heap[n + n + 1];
    }
    
    private String getRight(int n){
        if(n + n + 2 > size()){
          //      return false;
        }
        return heap[n + n + 2];
    }
   
   public void resize(){
       String[] temp = new String[heap.length * 2];
       for(int i = 0; i < size(); i++){
           temp[i] = heap[i];
       }
       heap = temp;
   }
    
    public String peek(){
        return heap[0];
    }
    
    public int size(){
        return size;
    }
    
    public String toString(){
        return Arrays.toString(heap);
    }
    
    public static void main(String[]args){
        MyHeap test = new MyHeap();
        test.add("0");
        test.add("1");
                test.add("5");
        test.add("8");
                test.add("2");
        test.add("1");  
        test.add("0");
        test.add("1");
                test.add("5");
        test.add("8");
                test.add("2");
        test.add("1");  
        test.add("0");
        test.add("1");
                test.add("5");
        test.add("8");
                test.add("2");
        test.add("1");  
        for(int i = 10; i > 0; i--){
        test.remove();
        }
        System.out.println(test);
    }
}
            