public class MyLinkedList{
    private Node first,last;
    private int length;
    
    public MyLinkedList(){
	first = null;
	last = null;
	length = 0;
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

    public void set(int index, int value){
	if (n == length-1){
	    last = new Node(value);
	}
	

    private class Node{
	Node next,prev;
	int data;

	public Node(int d){
	    data = d;
	    next = null;
	    prev = null;
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
	    
	
