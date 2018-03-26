public class Quick{

    public static int partition(int[] data, int low, int hi){
        int pivot = (int) (Math.random() * (hi - low)) + low; //cool random by Mohammed
	//    System.out.println("pivot index: " + pivot +", pivot: " + data[pivot]);
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
	    //  print(data);
	    // System.out.println("i: " + i);
            //System.out.println("j: " + j);
        }
        swap (data,j,low);
        //print(data);
        return j;
    }
    
    public static int partitionD(int[]data,int low, int hi){
        print(data);
        int pivot = (int) (Math.random() * (hi - low)) + low; //cool random by Mohammed
        System.out.println("pivot index: " + pivot +", pivot: " + data[pivot]);
        swap (data,low,pivot);
        int lt = low;
        int gt = hi;
        int i = lt;
        while(i <= gt){
            if (data[i] < data[low]){
                swap(data,i,lt);
                i ++;
                lt++;
            }
            else if (data[i] == data[low]){
                i++;
            }
            else if (data[i] > data[low]){
                swap(data,i,gt);
                gt--;
            }
            print(data);
            System.out.println("i: " + i);
            System.out.println("lt: " + lt);
            System.out.println("gt: " + gt);
        }
        swap(data,gt,low);
        print(data);
        return gt;
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
        int i = partition(data,0,data.length - 1);
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
    
    /* OLDER VERSION: NO INSERTION
    public static void quicksort (int[]ary){
        quicksorter(ary, 0, ary.length - 1);
    }
    
    public static void quicksorter(int[]ary, int low, int hi){
        if (low < hi){
            int pivot = partition(ary, low, hi);
            quicksorter(ary, low, pivot);
            quicksorter(ary, pivot + 1, hi);
        }
	// print(ary);
    }*/


    public static void insertionsort(int[] data, int lo, int hi){ //helped by robin han
        int ind;
        for (int i = lo; i < hi+1; i ++) {
            int k = data[i];
            for (ind = i; ind > lo && k < data[ind-1]; ind --) {
                data[ind] = data[ind-1];
            }
            data[ind] = k;
        }
	//	print(data);
    
    }

    
    public static void quicksort (int[]ary){
        quicksorter(ary, 0, ary.length - 1);
    }
    
    public static void quicksorter(int[]ary, int low, int hi){
	if (hi - low <= 2){
	    insertionsort(ary, low, hi);
	}
	else{ int pivot = partition(ary, low, hi);
            quicksorter(ary, low, pivot);
            quicksorter(ary, pivot + 1, hi);
        }
	// print(ary);
    }

    
        

    public static void main(String[]args){
	int[] ex = {999,999,999,4,1,0,3,2,999,999,999};
    int[] ex2 = {0,2,1,2,0};
	//System.out.println(Quick.partition(ex,0,10));
    //System.out.println(Quick.partitionD(ex,0,10));
    System.out.println(Quick.quickselect(ex, 6));
        //System.out.println(Quick.partitionD(ex2,0,4));
    // Quick.quicksort(ex);
    //Quick.insertionSort(ex,0,10);
    //Quick.quicksort(ex);
    }
}
	
	
