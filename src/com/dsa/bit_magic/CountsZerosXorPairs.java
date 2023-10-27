package com.dsa.bit_magic;

import java.util.Arrays;

/**
 * Given an array A[] of size N. Find the number of pairs (i, j) such that Ai
 * XOR Aj = 0, and 1 ≤ i < j ≤ N.
 */
public class CountsZerosXorPairs {

    // Method to calculate the number of pairs (i, j) such that Ai XOR Aj = 0
    public static long calculate(int arr[], int n) {
        // Sort the array in ascending order
        Arrays.sort(arr);

        // Initialize the result variable
        long result = 0;

        // Initialize a variable to keep track of the count of occurrences
        long count = 1;

        // Iterate through the array to check for XOR pairs
        for (int i = 1; i < n; i++) {
            // If the current element is the same as the previous one, increment the count
            if (arr[i] == arr[i - 1]) {
                count++;
            } 
            // If the current element is different, update the result with the count of occurrences
            else {
                result += (count * (count - 1)) / 2;
                count = 1;
            }
        }

        // Add the count of remaining occurrences to the result
        return result + (count * (count - 1)) / 2;
    }

    // Main method for testing the calculate method
    public static void main(String[] args) {
        // Example input array
        int[] arr = { 3, 2, 1, 2, 2, 3 };

        // Calculate the result using the calculate method
        long result = calculate(arr, arr.length);

        // Print the result
        System.out.println("Number of pairs such that Ai XOR Aj = 0: " + result);
    }
}
