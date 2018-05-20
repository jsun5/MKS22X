import java.util.*;

public class Calculator{
	
    public static double eval(String s){
	String[] data = s.split(" ");
//    System.out.println(Arrays.toString(data));
	LinkedList<Double> stack = new LinkedList<>();
	//double sum = 0;
	for (String elem: data){
	    if(isOperator(elem)){
			stack.push(evaluator(elem, stack.pop(), stack.pop()));
		}
		else{
			stack.push(Double.parseDouble(elem));
		}
//        System.out.println("i: " + i);
//        System.out.println("Stack: " + stack);
	}
	return stack.pop();
    }
	
	private static boolean isOperator(String s){
		return s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("%");
    }
	
	private static double evaluator(String elem, double b, double a) {
		if (elem.equals("/")) {
			return a * 1.0 / b;
		}
		else if (elem.equals("-")) {
			return a - b;
		}
		else if (elem.equals("+")) {
			return a + b;
		}
		else if (elem.equals("*")) {
			return a * b;
		}
		else if (elem.equals("%")) {
			return a % b;
		}
		return a + b;
    }
	
    public static void main(String[]args){
		System.out.println(eval("4"));
	  	System.out.println(eval("+"));
        System.out.println(eval("10 2.0 +"));
        System.out.println(eval("11 3 - 4 + 2.5 *"));
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
