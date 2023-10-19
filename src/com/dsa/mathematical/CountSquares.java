package com.dsa.mathematical;

/**
 * Consider a sample space S consisting of all perfect squares starting from 1,
 * 4, 9 and so on. You are given a number N, you have to output the number of
 * integers less than N in the sample space S.
 */
public class CountSquares {

    /**
     * This method counts the number of perfect squares less than N.
     * 
     * @param N The upper limit of the range.
     * @return The count of perfect squares less than N.
     */
    static int countSquares(int N) {
        // If N is less than or equal to 1, return 0 as there are no perfect squares less than 1
        if (N <= 1) {
            return 0;
        }

        // Initialize the count of perfect squares to 1, as 1 is always a perfect square less than any given N
        int count = 1;

        // Iterate from 2 onward to find the number of perfect squares less than N
        for (int i = 2; i * i < N; i++) {
            // Increment the count for each perfect square found
            count++;
        }

        // Return the count of perfect squares less than N
        return count;
    }

    // Main method for testing the countSquares method
    public static void main(String[] args) {
        // Test cases for the countSquares method
        int N1 = 5; // Expected output: 2
        int N2 = 16; // Expected output: 3
        int N3 = 1; // Expected output: 0

        // Testing countSquares method
        System.out.println("Count of squares less than " + N1 + ": " + countSquares(N1));
        System.out.println("Count of squares less than " + N2 + ": " + countSquares(N2));
        System.out.println("Count of squares less than " + N3 + ": " + countSquares(N3));

        // Expected output for the provided test cases:
        // Count of squares less than 5: 2
        // Count of squares less than 16: 3
        // Count of squares less than 1: 0
    }
}
