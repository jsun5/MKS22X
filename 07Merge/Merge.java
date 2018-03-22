public class Merge{
    
//    public static void mergesort(int[]data){
  //      msort(data, new int[data.length), 0, data.length);
 //   }
    
   // public static void (int[]data,int[]temp,int lo, int hi){
        
    //}
    
    public static int[] merge(int[]data, int[]ans, int lo, int mid, int hi){
        ans = new int[data.length];
        int i1 = lo;
        mid = (lo + hi) / 2 - 1;
        int i2 = mid;
        int counter = 0;
        System.out.println("i1: " + i1 + "mid: " + mid  + "i2: " + i2);
        while (i1 < mid && i2 < hi){
            if (data[i1] < data[i2]){
                ans[counter] = data[i1];
                i1 ++;
            }
            else{
                ans[counter] = data[i2];
                i2++;
            }
            counter ++;
        }
        if (i1 == mid){
            for(int i = i2; i < hi; i++){
                ans[counter] = data[i];
                counter ++;
            }
        }
        else{
            for (int i = i1; i < mid; i++){
                ans[counter] = data[i];
                counter++;
            }
        }
        return ans;
    }
    
    public static void print(int[]data){
        String ans = "[";
        for (int i = 0; i < data.length; i++){
            ans += data[i] + ", ";
        }
        System.out.println( ans + "]");
    }
    
    public static void main(String[]args){
        int[] tester = {2,4,7,1,2,2,5,6,8};
        int[] temp = {};
        print(merge(tester,temp,0,3,9));
    }
}
