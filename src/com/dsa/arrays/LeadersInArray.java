package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array A of positive integers. Your task is to find the leaders in
 * the array. An element of array is leader if it is greater than or equal to
 * all the elements to its right side. The rightmost element is always a leader.
 * 
 * Example 1:
 * 
 * Input: n = 6 A[] = {16,17,4,3,5,2} Output: 17 5 2 Explanation: The first
 * leader is 17 as it is greater than all the elements to its right. Similarly,
 * the next leader is 5. The right most element is always a leader so it is also
 * included. Example 2:
 * 
 * Input: n = 5 A[] = {1,2,3,4,0} Output: 4 0 Explanation: 0 is the rightmost
 * element and 4 is the only element which is greater than all the elements to
 * its right
 */
public class LeadersInArray {

	// Method to find leaders in the array
	static ArrayList<Integer> leaders1(int arr[], int n) {
		ArrayList<Integer> result = new ArrayList<>(); // Initialize an ArrayList to store the leaders

		// Iterate over the array elements
		for (int i = 0; i < n; i++) {
			boolean isLeader = true; // Flag to check if the current element is a leader

			// Compare the current element with all the elements to its right
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					isLeader = false; // If any element on the right is greater, current element is not a leader
					break;
				}
			}
			if (isLeader) {
				result.add(arr[i]); // If the current element is a leader, add it to the result list
			}
		}
		return result; // Return the list of leaders
	}
	// Time complexity: O(n^2)

	static ArrayList<Integer> leaders2(int arr[], int n) {
		// ArrayList to store the leaders
		ArrayList<Integer> result = new ArrayList<>();

		// Adding the rightmost element as a leader initially
		result.add(arr[n - 1]);

		// Initializing the current maximum as the rightmost element
		int currentMax = arr[n - 1];

		// Iterating from the second last element to the first element
		for (int i = n - 2; i >= 0; i--) {
			// Checking if the current element is greater than or equal to the current
			// maximum
			if (arr[i] >= currentMax) {
				// Updating the current maximum
				currentMax = arr[i];
				// Adding the leader to the result list
				result.add(arr[i]);
			}
		}

		// Reversing the list to maintain the order
		Collections.reverse(result);

		// Returning the list of leaders
		return result;
	}

	// Time complexity: O(n)
	

	public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int n = A.length;

        // Testing the leaders method
        ArrayList<Integer> result = leaders2(A, n);

        // Displaying the expected output
        System.out.println("Expected output:");
        for (int val : result) {
            System.out.print(val + " "); // Expected Output: 17 5 2
        }
    }
}
