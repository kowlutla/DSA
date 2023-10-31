package com.dsa.bit_magic;

/**
 * Given an array of N integers, find the sum of the XOR of all pairs of numbers in
 * the array arr. In other words, select all possible pairs of i and j from 0 to
 * N-1 (i<j) and determine the sum of all (arr[i] xor arr[j]).
 */
public class SumOfXOROfAllPairs {
    // Method to find the sum of XOR of all pairs using nested loops
    public long sumXOR1(int arr[], int n) {
        long sum = 0;
        // Iterate through each pair and calculate the XOR
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += (arr[i] ^ arr[j]);
            }
        }
        return sum;
    }

    // Method to find the sum of XOR of all pairs using bit manipulation
    public long sumXOR(int arr[], int n) {
        long sum = 0;
        // Iterate through each bit position
        for (int i = 0; i < 32; i++) {
            long ones = 0, zeros = 0;
            // Count the number of 1s and 0s at the current bit position
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            // Add the product of ones, zeros, and 2^i to the sum
            sum += (ones * zeros * (1 << i));
        }
        return sum;
    }

    // Main method for testing sumXOR method
    public static void main(String[] args) {
        // Example input
        int[] arr = { 5, 9, 7 };
        int n = arr.length;

        // Create an instance of SumOfXOROfAllPairs class
        SumOfXOROfAllPairs sumOfXOROfAllPairs = new SumOfXOROfAllPairs();

        // Find the sum of XOR of all pairs using the sumXOR method
        long result = sumOfXOROfAllPairs.sumXOR(arr, n);

        // Print the result
        System.out.println("Sum of XOR of all pairs in the array: " + result);
    }
}
