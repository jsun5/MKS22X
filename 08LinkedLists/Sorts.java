import java.util.*;

public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
        if (data.size() == 0){
            return;
        }
        
        MyLinkedListImproved<Integer> list = data;
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] negBuckets = new MyLinkedListImproved[10];
        
        for(int i = 0; i < 10; i++){
            buckets[i] = new MyLinkedListImproved<>();
        }
        
        for(int i = 0; i < 10; i++){
            negBuckets[i] = new MyLinkedListImproved<>();
        }
        
        int cap = 0;
        int digit = 10;
        
        int Pcap = getCap(list.getMax());
//        System.out.println("cap: " + cap);
        int Ncap = getCap(list.getMin());
        if (Pcap > Ncap){
            cap = Pcap;
        }
        else{
            cap = Ncap;
        }
        
        while(cap >= 0){
            
            for(Integer num : list){
                if (num > 0){
                    buckets[num % digit / (digit / 10)].add(num);
                }
                else{
                    negBuckets[num % digit / (digit / 10) + 9].add(num);
                }
            }
        
//            print(buckets);
            list.clear();
        
            for(int i = 0; i < 10; i ++){
                list.extend(negBuckets[i]);
            }
            
            for(int i = 0; i < 10; i ++){
                list.extend(buckets[i]);
            }
        
//            System.out.println("list: "+ list);
//            print(buckets);
            
            digit *= 10;
            cap --;
        }
        
    }
    
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
        radixsort(data);
    }
    
    public static void print(MyLinkedListImproved<Integer>[] data){
        for (int i = 0; i < 10; i++){
            System.out.println("" + i + data[i]);
        }
    }
    
    public static int getCap(Integer n){
        n = Math.abs(n);
        int cap = 0;
        while (n >= 10){
            n = n/10;
            cap++;
        }
        return cap;
    }        
            
    
/*    public static void main(String[]args){
        MyLinkedListImproved<Integer> test = new MyLinkedListImproved<>();
        test.add (1001000);
        test.add (149);
                test.add (233);
        test.add (623);
                test.add (854);
        test.add (122);
                test.add (100);
        test.add (141);
        test.add (2);
        test.add (2);
        test.add (4);
        test.add (2);
        test.add (8);
        test.add (9);
        test.add (7);
        test.add (6);
        test.add (8);
        test.add (9);
        System.out.println(test);
        radixsort(test);
        System.out.println(test); 
    }*/

public static void main(String[] args) {
    //-----------SORTING POSITIVES-----------
    System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
    MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
    int[] correctData = new int[10000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10000; i++){
      int temp = (int)(Math.random() * 10000);
      data.add(temp);
      correctData[i] = temp;
    }
//    System.out.println(data);

    //Sorts data and times the sort
    long end,start = System.currentTimeMillis();
    radixsort(data);
//    System.out.println(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
//    System.out.println("CORRECT: "+Arrays.toString(correctData));
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    boolean hasError = false;
    int index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with all positive integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");

    //-----------SORTING NEGATIVES-----------
    System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
    data.clear();
    correctData = new int[10000];
    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10000; i++){
      int temp = (int)(Math.random() * 10000);
      temp *= -1;
      data.add(temp);
      correctData[i] = temp;
    }
    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();
    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");
    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }
    if(!(hasError)){
      System.out.println("Your LinkedList with all negative numbers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");
    
    
    //-----------SORTING POSITIVES AND NEGATIVES-----------
    System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
    data.clear();
    correctData = new int[10000];
    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 10000; i++){
      int temp = (int)(Math.random() * 10000);
      if((int)(Math.random() * 10000) % 2 == 0){
        temp *= -1;
      }
      data.add(temp);
      correctData[i] = temp;
    }
    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();
    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");
    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }
    if(!(hasError)){
      System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");
    //-----------SORTING EMPTY LISTS-----------
    System.out.println("SORTING ON EMPTY LISTS");
    data.clear();
    correctData = new int[0];
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();
    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");
    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }
    if(!(hasError)){
      System.out.println("Your empty LinkedList is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");
    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];
    int temp = (int)(Math.random() * 1000);
    data.add(temp);
    correctData[0] = temp;
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();
    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");
    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }
    if(!(hasError)){
      System.out.println("Your LinkedList with one positive element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");
    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];
    temp = (int)(Math.random() * 1000) * -1;
    data.add(temp);
    correctData[0] = temp;
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();
    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");
    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }
    if(!(hasError)){
      System.out.println("Your LinkedList with one negative element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
  }
}
