/**
 *Problem Statement: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
 *
 * 	Example 1:
	Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
	Output: 4
	Explanation: 3 is occurring 4 times in 
	the given array so it is our answer.
	
	Example 2:
	Input: N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
	Output: 5
	Explanation: 2 is occurring 5 times in the given array so it is our answer.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class CountOccurrencesInSortedArray {
	public static int count(int arr[], int n, int x) {
		// Find the index of the first occurrence of x in the array
		int first = binarySearch(arr, 0, n - 1, x, true);

		// If x is not found, return 0
		if (first == -1) {
			return 0;
		}

		// Find the index of the last occurrence of x in the array
		int last = binarySearch(arr, 0, n - 1, x, false);

		// Return the count of occurrences of x in the array
		return last - first + 1;
	}

	// Binary search method to find the first or last occurrence of x in the array
	private static int binarySearch(int arr[], int start, int end, int x,
			boolean isFirst) {
		int result = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			// If x is found
			if (arr[mid] == x) {
				result = mid;

				// Update search space based on isFirst flag
				if (isFirst) {
					end = mid - 1; // Search towards the left for the first occurrence
				} else {
					start = mid + 1; // Search towards the right for the last occurrence
				}
			} else if (arr[mid] > x) {
				end = mid - 1; // Discard the right half
			} else {
				start = mid + 1; // Discard the left half
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 5, 6};
        int target = 4;

        int occurrences = count(arr, arr.length, target);
        System.out.println("Number of occurrences of " + target + ": " + occurrences);
    }
}
