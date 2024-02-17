/**
 * 	Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
 	The efficient way is the one that involves the least number of multiplications.
	
	The dimensions of the matrices are given in an array arr[] of size N 
	(such that N = number of matrices + 1) where the ith matrix has the dimensions 
	(arr[i-1] x arr[i]).
	
	Example 1:
	Input: N = 5
	arr = {40, 20, 30, 10, 30}
	Output: 26000
	Explanation: There are 4 matrices of dimension 
	40x20, 20x30, 30x10, 10x30. Say the matrices are 
	named as A, B, C, D. Out of all possible combinations,
	the most efficient way is (A*(B*C))*D. 
	The number of operations are -
	20*30*10 + 40*20*10 + 40*10*30 = 26000.
	
	Example 2:
	Input: N = 4
	arr = {10, 30, 5, 60}
	Output: 4500
	Explanation: The matrices have dimensions 
	10*30, 30*5, 5*60. Say the matrices are A, B 
	and C. Out of all possible combinations,the
	most efficient way is (A*B)*C. The 
	number of multiplications are -
	10*30*5 + 10*5*60 = 4500.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class DP48And49MatrixChainMultiplication {

	// Recursive function to find the minimum number of multiplications needed
	// for matrix chain multiplication
	public static int matrixMultiplicationRecursion(int N, int arr[]) {
		return matrixMultiplicationRecursion(arr, 1, N - 1);
	}

	private static int matrixMultiplicationRecursion(int[] arr, int i, int j) {
		// Base case: If there is only one matrix, no multiplication needed
		if (i == j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		// Iterate through possible partition points and calculate the minimum
		// number of multiplications
		for (int k = i; k < j; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] // Cost of multiplication of two matrices
					+ matrixMultiplicationRecursion(arr, i, k) // Cost of left part
					+ matrixMultiplicationRecursion(arr, k + 1, j); // Cost of right part
			min = Math.min(min, steps); // Update the minimum
		}
		return min;
	}

	// Function to find the minimum number of multiplications using memoization
	public static int matrixMultiplicationMemoization(int N, int arr[]) {
		int dp[][] = new int[N][N];
		// Initialize the memoization table with -1
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		return matrixMultiplicationMemoization(arr, 1, N - 1, dp);
	}

	private static int matrixMultiplicationMemoization(int[] arr, int i, int j, int[][] dp) {
		// Base case: If there is only one matrix, no multiplication needed
		if (i == j) {
			return 0;
		}

		// If the value is already computed, return it from the table
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;
		// Iterate through possible partition points and calculate the minimum
		// number of multiplications
		for (int k = i; k < j; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] // Cost of multiplication of two matrices
					+ matrixMultiplicationMemoization(arr, i, k, dp) // Cost of left part
					+ matrixMultiplicationMemoization(arr, k + 1, j, dp); // Cost of right part
			min = Math.min(min, steps); // Update the minimum
		}
		// Store the computed value in the memoization table
		return dp[i][j] = min;
	}

	// Function to find the minimum number of multiplications using tabulation
	public static int matrixMultiplicationTabulation(int n, int[] arr) {
		int[][] dp = new int[n][n];

		// Iterate through all possible subproblems
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int min = Integer.MAX_VALUE;
				// Iterate through possible partition points and calculate the minimum
				// number of multiplications
				for (int k = i; k < j; k++) {
					int steps = arr[i - 1] * arr[k] * arr[j] // Cost of multiplication of two matrices
							+ dp[i][k] + dp[k + 1][j]; // Cost of left and right parts
					min = Math.min(min, steps); // Update the minimum
				}
				dp[i][j] = min; // Store the computed value in the table
			}
		}
		return dp[1][n - 1]; // Return the result
	}
	
	 public static void main(String[] args) {
	        // Sample array representing the dimensions of matrices
	        int[] arr = {10, 20, 30, 40, 30};

	        // Using recursion
	        int minMultiplicationsRecursion = DP48And49MatrixChainMultiplication.matrixMultiplicationRecursion(arr.length, arr);
	        System.out.println("Minimum number of multiplications (Recursion): " + minMultiplicationsRecursion);

	        // Using memoization
	        int minMultiplicationsMemoization = DP48And49MatrixChainMultiplication.matrixMultiplicationMemoization(arr.length, arr);
	        System.out.println("Minimum number of multiplications (Memoization): " + minMultiplicationsMemoization);

	        // Using tabulation
	        int minMultiplicationsTabulation = DP48And49MatrixChainMultiplication.matrixMultiplicationTabulation(arr.length, arr);
	        System.out.println("Minimum number of multiplications (Tabulation): " + minMultiplicationsTabulation);
	    }
}
