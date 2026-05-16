public class FibonacciApp {

    public static void main(String[] args) {

        int num = 10;

        System.out.println("Fibonacci number is: " + fibonacci(num));

    }

    public static int fibonacci(int n) {

        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}