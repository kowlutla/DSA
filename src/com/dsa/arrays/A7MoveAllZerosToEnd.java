package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array arr[] of n positive integers. Push all the zeros of the given
 * array to the right end of the array while maintaining the order of non-zero
 * elements. Do the mentioned change in the array in-place.
 */
public class A7MoveAllZerosToEnd {

    // Method to move all zeros to the end of the array
    // Parameters:
    // - arr: the input integer array
    // Returns: void (the array is modified in-place)
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(n) - additional space used to store non-zero elements
    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int[] nonZeros = new int[n]; // Array to store non-zero elements
        int index = 0; // Index to track non-zero elements

        // Iterate through the array and store non-zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                nonZeros[index++] = arr[i];
            }
        }

        // Copy non-zero elements back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = nonZeros[i];
        }
    }

    // Method to move all zeros to the end of the array
    // Parameters:
    // - arr: the input integer array
    // - n: the number of elements in the array
    // Returns: void (the array is modified in-place)
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity as no additional space is used
    static void pushZerosToEnd(int[] arr, int n) {
        // Initialize an index for non-zero elements
        int index = 0;

        // Iterate through the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Fill the remaining positions with zeros
        for (int i = index; i < n; i++) {
            arr[i] = 0;
        }
    }

    // Main method for testing pushZerosToEnd method
    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        int n = arr.length;

        // Print the original array
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        // Move all zeros to the end
        pushZerosToEnd(arr, n);

        // Print the modified array
        System.out.println("\nArray after moving zeros to the end:");
        System.out.println(Arrays.toString(arr));
        
		arr = new int[]{1, 3, 8, 6, 0, 0, 2, 7, 0, 6, 0};

		// Print the original array
		System.out.println("\n\nOriginal Array:");
		System.out.println(Arrays.toString(arr));
		moveZeroes(arr);
		// Print the modified array
		System.out.println("\nArray after moving zeros to the end:");
		System.out.println(Arrays.toString(arr));
    }
}
