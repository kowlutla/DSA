package com.dsa.arrays;

/**
 * Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S 
 * and return the left and right index(1-based indexing) of that subarray.

	In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
	
	Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists 
return an array consisting of element -1.
 */
import java.util.ArrayList;

public class SubarrayWithGivenSum {

	// Function to find a continuous sub-array which adds up to a given number using brute force
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
	    // Initialize an ArrayList to store the resulting indexes
	    ArrayList<Integer> result = new ArrayList<>();

	    // Traverse through the array elements
	    for (int i = 0; i < n; i++) {
	        int sum = 0;

	        // Compute the sum of subarrays starting at index i
	        for (int j = i; j < n; j++) {
	            sum += arr[j];

	            // Check if the sum is equal to the given target sum 's'
	            if (sum == s) {
	                // Add the left and right indexes (1-based indexing) of the subarray to the result
	                result.add(i + 1);
	                result.add(j + 1);
	                return result; // Return the resulting ArrayList and exit the function
	            }
	        }
	    }
	    // If no such subarray is found, add -1 to the result and return it
	    result.add(-1);
	    return result;
	}

	// Function to find a continuous sub-array which adds up to a given number using two pointers(Optimized)
	static ArrayList<Integer> subarraySum1(int[] arr, int n, int s) {
	    // Initialize an ArrayList to store the resulting indexes
	    ArrayList<Integer> result = new ArrayList<>();
	    int left = 0; // Initialize the left pointer
	    int right = 0; // Initialize the right pointer
	    int sum = 0; // Initialize the sum

	    // Check if the target sum 's' is 0
	    if (s == 0) {
	        result.add(-1);
	        return result;
	    }

	    // Use the two-pointer approach to find the subarray
	    while (right < n) {
	        sum += arr[right]; // Add the element at the right pointer to the sum

	        // Adjust the window to maintain the sum condition
	        while (sum > s) {
	            sum -= arr[left];
	            left++;
	        }

	        // Check if the sum is equal to the given target sum 's'
	        if (sum == s) {
	            // Add the left and right indexes (1-based indexing) of the subarray to the result
	            result.add(left + 1);
	            result.add(right + 1);
	            return result; // Return the resulting ArrayList and exit the function
	        }

	        right++; // Increment the right pointer
	    }
	    // If no such subarray is found, add -1 to the result and return it
	    result.add(-1);
	    return result;
	}

	public static void main(String[] args) {
        // Example 1
        int[] A1 = {1, 2, 3, 7, 5};
        int N1 = 5;
        int S1 = 12;
        System.out.println("Output for Example 1:");
        System.out.println(subarraySum1(A1, N1, S1)); // Expected output: [2, 4]

        // Example 2
        int[] A2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N2 = 10;
        int S2 = 15;
        System.out.println("Output for Example 2:");
        System.out.println(subarraySum1(A2, N2, S2)); // Expected output: [1, 5]
    }

}
