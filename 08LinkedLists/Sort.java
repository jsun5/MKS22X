public class Sort{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
        MyLinkedListImproved<Integer> list = data;
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
        for(int i = 0; i < 10; i++){
            buckets[i] = new MyLinkedListImproved<>();
        }
        int digit = 10;
        for(Integer num : list){
            buckets[num % digit / (digit / 10)].add(num);
        }
        print(buckets);
    }
    
    public static void print(MyLinkedListImproved<Integer>[] data){
        for (int i = 0; i < 10; i++){
            System.out.println("" + i + data[i]);
        }
    }
            
    
    public static void main(String[]args){
        MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>();
        test.add (123);
        test.add (141);
        System.out.println(test);
        radixsort(test);
        System.out.println(test);
    }
}
