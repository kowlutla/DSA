package com.dsa.recursion;

/**
 * You are given a number n. You need to find the count of digits in n.
 */
public class CountDigitsInNumber {
    
    // Recursive method to count the number of digits in a number
    public static int countDigits(int n) {
        // Base case: if n is less than 10, it has 1 digit
        if (n < 10) {
            return 1;
        }
        // Recursively count the digits in n / 10 and add 1 for the last digit
        return 1 + countDigits(n / 10);
    }

    // Main method for testing the countDigits method
    public static void main(String[] args) {
        // Example input n
        int n = 12345;
        // Find the count of digits in the number using the countDigits method
        int count = countDigits(n);
        // Print the count of digits
        System.out.println("Number of digits in " + n + " is: " + count);
    }
}
