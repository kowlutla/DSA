/**
 * 	Given an array arr[] of size N, check if it can be partitioned into 
 * 	two parts such that the sum of elements in both parts is the same.
	
	Example 1:
	Input: N = 4
	arr = {1, 5, 11, 5}
	Output: YES
	Explanation: 
	The two parts are {1, 5, 5} and {11}.

	Example 2:
	Input: N = 3
	arr = {1, 3, 5}
	Output: NO
	Explanation: This array can never be 
	partitioned into two such parts.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class PartitionEqualSubsetSum {

	// Method to check if it is possible to partition the array into two subsets
	// with equal sum
	static int equalPartition(int N, int arr[]) {
		// Calculate the total sum of the array
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}

		// If the total sum is odd, it cannot be partitioned into two subsets
		// with equal sum
		if (sum % 2 == 1) {
			return 0;
		}

		// If it is possible to find a subset with sum equal to sum/2, return 1;
		// otherwise, return 0
		if (isSubSetSum(N, arr, sum / 2)) {
			return 1;
		}
		return 0;
	}

	// Method to check if it is possible to find a subset with the given sum
	static boolean isSubSetSum(int N, int[] arr, int sum) {
		// Create a DP table to store intermediate results
		boolean dp[][] = new boolean[N][sum + 1];

		// Initialize the first row of the DP table
		for (int i = 0; i < N; i++) {
			dp[i][0] = true;
		}

		// Initialize the first column of the DP table
		if (arr[0] <= sum) {
			dp[0][arr[0]] = true;
		}

		// Iterate through the elements and possible target sums
		for (int index = 1; index < N; index++) {
			for (int target = 1; target <= sum; target++) {
				// Calculate whether to take or not take the current element to
				// achieve the target sum
				boolean notTake = dp[index - 1][target];
				boolean take = false;
				if (arr[index] <= target) {
					take = dp[index - 1][target - arr[index]];
				}

				// Update the DP table with the result
				dp[index][target] = take || notTake;
			}
		}

		// Return the result for the last element and target sum
		return dp[N - 1][sum];
	}

	// Main method to test and demonstrate the functionality
	public static void main(String[] args) {
		// Example array
		int[] arr = {1, 5, 11, 5};

		// Get the length of the array
		int N = arr.length;

		// Check if it is possible to partition the array into two subsets with
		// equal sum
		int result = equalPartition(N, arr);

		// Print the result
		System.out.println("Possible to partition? " + (result == 1));
	}
}
