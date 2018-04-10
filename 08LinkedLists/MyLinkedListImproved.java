import java.util.LinkedList;
 
public class MyLinkedListImproved<T>{
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
        for (int i = 0; i < size(); i++){
            ans += getNode(i).toString() + ",";
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
    
    public static void main(String[]args){
        MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>();
        System.out.println(test);
        System.out.println(test.size());
        
        test.add(5);
        System.out.println(test);
        System.out.println(test.size());
        
        test.add(3);
        System.out.println(test);
        System.out.println(test.size());
        
        test.add(7);
        //test.clear();
        System.out.println(test);
        System.out.println(test.size());
        
        System.out.println(test.get(0));
        
        System.out.println(test.set(0,125));
        System.out.println(test);
        System.out.println(test.indexOf(125));
        
        test.add(3,12);
        System.out.println(test);
        System.out.println(test.size());
        
        System.out.println("removed: " + test.remove(3));
        System.out.println(test);
        System.out.println(test.size());
        
        System.out.println("removed: 125" + test.remove(125));
        System.out.println(test);
        System.out.println(test.size());
        
        
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
