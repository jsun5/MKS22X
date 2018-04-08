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
    
    public boolean add(Integer value){
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

    public int set(int index, Integer value){
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
        
    public int indexOf(Integer value){
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
    
    public void add (int index, Integer value){
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
    
/*    public static void main(String[]args){
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
        
        
    }*/
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Get ---");
        MyLinkedList a = new MyLinkedList();
        
        for (int x = 0; x < 10; x++) {
            a.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(a);
        
        for (int y = 0; y < 10; y++) {
            System.out.println(y + ": " + a.get(y));
        }
        
        System.out.println();
        System.out.println("--- Set ---");
        System.out.println(a);
        
        int former;
        int replace;
        
        for (int q = 0; q < 10; q++) {
            replace = 10 - q;
            former = a.set(q, replace);
            System.out.println("Change " + former + " to " + replace);
        }
        
        System.out.println(a);
        
        System.out.println();
        System.out.println("--- Index Of ---");
        System.out.println(a);
        
        for (int z = 0; z < 12; z++) {
            System.out.println(z + ": " + a.indexOf(new Integer(z)));
        }
        
        System.out.println();
        System.out.println("--- Add At End ---");
        MyLinkedList b = new MyLinkedList();
        System.out.println(b);

        for (int i = 0; i < 10; i++) {
            b.add(new Integer((int) (Math.random() * 100)));
        }

        System.out.println(b);
        System.out.println("Size: " + b.size());
        
        System.out.println();
        System.out.println("--- Add At Index ---");
        System.out.println(b);
        
        for (int s = 0; s < 13; s += 6) {
            b.add(s, new Integer(-99));
            System.out.println("Index " + s + ": " + b);
        }
        
        System.out.println();
        System.out.println("--- Remove Value ---");
        MyLinkedList j = new MyLinkedList();
        
        for (int u = 1; u < 6; u++) {
            j.add(new Integer(u));
        }
        
        System.out.println(j);
        
        for (int k = 1; k < 6; k += 2) {
            System.out.println("Removing " + k);
            j.remove(new Integer(k));
            System.out.println(j);
        }
        
        System.out.println();
        System.out.println("--- Remove at Index ---");
        MyLinkedList c = new MyLinkedList();
        
        for (int f = 0; f < 10; f++) {
            c.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(c);
        System.out.println("Size: " + c.size());
        
        System.out.println("Removed " + c.get(0) + " at index 0");
        c.remove(0);
        
        System.out.println("Removed " + c.get(4) + " at index 4");
        c.remove(4);
        
        System.out.println("Removed " + c.get(7) + " at index 7");
        c.remove(7);
        
        System.out.println(c);
    }

}
	    
	
