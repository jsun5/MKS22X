public class Sort{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
        
        MyLinkedListImproved<Integer> list = data;
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
        
        for(int i = 0; i < 10; i++){
            buckets[i] = new MyLinkedListImproved<>();
        }
        
        int digit = 10;
        int cap = getCap(list.getMax());
        System.out.println("cap: " + cap);
        
        while(cap > 0){
            
            for(Integer num : list){
                buckets[num % digit / (digit / 10)].add(num);
            }
        
            print(buckets);
            list.clear();
        
            for(int i = 0; i < 10; i ++){
                list.extend(buckets[i]);
            }
        
            System.out.println("list: "+ list);
            print(buckets);
            
            digit *= 10;
            cap --;
        }
        
    }
    
    public static void print(MyLinkedListImproved<Integer>[] data){
        for (int i = 0; i < 10; i++){
            System.out.println("" + i + data[i]);
        }
    }
    
    public static int getCap(Integer n){
        int cap = 0;
        while (n >= 10){
            n = n/10;
            cap++;
        }
        return cap;
    }        
            
    
    public static void main(String[]args){
        MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>();
        test.add (1001000);
        test.add (149);
                test.add (233);
        test.add (623);
                test.add (854);
        test.add (122);
                test.add (100);
        test.add (141);
        System.out.println(test);
        radixsort(test);
        System.out.println(test);
    }
}
