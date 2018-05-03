import java.util.*;

public class MyHeap<T extends Comparable<T>>{
    private int size;
    private T[] heap;
    private boolean isMax;
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
        size = 0;
        heap = (T[])new Comparable[10];
        isMax = true;
    }
    
    public MyHeap(boolean Max){
        this();
        isMax = Max;
    }
    
    public void add(T s){
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
    
    public void adder(T s, int index){
        int next = (index - 1)/2;
        if(s.compareTo(heap[next]) > 0 && isMax || s.compareTo(heap[next]) < 0 && !isMax){
            pushUp(index);
            adder(s,next);
        }
    }
    
    public T remove(){
        T ans = heap[0];
        heap[0] = heap[size()-1];
        remover(peek(),0);
        heap[size()-1] = null;
        size--;
        System.out.println("subtract: " + peek() + "size: " + size());
        System.out.println(toString()); 
        return ans;
    }
    
    public void remover(T s, int index){
        int next = index*2;

        if(next + 2 < size() && s.compareTo(heap[next + 2]) < 0 && isMax ||
           next + 2 < size() && s.compareTo(heap[next + 2]) > 0 && !isMax ){
            pushDownRight(index);
            remover(s, next + 2);
        }
           else if(next + 1 < size() && s.compareTo(heap[next + 1]) < 0 && isMax ||
                   next + 1 < size() && s.compareTo(heap[next + 1]) > 0 && !isMax){
            pushDownLeft(index);
            remover(s, next + 1);
        
        }
    }
    
    private void swap(int prev, int next){
        T temp = heap[prev];
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
    
    private T getTree(int n){
        return heap[(n - 1) /2];
    }
    
    private T getLeft(int n){
        if(n + n + 1 > size()){
           // return false;
        }
        return heap[n + n + 1];
    }
    
    private T getRight(int n){
        if(n + n + 2 > size()){
          //      return false;
        }
        return heap[n + n + 2];
    }
   
   @SuppressWarnings("unchecked")
   public void resize(){
       T[] temp = (T[])new Comparable[heap.length * 2];
       for(int i = 0; i < size(); i++){
           temp[i] = heap[i];
       }
       heap = temp;
   }
    
    public T peek(){
        return heap[0];
    }
    
    public int size(){
        return size;
    }
    
    public String toString(){
        return Arrays.toString(heap);
    }
    
    public static void main(String[]args){
        MyHeap<String> test = new MyHeap<>(true);
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
            