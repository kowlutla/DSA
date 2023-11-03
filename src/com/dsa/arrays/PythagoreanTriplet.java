package com.dsa.arrays;

import java.util.Arrays;

/**
 * Given an array arr of n integers, write a function that returns true if there
 * is a triplet (a, b, c) from the array (where a, b, and c are on different
 * indexes) that satisfies a2 + b2 = c2, otherwise return false.
 */
public class PythagoreanTriplet {

	// Method to check for a Pythagorean triplet using sorting
	boolean checkTriplet(int[] arr, int n) {
		// Square each element in the array
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}

		// Sort the array
		Arrays.sort(arr);

		// Iterate through the array to find the triplet
		for (int i = n - 1; i > 1; i--) {
			int left = 0;
			int right = i - 1;
			// Use two pointers approach to find the triplet
			while (left < right) {
				// Check if the sum of the squares of left and right is equal to the square of
				// current element
				if (arr[left] + arr[right] == arr[i])
					return true;
				// If the sum is less than the square of the current element, move the left
				// pointer
				if (arr[left] + arr[right] < arr[i])
					left++;
				// If the sum is greater, move the right pointer
				else
					right--;
			}
		}
		// Return false if no such triplet is found
		return false;
	}

	// Method to check for a Pythagorean triplet without sorting
	boolean checkTriplet1(int[] arr, int n) {
		// Iterate through each element in the array
		for (int i = 0; i < n; i++) {
			// Compute the square of the current element
			int a = arr[i] * arr[i];
			// Iterate through the array to find other elements
			for (int j = 0; j < n; j++) {
				// Ensure the current element is distinct from the first one
				if (i != j) {
					// Compute the square of the second element
					int b = arr[j] * arr[j];
					// Iterate through the array to find the third element
					for (int k = 0; k < n; k++) {
						// Ensure the third element is distinct from the first two
						if (k != j && k != i) {
							// Compute the square of the third element
							int c = arr[k] * arr[k];
							// Check if the Pythagorean condition is satisfied
							if (c == a + b) {
								return true;
							}
						}
					}
				}
			}
		}
		// Return false if no such triplet is found
		return false;
	}

	// Returns true if there is Pythagorean triplet in ar[0..n-1]
	boolean checkTriplet2(int ar[], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					// Calculate square of array elements
					int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

					if (x == y + z || y == x + z || z == x + y)
						return true;
				}
			}
		}

		// If we reach here, no triplet found
		return false;
	}

	// Main method to test the Pythagorean triplet functions
	public static void main(String[] args) {
		PythagoreanTriplet tripletChecker = new PythagoreanTriplet();
		int[] arr = { 3, 1, 4, 6, 5 };
		int n = arr.length;
		System.out.println("Triplet exists without sorting1: " + tripletChecker.checkTriplet1(arr, n));
		System.out.println("Triplet exists without sorting2: " + tripletChecker.checkTriplet2(arr, n));
		System.out.println("Triplet exists using sorting: " + tripletChecker.checkTriplet(arr, n));
	}
}
