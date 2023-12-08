package com.dsa.binarysearch;

/**
 * Given an array arr sorted in non-decreasing order and a number x, this class
 * provides a method to return the index of the lower bound of x.
 */
public class LowerBound {
	// Method to find the lower bound of x in the given sorted array arr
	public static int lowerBound(int[] arr, int n, int x) {
		
		// Calls the binary search method to find the lower bound of x
		return binarySearch(arr, 0, n - 1, x);
		
	}
	
	// Binary search method to find the lower bound of x in the array
	private static int binarySearch(int[] arr, int start, int end, int x) {
		
		int result = end + 1; // Initialize result as end + 1
		
		// Perform binary search until start is less than or equal to end
		while (start <= end) {
			int mid = start + (end - start) / 2; // Calculate the middle index
			
			// If the middle element is greater than or equal to x
			if (arr[mid] >= x) {
				result = mid; // Update result to current middle index
				end = mid - 1; // Move to the left half
			} else {
				start = mid + 1; // Move to the right half
			}
		}
		
		return result; // Return the lower bound index of x
		
	}
	
	// Main method for testing purposes
	public static void main(String[] args) {
		
		int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
		int x = 6;
		int n = arr.length;
		
		// Find the lower bound of x in the array arr
		int lowerBoundIndex = lowerBound(arr, n, x);
		
		// Display the lower bound index of x
		System.out.println("Lower Bound of " + x + " is at index: " + lowerBoundIndex);
		
	}
}
