import java.util.*;

public class Calculator{
	
    public static double eval(String s){
	String[] data = s.split(" ");
//    System.out.println(Arrays.toString(data));
	LinkedList<Double> stack = new LinkedList<>();
	//double sum = 0;
	for (int i = 0; i< data.length; i++){
	    if(data[i].equals("+")){
		stack.push(stack.pop() + stack.pop());
	    }
	    else if(data[i].equals("-")){
            double sub = stack.pop();
		stack.push(stack.pop() - sub);
	    }
	    else if(data[i].equals("*")){
		stack.push(stack.pop() * stack.pop());
	    }
	    else if(data[i].equals("/")){
		double divisor = stack.pop();
		stack.push(stack.pop() / i);
	    }
	    else if(data[i].equals("%")){
		double divisor = stack.pop();
		stack.push(stack.pop() % i);
	    }
	    else{
		stack.push(Double.parseDouble(data[i]));
	    }	
//        System.out.println("i: " + i);
//        System.out.println("Stack: " + stack);
	}
	return stack.pop();
    }

    public static void main(String[]args){
        System.out.println(eval("10 2.0 +"));
        System.out.println(eval("11 3 - 4 + 2.5 *"));
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
