package com.dsa.arrays;

/**
 * Given an array arr[] of N positive integers which can contain integers from 1
 * to P where elements can be repeated or can be absent from the array. Your
 * task is to count the frequency of all numbers from 1 to N. Make in-place
 * changes in arr[], such that arr[i] = frequency(i). Assume 1-based indexing.
 * Note: The elements greater than N in the array can be ignored for counting
 * and do modify the array in-place.
 */
public class FrequenciesOfLimitedRangeArrayElements {

	// Method to count the frequency of all numbers from 1 to N
	public static void frequencyCount1(int arr[], int N, int P) {
		// Create an array to store the counts
		int count[] = new int[N + 1];

		// Count the occurrences of each number in the input array
		for (int i = 0; i < N; i++) {
			if (arr[i] <= N) {
				count[arr[i]]++;
			}
		}

		// Modify the input array in-place to store the frequency of each number
		for (int i = 0; i < N; i++) {
			arr[i] = count[i + 1];
		}
	}

	// Alternative method to count the frequency of all numbers from 1 to N
	public static void frequencyCount(int arr[], int N, int P) {
		// Iterate through each element in the array
		for (int i = 0; i < N; i++) {
			// Calculate the value as the remainder of the division of arr[i] by (P + 1)
			int value = arr[i] % (P + 1);

			// If the value is less than or equal to N, update the array element at index
			// (value - 1)
			if (value <= N) {
				arr[value - 1] += P + 1;
			}
		}

		// Divide each element in the array by (P + 1) to obtain the frequency count
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / (P + 1);
		}
	}

	// Main method for testing the FrequenciesOfLimitedRangeArrayElements
	// functionality
	public static void main(String[] args) {
		// Example values for the array, N, and P
		int[] arr = { 2, 3, 2, 3, 5 };
		int N = 5;
		int P = 5;

		// Call the method to count the frequencies of numbers
		frequencyCount1(arr, N, P);

		// Print the modified array after updating with the frequencies
		System.out.println("Updated array with frequencies:");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
