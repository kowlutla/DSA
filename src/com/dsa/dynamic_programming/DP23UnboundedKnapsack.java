/**
 * 	You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.
	You need to fill the knapsack with the items in such a way that you get the maximum profit. 
	You are allowed to take one item multiple times.
	
	Example:
	Input: 
	'n' = 3, 'w' = 10, 
	'profit' = [5, 11, 13]
	'weight' = [2, 4, 6]
	
	Output: 27
	
	Explanation:
	We can fill the knapsack as:
	
	1 item of weight 6 and 1 item of weight 4.
	1 item of weight 6 and 2 items of weight 2.
	2 items of weight 4 and 1 item of weight 2.
	5 items of weight 2.
	
	The maximum profit will be from case 3 = 11 + 11 + 5 = 27. 
	Therefore maximum profit = 27.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP23UnboundedKnapsack {
	public static int unboundedKnapsackRecursion(int n, int w, int[] profit,
			int[] weight) {
		return unboundedKnapsackUtilRecursion(n - 1, w, profit, weight);
	}

	private static int unboundedKnapsackUtilRecursion(int index, int w,
			int[] profit, int[] weight) {

		if (index == 0) {
			return (w / weight[0]) * profit[0];
		}
		int notTake = unboundedKnapsackUtilRecursion(index - 1, w, profit,
				weight);
		int take = Integer.MIN_VALUE;
		if (weight[index] <= w) {
			take = profit[index] + unboundedKnapsackUtilRecursion(index,
					w - weight[index], profit, weight);
		}

		return Math.max(take, notTake);
	}

	public static int unboundedKnapsackMemoization(int n, int w, int[] profit,
			int[] weight) {

		int dp[][] = new int[n][w + 1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return unboundedKnapsackUtilMemoization(n - 1, w, profit, weight, dp);
	}

	public static int unboundedKnapsackUtilMemoization(int index, int w,
			int[] profit, int[] weight, int[][] dp) {

		if (index == 0) {
			return (w / weight[0]) * profit[0];
		}

		if (dp[index][w] != -1) {
			return dp[index][w];
		}
		int notTake = unboundedKnapsackUtilMemoization(index - 1, w, profit,
				weight, dp);
		int take = Integer.MIN_VALUE;
		if (weight[index] <= w) {
			take = profit[index] + unboundedKnapsackUtilMemoization(index,
					w - weight[index], profit, weight, dp);
		}

		return dp[index][w] = Math.max(take, notTake);
	}

	public static int unboundedKnapsackTabulation(int n, int w, int[] profit,
			int[] weight) {

		int dp[][] = new int[n][w + 1];
		for (int currentWeight = 0; currentWeight <= w; currentWeight++) {
			dp[0][currentWeight] = (currentWeight / weight[0]) * profit[0];
		}

		for (int index = 1; index < n; index++) {
			for (int currentWeight = 0; currentWeight <= w; currentWeight++) {
				int notTake = dp[index - 1][currentWeight];
				int take = Integer.MIN_VALUE;
				if (weight[index] <= currentWeight) {
					take = dp[index][currentWeight - weight[index]]
							+ profit[index];
				}

				dp[index][currentWeight] = Math.max(take, notTake);
			}
		}
		return dp[n - 1][w];
	}

	public static int unboundedKnapsackSpaceOptimization(int n, int w,
			int[] profit, int[] weight) {

		int prev[] = new int[w + 1];
		int current[] = new int[w + 1];
		for (int currentWeight = 0; currentWeight <= w; currentWeight++) {
			prev[currentWeight] = (currentWeight / weight[0]) * profit[0];
		}

		for (int index = 1; index < n; index++) {
			for (int currentWeight = 0; currentWeight <= w; currentWeight++) {
				int notTake = prev[currentWeight];
				int take = Integer.MIN_VALUE;
				if (weight[index] <= currentWeight) {
					take = current[currentWeight - weight[index]]
							+ profit[index];
				}
				current[currentWeight] = Math.max(take, notTake);
			}
			prev = current;
		}
		return prev[w];
	}

	public static void main(String[] args) {
		// Example inputs
		int n = 3;
		int w = 8;
		int[] profit = {10, 40, 50};
		int[] weight = {1, 3, 4};

		// Test the recursion method
		int resultRecursion = unboundedKnapsackRecursion(n, w, profit, weight);
		System.out.println("Recursion Method: " + resultRecursion);

		// Test the memoization method
		int resultMemoization = unboundedKnapsackMemoization(n, w, profit, weight);
		System.out.println("Memoization Method: " + resultMemoization);

		// Test the tabulation method
		int resultTabulation = unboundedKnapsackTabulation(n, w, profit, weight);
		System.out.println("Tabulation Method: " + resultTabulation);

		// Test the space optimization method
		int resultSpaceOptimization = unboundedKnapsackSpaceOptimization(n, w, profit, weight);
		System.out.println("Space Optimization Method: " + resultSpaceOptimization);
	}
}
