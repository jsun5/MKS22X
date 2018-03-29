public class MyLinkedList{
    private Node first,last;
    private int length;
    
    public MyLinkedList(){
        first = null;
        last = null;
        length = 0;
    }

    private Node getNode(int index){
	Node current = first;
        for (int i = 0; i < n; i++){
            current = current.getNext();
        }
	return current;
    }

    public void clear(){
    }
	
    public int getLength(){
        return length;
    }
    
    public Node getFirst(){
        return first;
    }
    
    public Node getLast(){
        return last;
    }
    
    public void Longer(){
        length++;
    }
    
    public void setFirst(Node n){
        first = n;
    }
    
    public void setLast(Node n){
        last = n;
    }
    
    public boolean add(int value){
        if(getLength() == 0){
	    Node only = new Node(value);
            first = only;
	    last = only;
            Longer();
            return true;
        }
        if(getLength() == 1){
            last = new Node(value, first, null);
            first.setNext(last);
            Longer();
            return true;
        }
	getNode(getLength()-1).setNext(new Node(value, getNode(getLength()-2)));
        return true;
    }
        
        

    public int get(int n){
        if (n == length-1){
            return last;
        }
        Node current = first;
        for (int i = 0; i < n; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    public int set(int index, int value){
        if (n == length-1){
            last = new Node(value);
        }
        int prev = 0;
        Node current = first;
        for (int i = 0; i < n; i++){
            current = current.getNext();
        }
        prev = current.getValue();
        
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

        private String toString(){
            return "" + data;
        }
    }
	    
	
