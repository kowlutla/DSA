package com.dsa.recursion;

/**
 * You are given a number n. You need to find the sum of digits of n.
 */
public class SumOfDigitsOfNumber {
    
    // Recursive method to find the sum of digits of a number
    public static int sumOfDigits(int n) {
        // Base case: if n becomes 0, stop the recursion
        if (n == 0) {
            return 0;
        }
        // Recursively find the sum of digits of n / 10 and add the last digit to it
        return n % 10 + sumOfDigits(n / 10);
    }

    // Main method for testing the sumOfDigits method
    public static void main(String[] args) {
        // Example input n
        int n = 12345;
        // Find the sum of digits of the number using the sumOfDigits method
        int sum = sumOfDigits(n);
        // Print the sum of digits
        System.out.println("Sum of digits of " + n + " is: " + sum);
    }
}
