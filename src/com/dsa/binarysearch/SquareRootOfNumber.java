/**
	Problem Statement: You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of ‘sqrt(n)’.
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SquareRootOfNumber {

    // Main method to test the sqrtN function
    public static void main(String[] args) {
        long number = 16; // Test number
        int result = sqrtN(number);
        System.out.println("Square root of " + number + " is: " + result); // Expected Output: 4
    }

    // Method to find the integer square root of a number
    public static int sqrtN(long N) {
        // Initialize low and high for binary search
        long low = 1, high = N;

        // Perform binary search to find the square root
        while (low <= high) {
            // Calculate the middle value
            long mid = low + (high - low) / 2;
            
            // Check if mid * mid is less than or equal to N
            if (mid * mid <= N) {
                low = mid + 1; // If true, move low pointer ahead
            } else {
                high = mid - 1; // If false, move high pointer behind
            }
        }

        return (int) high; // Return the integer part of the square root
    }
}
