public class Quick{

    public static int partition(int[] data, int low, int hi){
        int pivot = (int) (Math.random() * (hi - low)) + low; //cool random by Mohammed
        System.out.println("pivot index: " + pivot +", pivot: " + data[pivot]);
        swap (data,low,pivot);
        int i = low + 1;
        int j = hi;
        while(i <= j){
            if (data[i] < data[low]){
            i++;
        }
            else {
            swap(data, i, j);
            j--;
            }
            print(data);
            System.out.println("i: " + i);
            System.out.println("j: " + j);
        }
        swap (data,j,low);
        print(data);
        return j;
    }
    
    public static int partitionD(int[]data,int low, int hi){
        int pivot = (int) (Math.random() * (hi - low)) + low; //cool random by Mohammed
        System.out.println("pivot index: " + pivot +", pivot: " + data[pivot]);
        swap (data,low,pivot);
        int lt = low + 1;
        int gt = hi;
        int i = lt;
        while(i < gt){
            if (data[i] < data[low]){
                i ++;
                lt++;
            }
            if (data[i] == data[low]){
                i++;
            }
            else{
                swap(data,i,gt);
                gt--;
            }
            print(data);
            System.out.println("i: " + i);
            System.out.println("lt: " + lt);
            System.out.println("gt: " + gt);
        }
        swap(data,i,low);
        print(data);
        return i;
    }
                

    public static void print(int[]data){
	String ans = "{";
	for (int i = 0; i < data.length; i++){
	    ans+= data[i] + ", ";
	}
	ans+= "}";
	System.out.println(ans);
    }

	
    public static void swap (int[]data,int a, int b){
	int x = data[a];
	data[a] = data[b];
	data[b] = x;
    }
    
    public static int quickselect(int[]data,int k){
        int i = data.length;
        while (i != k){
            if (i > k){
                i = partition(data, 0, i - 1);
            }
            else {
                i = partition(data, i+1, data.length - 1);
            }
        }
        return data[k];
    }
    
//   public static void quicksort (int[]ary){
        

    public static void main(String[]args){
	int[] ex = {999,999,999,4,1,0,3,2,999,999,999};
	//System.out.println(Quick.partition(ex,0,10));
    System.out.println(Quick.partitionD(ex,0,10));
    //System.out.println(Quick.quickselect(ex, 4));
    }
}
	
	
