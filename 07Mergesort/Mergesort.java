public class Mergesort{
    
    public static int[] merge(int[]data,int s1, int e1, int s2, int e2){
        int[] ans = new int[data.length];
        int i1 = s1;
        int i2 = s2;
        int counter = 0;
        while (i1 < e1 && i2 < e2){
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
        if (i1 == e1){
            for(int i = i2; i < e2; i++){
                ans[counter] = data[i];
                counter ++;
            }
        }
        else{
            for (int i = i1; i < e1; i++){
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
        print(merge(tester,0,3,3,9));
    }
}