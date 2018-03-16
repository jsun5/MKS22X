public class Quick{

    public static int partition(int[] data, int low, int hi){
	int pivot = (int) (Math.random() * (hi - low)) + low;
	System.out.println(pivot);
	int i = low;
	int j = hi;
	swap (data,i,pivot);
	i++;
	while(i <= j){
	    if (data[i] < data[low]){
		i++;
	    }
	    if (data[i] > data[low]){
		swap(data, i, j);
		j--;
	    }
	    print(data);
	    System.out.println("i: " + i);
	    System.out.println("j: " + j);
	}
        swap (data,j,low);
        return j;	
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

    public static void main(String[]args){
	int[] ex = {0,5,2,3,1};
	System.out.println(Quick.partition(ex,0,4));
    }
}
	
	
