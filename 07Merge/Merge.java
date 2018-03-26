public class Merge{
    
    public static void mergesort(int[]data){
        msort(data, new int[data.length], 0, data.length-1 );
    }
    
    public static void msort(int[]data,int[]temp,int lo, int hi){
        if (lo >= hi){
            return;
        }
        for (int i = lo; i < hi; i++){
            temp[i] = data[i];
        }
        int mid = (lo/2) + (hi/2);
        msort(temp, data, lo, mid );
        msort(temp, data, mid + 1, hi);
        merge(data, temp, lo, mid , hi);
    }
    
    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
        int i1 = lo;
        int i2 = mid + 1;
        int counter = lo;
//	System.out.println("i1: " + i1 + "mid: " + mid  + "i2: " + i2);
        while (i1 <= mid && i2 <=   hi){
            if (temp[i1] < temp[i2]){
                data[counter] = temp[i1];
                i1 ++;
            }
            else{
                data[counter] = temp[i2];
                i2++;
            }
            counter ++;
        }
        if (i1 <= mid ){
            for(int i = i1; i <= mid; i++){
                data[counter] = temp[i];
                counter ++;
            }
        }
        else{
            for (int i = i2; i <=hi ; i++){
                data[counter] = temp[i];
                counter++;
            }
        }
    }
    
    public static void print(int[]data){
        String ans = "[";
        for (int i = 0; i < data.length; i++){
            ans += data[i] + ", ";
        }
        System.out.println( ans + "]");
    }
    
    public static void main(String[]args){
        int[] tester = {2,4,6,1,2,2,5,6,8};
        int[] temp = {0,0,0,0,0,0,0,0,0};
        //merge(tester,temp,0, 9/2,9);
        //print(temp);
        mergesort(tester);
        print(tester);
        
    }
}
