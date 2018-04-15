public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
        MyLinkedListImproved<Integer> list = data;
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
        int digit = 0;
        Node current = list.getNode(0);
        while(current.getValue() != null){
            int num = current.getValue();
            buckets[num % digit / 10].add(num);
            current = current.getNext();
        }
    }
}
