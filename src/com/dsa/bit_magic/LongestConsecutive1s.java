package com.dsa.bit_magic;

/**
 * Given a number N. Find the length of the longest consecutive 1s in its binary
 * representation.
 */
public class LongestConsecutive1s {

    /*
     * Function to calculate the longest consecutive ones N: given input to
     * calculate the longest consecutive ones
     */
    public static int maxConsecutiveOnes1(int n) {
        // Initialize variables to keep track of the maximum consecutive ones and current count
        int maxCons = 0;
        int count = 0;
        // Iterate until n is greater than 0
        while (n > 0) {
            // If the rightmost bit is 1, increment the count and update maxCons
            if ((n & 1) == 1) {
                count++;
                maxCons = Math.max(maxCons, count);
            } else {
                // If the rightmost bit is 0, reset the count
                count = 0;
            }
            // Right shift n by 1
            n = n >> 1;
        }
        // Return the maximum consecutive ones
        return maxCons;

    }

    // Function to find the length of the longest consecutive 1s in binary representation using bitwise operations
    public static int maxConsecutiveOnes(int n) {
        // Initialize a variable to count the consecutive ones
        int count = 0;
        // Iterate until n is greater than 0
        while (n > 0) {
            // Clear the rightmost set bit of n and increment the count
            n = n & (n >> 1);
            count++;
        }
        // Return the length of the longest consecutive 1s
        return count;
    }

    // Main method to test the maxConsecutiveOnes functionality
    public static void main(String[] args) {
        // Example usage
        int n = 14;
        System.out.println("Using maxConsecutiveOnes1: " + maxConsecutiveOnes1(n));
        System.out.println("Using maxConsecutiveOnes: " + maxConsecutiveOnes(n));
    }
}
