/**
 * 	You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total 
 	value in the knapsack. Note that we have only one quantity of each item.
	In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights 
	associated with N items respectively. Also given an integer W which represents knapsack capacity, find out 
	the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
	You cannot break an item, either pick the complete item or dont pick it (0-1 property).

	Example 1:
	Input:
	N = 3
	W = 4
	values[] = {1,2,3}
	weight[] = {4,5,1}
	Output: 3
	Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 

	Example 2:
	Input:
	N = 3
	W = 3
	values[] = {1,2,3}
	weight[] = {4,5,6}
	Output: 0
	Explanation: Every item has a weight exceeding the knapsack's capacity (3).
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class KnapsackProblem01 {

	public static int knapSackRecursion(int W, int wt[], int val[], int n) {
		return knapSackUtil1Recursion(W, wt, val, n - 1);
	}

	private static int knapSackUtil1Recursion(int maxWeight, int[] weight, int[] value, int index) {
		
		if (index == 0) {
			if (weight[index] <= maxWeight) {
				return value[index];
			} else {
				return 0;
			}
		}
		
		int notTake = knapSackUtil1Recursion(maxWeight, weight, value, index - 1) + 0;
		int take = 0;
		
		if (weight[index] <= maxWeight) {
			take = knapSackUtil1Recursion(maxWeight - weight[index], weight, value, index - 1) + value[index];
		}
		
		return Math.max(take, notTake);
	}

	public static int knapSackMemoization(int W, int wt[], int val[], int n) {
		
		int[][] dp = new int[n][W + 1];
		
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		
		return knapSackUtilMemoization(W, wt, val, n - 1, dp);
	}

	private static int knapSackUtilMemoization(int maxWeight, int[] weight, int[] value,
			int index, int[][] dp) {
		
		if (index == 0) {
			if (weight[index] <= maxWeight) {
				return value[index];
			} else {
				return 0;
			}
		}
		
		if (dp[index][maxWeight] != -1) {
			return dp[index][maxWeight];
		}
		
		int notTake = knapSackUtilMemoization(maxWeight, weight, value, index - 1, dp) + 0;
		int take = 0;
		
		if (weight[index] <= maxWeight) {
			take = knapSackUtilMemoization(maxWeight - weight[index], weight, value, index - 1, dp) + value[index];
		}
		
		return dp[index][maxWeight] = Math.max(take, notTake);
	}
	
	public static int knapSackTabulation(int W, int wt[], int value[], int n) {
		int[][] dp = new int[n][W + 1];

		for (int weight = wt[0]; weight <= W; weight++) {
			dp[0][weight] = value[0];
		}

		for (int index = 1; index < n; index++) {
			for (int weight = 0; weight <= W; weight++) {
				int notTake = dp[index - 1][weight];
				int take = 0;
				if (wt[index] <= weight) {
					take = dp[index - 1][weight - wt[index]] + value[index];
				}

				dp[index][weight] = Math.max(take, notTake);
			}
		}
		return dp[n - 1][W];
	}


	public static int knapSackSpaceOptimization(int W, int wt[], int value[], int n) {
		int prev[] = new int[W + 1];

		for (int weight = wt[0]; weight <= W; weight++) {
			prev[weight] = value[0];
		}

		for (int index = 1; index < n; index++) {
			int[] current = new int[W + 1];
			for (int weight = 0; weight <= W; weight++) {
				int notTake = prev[weight];
				int take = 0;
				if (wt[index] <= weight) {
					take = prev[weight - wt[index]] + value[index];
				}

				current[weight] = Math.max(take, notTake);
			}
			prev = current;
		}
		return prev[W];
	}
	
	public static void main(String[] args) {
        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int W = 5;
        int n = wt.length;
        
        // Test knapSackRecursion
        System.out.println("Testing knapSackRecursion:");
        System.out.println("Result: " + knapSackRecursion(W, wt, val, n));
        
        // Test knapSackMemoization
        System.out.println("\nTesting knapSackMemoization:");
        System.out.println("Result: " + knapSackMemoization(W, wt, val, n));
        
        // Test knapSackTabulation
        System.out.println("\nTesting knapSackTabulation:");
        System.out.println("Result: " + knapSackTabulation(W, wt, val, n));
        
        // Test knapSackSpaceOptimization
        System.out.println("\nTesting knapSackSpaceOptimization:");
        System.out.println("Result: " + knapSackSpaceOptimization(W, wt, val, n));
    }
}
