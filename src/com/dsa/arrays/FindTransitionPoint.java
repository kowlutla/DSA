package com.dsa.arrays;

/**
 * Given a sorted array containing only 0s and 1s, find the transition point,
 * i.e., the first index where 1 was observed, and before that, only 0 was
 * observed
 */
public class FindTransitionPoint {

	// First implementation to find the transition point
	static int transitionPoint1(int arr[], int n) {
		// Iterate through the array
		for (int i = 0; i < n; i++) {
			// Check if the element is 1
			if (arr[i] == 1) {
				return i; // Return the index if 1 is found
			}
		}
		return -1; // Return -1 if no 1 is found
	}

	// Second implementation using binary search to find the transition point
	static int transitionPoint(int arr[], int n) {
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2; // Compute the middle index
			// Check if the element at the middle is 0
			if (arr[mid] == 0) {
				left = mid + 1; // Continue the search in the right half
			} else {
				// Check if the element at the middle is 1 and its previous element is 0 or if
				// the current index is the first element
				if (mid == 0 || arr[mid - 1] == 0) {
					return mid; // Return the index if 1 is found at the transition point
				}
				right = mid - 1; // Continue the search in the left half
			}
		}
		return -1; // Return -1 if no transition point is found
	}

	public static void main(String[] args) {
		// Example usage of the FindTransitionPoint class
		int[] arr = { 0, 0, 0, 0, 1, 1, 1, 1, 1 }; // Sample input array
		int n = arr.length;

		// Test the transitionPoint1 method
		System.out.println("Transition point using linear search: " + FindTransitionPoint.transitionPoint1(arr, n));

		// Test the transitionPoint method
		System.out.println("Transition point using binary search: " + FindTransitionPoint.transitionPoint(arr, n));
	}
}
