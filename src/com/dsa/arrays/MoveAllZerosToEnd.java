package com.dsa.arrays;

/**
 * Given an array arr[] of n positive integers. Push all the zeros of the given
 * array to the right end of the array while maintaining the order of non-zero
 * elements. Do the mentioned change in the array in-place.
 */
public class MoveAllZerosToEnd {

	// Method to move all zeros to the end of the array
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
		int[] arr = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
		int n = arr.length;

		// Print the original array
		System.out.println("Original Array:");
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();

		// Move all zeros to the end
		pushZerosToEnd(arr, n);

		// Print the modified array
		System.out.println("\nArray after moving zeros to the end:");
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}
}
