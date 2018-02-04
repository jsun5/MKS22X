public class Recursion{
    
    public int fact(int n){
        if (n < 0) {
            throw new IllegalArgumentException("please choose a number larger than 0");
        }
        if (n == 0){
            return 1;
        }
        return n * fact(n - 1);
    }
    
    public int fib(int n){
        if (n < 0) {
            throw new IllegalArgumentException("please choose a number larger than 0");
        }
        if (n == 0){
            return 0;
        }
        return fibber(n, 1, 0);
    }
    
    public int fibber(int n, int sum, int sumBefore){
        if (n == 1){
            return sum;
        }
        return fibber (n - 1, sum + sumBefore, sum);
    }
        
    public static void main(String[]args){
        Recursion test = new Recursion();
        
//        System.out.println(test.fact(-1));
        System.out.println(test.fact(0));
        System.out.println(test.fact(1));
        System.out.println(test.fact(5));
        System.out.println(test.fact(10));
        System.out.println(test.fib(0));
        System.out.println(test.fib(1));
        System.out.println(test.fib(2));
        System.out.println(test.fib(3));
        System.out.println(test.fib(4));
        System.out.println(test.fib(5));
        System.out.println(test.fib(6));
        System.out.println(test.fib(7));
        System.out.println(test.fib(8));
        System.out.println(test.fib(9));
    }
}