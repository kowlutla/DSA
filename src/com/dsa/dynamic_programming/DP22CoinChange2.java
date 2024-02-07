/**
 *  Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, 
 	find the number of ways you can make sum by using different combinations from coins[ ].  
	Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

	Example 1:
	Input:
	N = 3, sum = 4
	coins = {1,2,3}
	Output: 4
	Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.

	Example 2:
	Input:
	N = 4, Sum = 10
	coins = {2,5,3,6}
	Output: 5
	Explanation: Five Possible ways are: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class DP22CoinChange2 {

    // Recursive approach to find the number of combinations to make the amount
    // using coins
    public static int changeRecursion(int amount, int[] coins) {
        return changeRecursion(coins, amount, coins.length - 1);
    }

    // Helper function for recursive approach
    private static int changeRecursion(int[] coins, int amount, int index) {
        // Base case: if only one coin is left
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return 1; // If the amount is divisible by the coin, return 1
            } else {
                return 0; // Otherwise, no combinations are possible
            }
        }

        // Recursively count combinations by taking or not taking the current coin
        int notTake = changeRecursion(coins, amount, index - 1);
        int take = 0;
        if (coins[index] <= amount) {
            take = changeRecursion(coins, amount - coins[index], index);
        }

        // Return the sum of combinations
        return take + notTake;
    }

    // Memoization approach to find the number of combinations to make the amount
    // using coins
    public static int changeMemoization(int amount, int[] coins) {
        // Create a memoization table initialized with -1
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return changeMemoization(coins, amount, coins.length - 1, dp);
    }

    // Helper function for memoization approach
    private static int changeMemoization(int[] coins, int amount, int index, int[][] dp) {
        // Base case: if only one coin is left
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // If the result is already memoized, return it
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Recursively count combinations by taking or not taking the current coin
        int notTake = changeMemoization(coins, amount, index - 1, dp);
        int take = 0;
        if (coins[index] <= amount) {
            take = changeMemoization(coins, amount - coins[index], index, dp);
        }

        // Memoize the result and return
        return dp[index][amount] = take + notTake;
    }

    // Tabulation approach to find the number of combinations to make the amount
    // using coins
    public static int changeTabulation(int amount, int[] coins) {
        // Create a DP table
        int[][] dp = new int[coins.length][amount + 1];

        // Initialize the first row of the DP table
        for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
            if (currentAmount % coins[0] == 0) {
                dp[0][currentAmount] = 1;
            }
        }

        // Fill the DP table using a bottom-up approach
        for (int index = 1; index < coins.length; index++) {
            for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
                // Calculate the number of combinations by taking or not taking the current coin
                int notTake = dp[index - 1][currentAmount];
                int take = 0;
                if (coins[index] <= currentAmount) {
                    take = dp[index][currentAmount - coins[index]];
                }

                // Update the DP table
                dp[index][currentAmount] = take + notTake;
            }
        }

        // Return the result stored in the bottom-right cell of the DP table
        return dp[coins.length - 1][amount];
    }

    // Space-optimized Tabulation approach to find the number of combinations to make the
    // amount using coins
    public static int changeSpaceOptimization(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        int[] current = new int[amount + 1];

        // Initialize the first row of the DP table
        for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
            if (currentAmount % coins[0] == 0) {
                prev[currentAmount] = 1;
            }
        }

        // Fill the DP table using a bottom-up approach
        for (int index = 1; index < coins.length; index++) {
            for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
                // Calculate the number of combinations by taking or not taking the current coin
                int notTake = prev[currentAmount];
                int take = 0;
                if (coins[index] <= currentAmount) {
                    take = current[currentAmount - coins[index]];
                }

                // Update the current row of the DP table
                current[currentAmount] = take + notTake;
            }
            // Update the previous row for the next iteration
            prev = current;
        }

        // Return the result stored in the last element of the 'prev' array
        return prev[amount];
    }
    
    public static void main(String[] args) {
        // Example inputs
        int amount = 5;
        int[] coins = {1, 2, 5};

        // Test the recursion method
        int resultRecursion = changeRecursion(amount, coins);
        System.out.println("Recursion Method: " + resultRecursion);

        // Test the memoization method
        int resultMemoization = changeMemoization(amount, coins);
        System.out.println("Memoization Method: " + resultMemoization);

        // Test the tabulation method
        int resultTabulation = changeTabulation(amount, coins);
        System.out.println("Tabulation Method: " + resultTabulation);

        // Test the space optimization method
        int resultSpaceOptimization = changeSpaceOptimization(amount, coins);
        System.out.println("Space Optimization Method: " + resultSpaceOptimization);
    }
    
}

