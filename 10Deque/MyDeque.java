import java.util.*;

public class MyDeque<T>{
    private int size, front, back;
    private T[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
        front = 0;
        back = -1;
        size = 0;
        data = (T[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        front = 0;
        back = -1;
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
        if(front == 0){
            front = data.length;
        }
        front --;
        if(data[front] == null){
            data[front] = elem;
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
        if(back == size()){
            back = -1;
        }
        back++;
        if (data[back] == null){
            data[back] = elem;
            size++;
        }
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Object[data.length * 2];

        for(int i = 0; i < data.length; i++){
            temp[i] = data[(front + i)/ data.length];
        }
        front = 0;
        back = data.length -1;
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
        front = (front + 1) % data.length;
        size--;
        return value;
    }
    
    public T removeLast(){
        T value = getLast();
        data[back] = null;
        back = (back - 1 + data.length) % data.length;
        back--;
        return value;
    }
    
    public String toString(){
        return Arrays.toString(data);
    }
    
    /*public static void main(String[]args){
        MyDeque<Integer> test= new MyDeque<>();
        System.out.println(test);
        for(int i = 0; i < 15; i++){
            test.addFirst(1);
            test.addLast(2);
            System.out.println(test);
        }
        System.out.println(test);
    }*/
      public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
}
            
        