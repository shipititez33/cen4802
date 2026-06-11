package edu.seminolestate.cen4802;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FibonacciAppTest {

    @Test
    @DisplayName("Fibonacci term 0 should return 0")
    void fibonacciTermZeroReturnsZero() {
        assertEquals(0, FibonacciApp.fibonacci(0));
    }

    @Test
    @DisplayName("Fibonacci term 1 should return 1")
    void fibonacciTermOneReturnsOne() {
        assertEquals(1, FibonacciApp.fibonacci(1));
    }

    @Test
    @DisplayName("Fibonacci term 10 should return 55")
    void fibonacciTermTenReturnsFiftyFive() {
        assertEquals(55, FibonacciApp.fibonacci(10));
    }
}