/**
 * 	Given a rod of length ‘N’ units. The rod can be cut into different sizes and 
 	each size has a cost associated with it. Determine the maximum cost obtained 
 	by cutting the rod and selling its pieces.
	
	Note:
	1. The sizes will range from 1 to ‘N’ and will be integers.
	2. The sum of the pieces cut should be equal to ‘N’.
	3. Consider 1-based indexing.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP24RodCuttingProblem {

	public static int cutRodRecursion(int price[], int n) {
		return cutRodRecursion(price, n - 1, n);
	}

	private static int cutRodRecursion(int[] price, int index, int length) {

		if (index == 0) {
			return length * price[0];
		}
		int notTake = cutRodRecursion(price, index - 1, length);
		int take = Integer.MIN_VALUE;
		int rodLength = index + 1;
		if (rodLength <= length) {
			take = price[index]
					+ cutRodRecursion(price, index, length - rodLength);
		}

		return Math.max(take, notTake);
	}

	public static int cutRodMemoization(int price[], int n) {

		int[][] dp = new int[n][n + 1];
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		return cutRodMemoization(price, n - 1, n, dp);
	}

	private static int cutRodMemoization(int[] price, int index, int length,
			int[][] dp) {

		if (index == 0) {
			return length * price[0];
		}

		if (dp[index][length] != -1)
			return dp[index][length];
		int notTake = cutRodMemoization(price, index - 1, length, dp);
		int take = Integer.MIN_VALUE;
		int rodLength = index + 1;
		if (rodLength <= length) {
			take = price[index]
					+ cutRodMemoization(price, index, length - rodLength, dp);
		}

		return dp[index][length] = Math.max(take, notTake);
	}

	public static int cutRodTabulation(int price[], int n) {

		int[][] dp = new int[n][n + 1];
		for (int length = 0; length <= n; length++) {
			dp[0][length] = length * price[0];
		}

		for (int index = 1; index < n; index++) {
			for (int length = 0; length <= n; length++) {
				int notTake = dp[index - 1][length];
				int take = Integer.MIN_VALUE;
				int rodLength = index + 1;
				if (rodLength <= length) {
					take = price[index] + dp[index][length - rodLength];
				}

				dp[index][length] = Math.max(take, notTake);
			}
		}

		return dp[n - 1][n];
	}

	public static int cutRodSpaceOptimization(int price[], int n) {

		int[] prev = new int[n + 1];
		int[] current = new int[n + 1];
		for (int length = 0; length <= n; length++) {
			prev[length] = length * price[0];
		}

		for (int index = 1; index < n; index++) {
			for (int length = 0; length <= n; length++) {
				int notTake = prev[length];
				int take = Integer.MIN_VALUE;
				int rodLength = index + 1;
				if (rodLength <= length) {
					take = price[index] + current[length - rodLength];
				}

				current[length] = Math.max(take, notTake);
			}
			prev = current;
		}

		return prev[n];
	}
	
	public static void main(String[] args) {
        // Example inputs
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        // Test the recursion method
        int resultRecursion = cutRodRecursion(price, n);
        System.out.println("Recursion Method: " + resultRecursion);

        // Test the memoization method
        int resultMemoization = cutRodMemoization(price, n);
        System.out.println("Memoization Method: " + resultMemoization);

        // Test the tabulation method
        int resultTabulation = cutRodTabulation(price, n);
        System.out.println("Tabulation Method: " + resultTabulation);

        // Test the space optimization method
        int resultSpaceOptimization = cutRodSpaceOptimization(price, n);
        System.out.println("Space Optimization Method: " + resultSpaceOptimization);
    }
}
