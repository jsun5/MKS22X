public class USACO{

    private int[][] elevations =
    {{28, 25, 20, 32, 34, 36},
     {27, 25, 20, 20, 30, 34},
     {24, 20, 20, 20, 20, 30},
     {20, 20, 14, 14, 20, 20}};
    


	
    //    public static int bronze(){
    // }

    private void stomp(int R_s, int C_s, int D_s){
	R_s--;
	C_s--;
	int largest = 0;
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if (elevations[R_s + r][C_s + c] > largest){
		    largest = elevations[R_s + r][C_s + c];
		}
	    }
	}
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if (elevations[R_s + r][C_s + c] > largest - D_s){
		    elevations[R_s + r][C_s + c] = largest - D_s;
		}
	    }
	}
    }

    public void print(){
	String ans = "";
	for (int r = 0; r < elevations.length; r++){
	    for (int c = 0; c < elevations[0].length; c++){
		ans += elevations[r][c] + " ";
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }

    public int calc(int seaLevel){
	int sum = 0;
	for (int r = 0; r < elevations.length; r++){
	    for (int c = 0; c < elevations[0].length; c++){
	        if (elevations[r][c] < seaLevel){
		    sum += seaLevel - elevations[r][c];
		}
	    }
	}
	return sum * 72 * 72;
    }

    public static void main(String[]args){
	USACO test = new USACO();
	test.print();
	test.stomp(1,4,4);
	test.print();
	test.stomp(1,1,10);
	test.print();
	System.out.println(test.calc(22));
    }
}
	

    
		    
	
    
