import java.util.*;

public class MyDeque<T>{
    private int size, front, back;
    private T[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
        front = 0;
        back = 0;
        size = 0;
        data = (T[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        front = 0;
        back = 0;
        size = 0;
        data = (T[])new Object[initialCapacity];
    }
    
    public int size(){
        return size;
    }
    
    //Credit to Robin Han for helping me w/ add and remove
    public void addFirst(T elem){
        if (elem == null){
            throw new NullPointerException();
        }
        if(size() == data.length){
            resize();
        }
        if(size()==0){
            data[front] = elem;
        }
        else if(front == 0){
            data[data.length - 1] = elem;
            front = data.length - 1;
        }
        else{
            data[front-1] = elem;
            front-=1;
        }
        size++;
    }
    
    public void addLast(T elem){
        if(elem == null){
            throw new NullPointerException();
        }
        if(size()==data.length) {
            resize();
        }
        if(size()==0){
            data[back]=elem;
        }
        else if(back == data.length - 1){
            data[0]=elem;
            back = 0;
        }
        else{
            data[back + 1] = elem;
            back++;
        }
        size++;
    }
    
    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[])new Object[data.length * 2];
        if(back < front){
        int count = 0;
        for(int i = front; i < data.length; i++){
            temp[count] = data[i];
            count++;
        }
        for(int i = 0; i <= back; i++){
            temp[count] = data[i];
            count++;
        }
        
        }
        else{
            for(int i = front; i <= back; i++){
                temp[i] = data[i];
            }
        } 
        data = temp;
        front = 0;
        back = size()-1;

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
        if(size() == 0){
            throw new NoSuchElementException();
        }
        T value = data[front];
        data[front] = null;
        if(front==data.length - 1){
            front = 0;
            size--;
        }
        else{
            front++;
            size--;
        }
        return value;
    }
    
    public T removeLast(){
        if(size() == 0){
            throw new NoSuchElementException();
        }
        T value = data[back];
        data[back] = null;
        if(back == 0){
            back = data.length -1;
            size--;
        }
        else{
            back --;
            size--;
        }
        return value;
    }
    
    /*public String toString(){
        return Arrays.toString(data);
    }*/
    
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
    public String toString(){
	String ans = "";
	if (front <= back){
	    for (int i = front; i <= back; i++){
		ans += data[i] + " ";
	    }
	}
	else{
	    for (int i = front; i <= back+ size; i++){
		ans += data[i%size] + " ";
	    }
	}
	return ans;
    }
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
      }//System.out.println("a: " + a + "     b: " + b);
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
    //MyDeque<String> a = new MyDeque<>();
    //a.add("apple");
    //System.out.println(a);
  }
}
            
        