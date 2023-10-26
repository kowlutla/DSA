package com.dsa.bit_magic;

/**
 * We define f (X, Y) as the number of different corresponding bits in the binary
 * representation of X and Y. For example, f (2, 7) = 2, since the binary
 * representation of 2 and 7 are 010 and 111, respectively. The first and the
 * third bit differ, so f (2, 7) = 2.
 * 
 * You are given an array A of N integers, A1, A2, ..., AN. Find the sum of f(Ai, Aj)
 * for all ordered pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo
 * 10^9+7.
 */
public class BitDifferenceOfArrayElements {

    // Method to count the sum of f(Ai, Aj) for all ordered pairs
    static int countBits1(int N, long A[]) {
        int mod = 1000000007; // modulo value
        long result = 0; // initialize the result to 0
        // Iterate through all ordered pairs and count the bits
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long xor = A[i] ^ A[j]; // XOR the elements
                int count = 0;
                // Count the bits that differ in the binary representation
                while (xor > 0) {
                    count++;
                    xor = xor & (xor - 1);
                }
                // Update the result with the count and modulo
                result = (result + count) % mod;
            }
        }
        return (int) result; // return the final result
    }

    // Efficient method to count the sum of f(Ai, Aj) for all ordered pairs
    static int countBits(int N, long A[]) {
        int mod = 1000000007; // modulo value
        long result = 0; // initialize the result to 0
        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            long ones = 0;
            long zeros = 0;
            // Count the number of set bits and unset bits at the ith position of every number in A
            for (int j = 0; j < N; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            // Add the number of possible combinations to the result
            result = (result + (ones * zeros * 2) % mod) % mod;
        }
        return (int) result; // return the final result
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example usage
        long[] array = { 1, 2, 3 }; // Example array
        int size = array.length; // Size of the array
        // Testing the two methods
        System.out.println("Using countBits1 method: " + countBits1(size, array));
        System.out.println("Using countBits method: " + countBits(size, array));
    }
}
