import java.util.*;

public class MyDeque<T>{
    private int size, front, back;
    private T[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
        front = 1;
        back = 0;
        size = 0;
        data = (T[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        front = 1;
        back = 0;
        size = 0;
        data = (T[])new Object[initialCapacity];
    }
    
    public int size(){
        return size;
    }
    
    public void addFirst(T elem){
        if (elem == null){
            throw new NullPointerException();
        }
        if(size() == data.length){
            resize();
        }
        int index = (front + data.length - 1) % data.length ;
        if(data[index] == null){
            data[index] = elem;
            front = index;
            size++;
        }
    }
    
    public void addLast(T elem){
        if(elem == null){
            throw new NullPointerException();
        }
        if(size()==data.length) {
            resize();
        }
        int index = (back + 1) % size();
        if (data[index] == null){
            data[index] = elem;
            back = index;
        }
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Object[size() * 2];
        int counter = 0;
        int i;
        for(i = front; i < size() + back; i++){
            temp[counter] = data[i];
        }
        front = 0;
        back = counter;
        data = temp;
    }
    
    public T getFirst(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        return data[front];
    }
    
    public T getLast(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        return data[back];
    }
    
    public T removeFirst(){
        T value = getFirst();
        data[front] = null;
        front++;
        return value;
    }
    
    public T removeLast(){
        T value = getLast();
        data[back] = null;
        back--;
        return value;
    }
    
    public String toString(){
        return Arrays.toString(data);
    }
    
    public static void main(String[]args){
        MyDeque<Integer> test= new MyDeque<>();
        System.out.println(test);
        for(int i = 0; i < 15; i++){
            test.addFirst(1);
            test.addLast(2);
            System.out.println(test);
        }
        System.out.println(test);
    }
}
            
        