public class MyLinkedList{
    private Node head,tail;
    private int size;
    
    public MyLinkedList(){
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
    
    public boolean add(int value){
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
        
        
    public int get(int index){
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

    public int set(int index, int value){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if (index == size-1){
            tail.setValue(value);
        }
        Node current = getNode(index);
        int past = current.getValue();
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
        
    public int indexOf(int value){
        int i = 0;
        Node current = head;
        while(i < size()){
            if(current.getValue()==value){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public void add (int index, int value){
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
    
    public int remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        int past = 0;
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
    
    public boolean remove (Integer Value){
        int index = indexOf(Value);
        if (index != -1){
            remove(index);
            return true;
        }
        return false;
    }
            

    private class Node{
        Node next,prev;
        int data;

        public Node(int d){
            data = d;
            next = null;
            prev = null;
        }
        
        public Node(int d, Node p, Node n){
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

        private int getValue(){
            return data;
        }

        private void setNext(Node n){
            next = n;
        }

        private void setPrev(Node p){
            prev = p;
        }

        private void setValue(int d){
            data = d;
        }   

        public String toString(){
            return "" + data;
        }
    }
    
    public static void main(String[]args){
        MyLinkedList test = new MyLinkedList();
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
        
        System.out.println("removed: 125" + test.remove(new Integer(125)));
        System.out.println(test);
        System.out.println(test.size());
        
        
    }
}
	    
	
