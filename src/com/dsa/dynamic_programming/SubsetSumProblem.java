/**
 * Given an array of non-negative integers, and a value sum, 
 * determine if there is a subset of the given set with sum equal to given sum. 
 * 
 * 	Example 1:
	Input:
	N = 6
	arr[] = {3, 34, 4, 12, 5, 2}
	sum = 9
	Output: 1 
	Explanation: Here there exists a subset with
	sum = 9, 4+3+2 = 9.

	Example 2:
	Input:
	N = 6
	arr[] = {3, 34, 4, 12, 5, 2}
	sum = 30
	Output: 0 
	Explanation: There is no subset with sum 30.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class SubsetSumProblem {

	// Recursive approach to check if there is a subset with the given sum
	static boolean isSubSetSumRecursion(int N, int arr[], int sum) {
		return isSubSetSumRecursionUtil(N - 1, arr, sum);
	}

	// Helper function for recursive approach
	private static boolean isSubSetSumRecursionUtil(int index, int[] arr,
			int target) {
		if (index < 0 || target < 0) {
			return false;
		}
		if (target == 0) {
			return true;
		}

		boolean take = isSubSetSumRecursionUtil(index -1, arr,
				target - arr[index]);
		boolean notTake = isSubSetSumRecursionUtil(index - 1, arr, target);

		return take || notTake;
	}

	// Memoization approach to check if there is a subset with the given sum
	static Boolean isSubsetSumMemoization(int N, int arr[], int sum) {
		int[][] dp = new int[N][sum + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return isSubsetSumMemoization(N - 1, sum, arr, dp);
	}

	// Helper function for memoization approach
	static boolean isSubsetSumMemoization(int index, int target, int arr[],
			int[][] dp) {
		if (target < 0) {
			return false;
		}
		if (target == 0) {
			return true;
		}

		if (index == 0) {
			return target == arr[index];
		}

		if (dp[index][target] != -1) {
			return dp[index][target] == 1;
		}

		boolean take = isSubsetSumMemoization(index - 1, target - arr[index],
				arr, dp);
		boolean notTake = isSubsetSumMemoization(index - 1, target, arr, dp);

		dp[index][target] = (take || notTake) ? 1 : 0;
		return take || notTake;
	}

	// Tabulation approach to check if there is a subset with the given sum
	static boolean isSubSetSumTabulation(int N, int[] arr, int sum) {
		boolean dp[][] = new boolean[N][sum + 1];

		// Initialize the first row of the DP table
		for (int i = 0; i < N; i++) {
			dp[i][0] = true;
		}

		// Initialize the first column of the DP table
		if (arr[0] <= sum) {
			dp[0][arr[0]] = true;
		}

		for (int index = 1; index < N; index++) {
			for (int target = 1; target <= sum; target++) {
				boolean notTake = dp[index - 1][target];
				boolean take = false;
				if (arr[index] <= target) {
					take = dp[index - 1][target - arr[index]];
				}

				dp[index][target] = take || notTake;
			}
		}

		return dp[N - 1][sum];
	}

	// Space-optimized Tabulation approach to check if there is a subset with
	// the given sum
	static boolean isSubSetSumSpaceOptimization(int N, int[] arr, int sum) {
		boolean[] prev = new boolean[sum + 1];
		prev[0] = true;

		if (arr[0] <= sum) {
			prev[arr[0]] = true;
		}

		for (int index = 1; index < N; index++) {
			boolean[] current = new boolean[sum + 1];
			current[0] = true;
			for (int target = 1; target <= sum; target++) {
				boolean notTake = prev[target];
				boolean take = false;
				if (arr[index] <= target) {
					take = prev[target - arr[index]];
				}

				current[target] = take || notTake;
			}

			prev = current;
		}
		return prev[sum];
	}

	// Main method for testing
	public static void main(String[] args) {
		int[] arr = {3, 34, 4, 12, 5, 2};
		int sum = 9;

		System.out.println("Recursive: " + isSubSetSumRecursion(arr.length, arr, sum));
		System.out.println("Memoization: " + isSubsetSumMemoization(arr.length, arr, sum));
		System.out.println("Tabulation: " + isSubSetSumTabulation(arr.length, arr, sum));
		System.out.println("Space Optimization: "+ isSubSetSumSpaceOptimization(arr.length, arr, sum));
	}
	
	/**
	 * 	Recursive: true
		Memoization: true
		Tabulation: true
		Space Optimization: true
	 */
}
