public class Quick{

    public int partition(int[] data, int low, int hi){
	int pivot = low;
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
	}
        swap (data,j,low);
        return j;	
    }
}
	
	
