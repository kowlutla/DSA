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

public class DP24RodCuttingProblem {

    // Recursive approach to find the maximum profit by cutting the rod
    public static int cutRodRecursion(int price[], int n) {
        return cutRodRecursion(price, n - 1, n);
    }

    // Helper function for recursive approach
    private static int cutRodRecursion(int[] price, int index, int length) {
        // Base case: if only one segment is left
        if (index == 0) {
            return length * price[0];
        }

        // Recursively calculate maximum profit by taking or not taking the current segment
        int notTake = cutRodRecursion(price, index - 1, length);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= length) {
            take = price[index] + cutRodRecursion(price, index, length - rodLength);
        }

        // Return the maximum profit
        return Math.max(take, notTake);
    }

    // Memoization approach to find the maximum profit by cutting the rod
    public static int cutRodMemoization(int price[], int n) {
        // Create a memoization table initialized with -1
        int[][] dp = new int[n][n + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return cutRodMemoization(price, n - 1, n, dp);
    }

    // Helper function for memoization approach
    private static int cutRodMemoization(int[] price, int index, int length, int[][] dp) {
        // Base case: if only one segment is left
        if (index == 0) {
            return length * price[0];
        }

        // If the result is already memoized, return it
        if (dp[index][length] != -1)
            return dp[index][length];

        // Recursively calculate maximum profit by taking or not taking the current segment
        int notTake = cutRodMemoization(price, index - 1, length, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= length) {
            take = price[index] + cutRodMemoization(price, index, length - rodLength, dp);
        }

        // Memoize the result and return
        return dp[index][length] = Math.max(take, notTake);
    }

    // Tabulation approach to find the maximum profit by cutting the rod
    public static int cutRodTabulation(int price[], int n) {
        // Create a DP table
        int[][] dp = new int[n][n + 1];

        // Initialize the first row of the DP table
        for (int length = 0; length <= n; length++) {
            dp[0][length] = length * price[0];
        }

        // Fill the DP table using a bottom-up approach
        for (int index = 1; index < n; index++) {
            for (int length = 0; length <= n; length++) {
                // Calculate maximum profit by taking or not taking the current segment
                int notTake = dp[index - 1][length];
                int take = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if (rodLength <= length) {
                    take = price[index] + dp[index][length - rodLength];
                }

                // Update the DP table
                dp[index][length] = Math.max(take, notTake);
            }
        }

        // Return the result stored in the bottom-right cell of the DP table
        return dp[n - 1][n];
    }

    // Space-optimized Tabulation approach to find the maximum profit by cutting the rod
    public static int cutRodSpaceOptimization(int price[], int n) {
        // Create two arrays to store previous and current rows of the DP table
        int[] prev = new int[n + 1];
        int[] current = new int[n + 1];

        // Initialize the first row of the DP table
        for (int length = 0; length <= n; length++) {
            prev[length] = length * price[0];
        }

        // Fill the DP table using a bottom-up approach
        for (int index = 1; index < n; index++) {
            for (int length = 0; length <= n; length++) {
                // Calculate maximum profit by taking or not taking the current segment
                int notTake = prev[length];
                int take = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if (rodLength <= length) {
                    take = price[index] + current[length - rodLength];
                }

                // Update the current row of the DP table
                current[length] = Math.max(take, notTake);
            }
            // Update the previous row for the next iteration
            prev = current;
        }

        // Return the result stored in the last element of the 'prev' array
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
