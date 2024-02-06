/**
 * 	You are given an integer array coins representing coins of different denominations and 
 	an integer amount representing a total amount of money.

	Return the fewest number of coins that you need to make up that amount. 
	If that amount of money cannot be made up by any combination of the coins, return -1.

	You may assume that you have an infinite number of each kind of coin.

	Example 1:
	Input: coins = [1,2,5], amount = 11
	Output: 3
	Explanation: 11 = 5 + 5 + 1

	Example 2:
	Input: coins = [2], amount = 3
	Output: -1

	Example 3:
	Input: coins = [1], amount = 0
	Output: 0
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP20CoinChange {
	
	public static int coinChangeRecursion(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		Arrays.sort(coins);
		int n = coins.length;
		int ans = coinChangeRecursion(coins, amount, n - 1);
		if (ans >= (int) 1e9) {
			return -1;
		} else {
			return ans;
		}
	}

	private static int coinChangeRecursion(int[] coins, int amount, int index) {
		if (index == 0) {
			if (amount % coins[0] == 0) {
				return amount / coins[0];
			} else {
				return (int) 1e9;
			}
		}

		int notTake = coinChangeRecursion(coins, amount, index - 1);
		int take = (int) 1e9;
		if (coins[index] <= amount) {
			take = 1 + coinChangeRecursion(coins, amount - coins[index], index);
		}
		return Math.min(notTake, take);
	}

	public static int coinChangeMemoization(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		Arrays.sort(coins);
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		int ans = coinChangeMemoization(coins, amount, coins.length - 1, dp);
		if (ans >= (int) 1e9) {
			return -1;
		} else {
			return ans;
		}
	}

	private static int coinChangeMemoization(int[] coins, int amount, int index, int[][] dp) {
		if (index == 0) {
			if (amount % coins[0] == 0) {
				return amount / coins[0];
			} else {
				return (int) 1e9;
			}
		}

		if (dp[index][amount] != -1) {
			return dp[index][amount];
		}
		int notTake = coinChangeMemoization(coins, amount, index - 1, dp);
		int take = (int) 1e9;
		if (coins[index] <= amount) {
			take = 1 + coinChangeMemoization(coins, amount - coins[index], index, dp);
		}

		return dp[index][amount] = Math.min(take, notTake);
	}
	
	public int coinChangeTabulation(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		Arrays.sort(coins);
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];

		for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
			if (currentAmount % coins[0] == 0) {
				dp[0][currentAmount] = currentAmount / coins[0];
			} else {
				dp[0][currentAmount] = (int) 1e9;
			}
		}

		for (int index = 1; index < n; index++) {
			for (int currentAmount = 0; currentAmount <= amount; currentAmount++) {
				int notTake = dp[index - 1][currentAmount];
				int take = (int) 1e9;
				if (coins[index] <= currentAmount) {
					take = 1 + dp[index][currentAmount - coins[index]];
				}

				dp[index][currentAmount] = Math.min(take, notTake);
			}
		}

		if (dp[n - 1][amount] >= (int) 1e9) {
			return -1;
		}
		return dp[n - 1][amount];
	}
	
	public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        
        // Test coinChangeRecursion
        System.out.println("Testing coinChangeRecursion:");
        System.out.println("Result: " + coinChangeRecursion(coins, amount));

        // Test coinChangeMemoization
        System.out.println("\nTesting coinChangeMemoization:");
        System.out.println("Result: " + coinChangeMemoization(coins, amount));

        // Test coinChangeTabulation
        System.out.println("\nTesting coinChangeTabulation:");
        DP20CoinChange dp = new DP20CoinChange();
        System.out.println("Result: " + dp.coinChangeTabulation(coins, amount));
    }
}
