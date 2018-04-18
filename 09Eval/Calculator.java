import java.util.*;

public class Calculator{
	
    public static double eval(String s){
	String[] data = s.split(" ");
	LinkedList<Double> stack = new LinkedList<>();
	//double sum = 0;
	for (int i = 0; i< data.length; i++){
	    if(data[i].equals("+")){
		stack.push(stack.pop() + stack.pop());
	    }
	    if(data[i].equals("-")){
		stack.push(stack.pop() - stack.pop());
	    }
	    if(data[i].equals("*")){
		stack.push(stack.pop() * stack.pop());
	    }
	    if(data[i].equals("/")){
		double divisor = stack.pop();
		stack.push(stack.pop() / i);
	    }
	    if(data[i].equals("%")){
		double divisor = stack.pop();
		stack.push(stack.pop() % i);
	    }
	    else{
		stack.push(Double.parseDouble(data[i]));
	    }	
	}
	return stack.pop();
    }

    public static void main(String[]args){
	System.out.println(eval("10 2.0 +"));
    }
}
