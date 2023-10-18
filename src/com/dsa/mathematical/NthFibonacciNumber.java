package com.dsa.mathematical;

/**
 * Given a positive integer n, find the nth fibonacci number. Since the answer
 * can be very large, return the answer modulo 1000000007.
 */
public class NthFibonacciNumber {

    /**
     * This method finds the nth Fibonacci number.
     * @param n The position of the Fibonacci number to be found.
     * @return The nth Fibonacci number modulo 1000000007.
     */
    static int nthFibonacci(int n) {
        int mod = 1000000007; // Set the modulo value
        if (n == 0) {
            return 0; // Return 0 if the position is 0
        }

        if (n == 1) {
            return 1; // Return 1 if the position is 1
        }

        int first = 0; // Initialize the first Fibonacci number
        int second = 1; // Initialize the second Fibonacci number

        for (int i = 2; i <= n; i++) {
            int sum = (first + second) % mod; // Calculate the sum of the last two Fibonacci numbers
            first = second; // Update the first Fibonacci number
            second = sum; // Update the second Fibonacci number
        }

        return second; // Return the nth Fibonacci number modulo 1000000007
    }

    /**
     * The main method for testing the nthFibonacci method.
     */
    public static void main(String[] args) {
        // Test the nthFibonacci method with different inputs
        int position1 = 5; // Expected output: 5
        int position2 = 8; // Expected output: 21

        // Testing nthFibonacci method
        System.out.println("The Fibonacci number at position " + position1 + " is: " + nthFibonacci(position1));
        System.out.println("The Fibonacci number at position " + position2 + " is: " + nthFibonacci(position2));

        // Expected output for the provided test cases:
        // The Fibonacci number at position 5 is: 5
        // The Fibonacci number at position 8 is: 21
    }
}
