package com.dsa.bit_magic;

/**
 * Given a positive integer N, print count of set bits in it.
 */
public class NumberOfSetBits {

    // Function to count the set bits in the integer using modulo operation
    static int setBits1(int n) {
        // Initialize count to 0
        int count = 0;
        // Iterate until n is greater than 0
        while (n > 0) {
            // Add the rightmost bit to the count
            count += (n % 2);
            // Right shift n by 1
            n >>= 1;
        }
        // Return the total count of set bits
        return count;
    }

    // Function to count the set bits in the integer using bitwise AND operation
    static int setBits(int n) {
        // Initialize count to 0
        int count = 0;
        // Iterate until n is greater than 0
        while (n > 0) {
            // Clear the rightmost set bit of n and increment the count
            n = n & (n - 1);
            count++;
        }
        // Return the total count of set bits
        return count;
    }

    // Main method to test the setBits functionality
    public static void main(String[] args) {
        // Example usage
        int n = 25;
        System.out.println("Using setBits1: " + setBits1(n));
        System.out.println("Using setBits: " + setBits(n));
    }
}
