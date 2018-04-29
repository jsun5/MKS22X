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
         //   resize();
        }
        heap[size()] = s;
        int index = (size() - 1)/2;
        while(heap[index].compareTo(s) < 0){
            swap(index, (index - 1)/2);
            index = (index - 1)/2;
        }
        size++;
        
    }
    
    private void swap(int prev, int next){
        String temp = heap[prev];
        heap[prev] = heap[next];
        heap[next] = temp;
    }
    
    private void pushUp(int i){
        if(heap[i].compareTo(getTree(i)) < 0){
            swap(i, (i-1)/2);
        }
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
   
    
    public String remove(){
        return "";
    }
    
    public String peek(){
        return "";
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
        System.out.println(test);
    }
}
            