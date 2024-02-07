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

/**
 * @author KowlutlaSwamy
 *
 */
public class CoinChangeNoOfWays {

	public long countMemoization(int coins[], int N, int sum) {
		long[][] dp = new long[N][sum + 1];
		for (long[] d : dp) {
			Arrays.fill(d, -1);
		}
		return countMemoization(N - 1, sum, coins, dp);
	}

	private long countMemoization(int index, int sum, int[] coins, long[][] dp) {

		if (index == 0) {
			if (sum % coins[0] == 0) {
				return 1L;
			} else {
				return 0L;
			}
		}

		if (dp[index][sum] != -1) {
			return dp[index][sum];
		}

		long notTake = countMemoization(index - 1, sum, coins, dp);
		long take = 0;
		if (coins[index] <= sum) {
			take = countMemoization(index, sum - coins[index], coins, dp);
		}

		return dp[index][sum] = take + notTake;
	}
	
	public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 5;

        CoinChangeNoOfWays cc = new CoinChangeNoOfWays();

        // Test countMemoization
        System.out.println("Testing countMemoization:");
        System.out.println("Result: " + cc.countMemoization(coins, coins.length, sum));
    }
}
