import java.util.*;

public class Sorts{
    
    public static void heapSort(int[]data){
        heapify(data);
        int cut = data.length - 1;
        for( int i = 0; i < data.length; i++){
            swap(data,0,cut);
            heaper(data,0, cut);
            cut--;
        }
    }
    
    public static void heapify(int[]data){
        for(int i = data.length-1; i > -1; i--){
            heaper(data,i,data.length );
        }
    }
    
    public static void heaper(int []heap, int index, int end){
        int next = index*2;
        if(next + 1 < end && heap[index] < heap[next + 1] && heap[next+1] > heap[next+2]){
            swap(heap, index, next + 1);
            heaper(heap, next + 1, end);
        }
        else if(next + 2 < end && heap[index] < heap[next + 2] && heap[next+2] > heap[next+1]){
            swap(heap, index, next + 2);
            heaper(heap, next + 2, end);
        }
    }
    
    private static void swap(int[]heap, int prev, int next){
        int temp = heap[prev];
        heap[prev] = heap[next];
        heap[next] = temp;
    }
    
    public static void main(String[]args){
        int[] heap = new int[15];
        for(int i = 0; i < 15; i++){
            heap[i] = (int)(i*Math.random()*10);
        }
        System.out.println(Arrays.toString(heap));
        heapSort(heap);
        System.out.println(Arrays.toString(heap));
    }
}