package edu.seminolestate.cen4802;
public class FibonacciApp {

    public static void main(String[] args) {
        int term = 10;
        int result = fibonacci(term);

        System.out.println("Jenkins CI build verified: the " + term + "th term of the Fibonacci sequence is " + result + ".");
    }

    /**
     * Calculates the nth term in the Fibonacci sequence using recursion.
     * @param n the Fibonacci term number
     * @return the calculated Fibonacci value 
     */
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}