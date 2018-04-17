import java.util.*;
import java.util.LinkedList;
 
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node head,tail;
    private int size;
    
    public MyLinkedListImproved(){
        head = null;
        tail = null;
        size = 0;
    }

    private Node getNode(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    public int size(){
        return size;
    }
    
    public void clear(){
        size = 0;
        head = null;
        tail = null;
    }
    
    public boolean add(T value){
        if(size() == 0){
            Node only = new Node(value);
            head = only;
            tail = only;
            size++;
        }
         else if (size() == 1){
            tail = new Node(value, head, null);
            head.setNext(tail);
            size++;
        }
        else{
            tail = new Node(value, getNode(size()-1), null);
            getNode(size()-1).setNext(tail);
            size++;
        }
        return true;
    }
        
        
    public T get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if (index == size() -1){
            return tail.getValue();
        }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    public T set(int index, T value){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if (index == size-1){
            tail.setValue(value);
        }
        Node current = getNode(index);
        T past = current.getValue();
        current.setValue(value);
        return past;
    }
    
    public String toString(){
        String ans = "[";
        Node current = head;
        while(current != null){
            ans += current.getValue().toString() + ",";
            current = current.getNext();
        }
        return ans + "]";
    }
        
    public int indexOf(T value){
        int i = 0;
        Node current = head;
        while(i < size()){
            if(current.getValue()==value){
                return i;
            }
            current=current.getNext();
            i++;
        }
        return -1;
    }
    
    public void add (int index, T value){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == size()){
            add(value);
        }
        else if(index == 0){
            Node n = new Node(value, null, head);
            head = n;
            n.getNext().setPrev(head);
            size++;
        }
        else{
            Node before = getNode(index - 1);
            Node after = getNode(index);
            Node n = new Node(value, before, after);
            before.setNext(n);
            after.setPrev(n);
            size++;
        }
    }
    
    public T remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        T past = null;
        if(index == size()){
            if (size()==0){
                past = head.getValue();
                head = null;
                tail = null;
            }
        }
        else if (index == size()-1){
            past = tail.getValue();
            Node next = tail.getPrev();
            next.setNext(null);
            tail = next;
        }
        else if(index == 0){
            past = head.getValue();
            Node next = head.getNext();
            next.setPrev(null);
            head = next;
        }
        else{
            past = getNode(index).getValue();
            Node before = getNode(index - 1);
            Node after = getNode(index + 1);
            after.setPrev(before);
            before.setNext(after);
        }
        size--;
        return past;
    }
    
    public boolean remove (T Value){
        int index = indexOf(Value);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }
            

    private class Node{
        Node next,prev;
        T data;

        public Node(T d){
            data = d;
            next = null;
            prev = null;
        }
        
        public Node(T d, Node p, Node n){
            data = d;
            next = n;
            prev = p;
        }
	    
        private Node getNext(){
            return next;
        }

        private Node getPrev(){
            return prev;
        }

        private T getValue(){
            return data;
        }

        private void setNext(Node n){
            next = n;
        }

        private void setPrev(Node p){
            prev = p;
        }

        private void setValue(T d){
            data = d;
        }   

        public String toString(){
            return "" + data;
        }
    }
    

    private class ListIterator_T implements Iterator<T>{
        private Node current;
        private MyLinkedListImproved<T> data;
        private boolean first;

        public ListIterator_T (MyLinkedListImproved<T> d){
            data = d;
            current = data.head;
	    //    first = true;
        }
        
        public boolean hasNext(){
            return  current != null;
        }
   
        public T next(){
	    //   if(first){
	    //	    //       first = false;
	    //          return current.getValue();
	       //      }
	    T val = current.getValue();
            if(hasNext()){
                current = current.getNext();
            }
            else{
                System.exit(0);
            }
            return val;
        }
    }
    
    
    public Iterator<T> iterator(){
        return new ListIterator_T(this);
    }

     public int max(){
        if (size() == 0){
            return -1;
        }
        int biggestIndex = 0;
        int currentIndex = 0;
        T big = head.getValue();
        Node current = head;
        while(current != null){
            if(current.getValue().compareTo(big) > 0){
                biggestIndex = currentIndex;
                big = current.getValue();
            }
            current = current.getNext();
            currentIndex++;
        }
        return biggestIndex;
     }
     
     public T getMax(){
         return getNode(max()).getValue();
     }
     
     public T getMin(){
         return getNode(min()).getValue();
     }

     public int min(){
        if (size() == 0){
            return -1;
        }
        int smallestIndex = 0;
        int currentIndex = 0;
        T small = head.getValue();
        Node current = head;
        while(current != null){
            if(current.getValue().compareTo(small) < 0){
                smallestIndex = currentIndex;
                small = current.getValue();
            }
            current = current.getNext();
            currentIndex++;
        }
        return smallestIndex;
     }
     
     public void extend(MyLinkedListImproved<T> o){
         //System.out.println("head o: " + o.head + " tail: " + tail);
        if(o.size() > 0){
            if(size()>0){
                tail.setNext(o.head);
                o.head.setPrev(tail);
                tail = o.tail;
                //System.out.println(getNode(5).getNext().getValue());
                size += o.size();
                o.clear();
            }
            else{
                head = o.head;
                tail = o.tail;
                size = o.size;
                o.clear();
            }
        }
     }
	
	
	    
    
    public static void main(String[]args){
        MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
        n.add("apple");
        n.add("fish");
        n.add("crab");
        n.add("donkey");
        System.out.println(n);
        
        MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        m.add(new Integer(5));
        m.add(new Integer(3));
        m.add(new Integer(2));
        m.add(new Integer(12));
        m.add(new Integer(2));
        m.add(new Integer(3));
        System.out.println(m);
        
        MyLinkedListImproved<Integer> p = new MyLinkedListImproved<>();
        p.add(new Integer(252));
        p.add(new Integer(1252));
        p.add(new Integer(2523));
        p.add(new Integer(64));
                                
        
        for (String elem : n){
            System.out.println("Elem: " + elem);
        }
        
        System.out.println("Max: " + n.getNode(n.max()).getValue() + " at index: " + n.max());
        System.out.println("Min: " + n.getNode(n.min()).getValue() + " at index: " + n.min());
        
        System.out.println("Max: " + m.getNode(m.max()).getValue() + " at index: " + m.max());
        System.out.println("Min: " + m.getNode(m.min()).getValue() + " at index: " + m.min());
        
        System.out.println("Max: at index: " + p.max());
        System.out.println("Min: at index: " + p.min());
        
       m.extend(p);
       System.out.println("m: " + m + m.size() + "p: " + p + p.size());
    }
}


/*    public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<T> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,T.valueOf(i));
      }
      if(nums.remove(T.valueOf(0)) && nums.remove(T.valueOf(1)) &&
      nums.remove(T.valueOf(5)) && nums.remove(T.valueOf(3)) &&
      nums.remove(T.valueOf(8))&& nums.remove(T.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i)){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (T, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }
    
    
    
  }*/
