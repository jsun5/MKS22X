import java.util.*;

public class MyDeque<T>{
    int size, front, back;
    T[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
        front = 1;
        back = 0;
        size = 10;
        data = (T[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        front = 1;
        back = 0;
        size = initialCapacity;
        data = (T[])new Object[initialCapacity];
    }
    
    public int size(){
        return size;
    }
    
    public void addFirst(T elem){
        if (elem == null){
            throw new NullPointerException();
        }
        int index;
        if (front == 0){
            index = size() - 1;
        }
        else{
            index = front - 1;
        }
        if(data[index] == null){
            data[index] = elem;
            front = index;
        }
        //else{resize();}
    }
    
    public void addLast(T elem){
        if(elem == null){
            throw new NullPointerException();
        }
        int index = (back + 1) % size();
        if (data[index] == null){
            data[index] = elem;
            back = index;
        }
        //else resize
    }
    
    //public void resize(){
      //  T[] temp = new T[size() * 2];
     //   for(int i = head; i < hea
    
    public String toString(){
        return Arrays.toString(data);
    }
    
    public static void main(String[]args){
        MyDeque<Integer> test= new MyDeque<>();
        System.out.println(test);
        for(int i = 0; i < 6; i++){
            test.addFirst(1);
            test.addLast(2);
        }
        System.out.println(test);
    }
}
            
        