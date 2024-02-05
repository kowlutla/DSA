/**
 *Problem statement
	You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
	
	Find the number of ways of selecting the elements from the array such that the sum of chosen 
	elements is equal to the target 'k'.
	Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.
	
	Example:
	Input: 'arr' = [1, 1, 4, 5]
	Output: 3
	Explanation: The possible ways are:
	[1, 4]
	[1, 4]
	[5]
	Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently. 
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class SubsetsCountWithSumK {

	private static int mod = (int) 1e9 + 7;

	public static int findWaysRecursion(int num[], int tar) {
		return findWaysRecursion(num, tar, num.length - 1);
	}

	private static int findWaysRecursion(int[] num, int tar, int index) {
		if (tar == 0) {
			return 1;
		}

		if (index == 0) {
			if (tar == num[index]) {
				return 1;
			} else {
				return 0;
			}
		}

		int notPick = findWaysRecursion(num, tar, index - 1) % mod;
		int pick = 0;
		if (tar >= num[index]) {
			pick = findWaysRecursion(num, tar - num[index], index - 1) % mod;
		}
		return (pick + notPick) % mod;
	}

	public static int findWaysMemoization(int num[], int tar) {
		int[][] dp = new int[num.length][tar + 1];
		for (int d[] : dp) {
			Arrays.fill(d, -1);
		}
		return findWaysMemoization(num, tar, num.length - 1, dp) % mod;
	}

	private static int findWaysMemoization(int[] num, int tar, int index,
			int[][] dp) {

		if (tar < 0) {
			return 0;
		}
		if (tar == 0) {
			return 1;
		}

		if (index == 0) {
			if (tar == num[index]) {
				return 1;
			} else {
				return 0;
			}
		}

		if (dp[index][tar] != -1) {
			return dp[index][tar] % mod;
		}

		int notPick = findWaysMemoization(num, tar, index - 1, dp) % mod;
		int pick = 0;
		if (tar >= num[index]) {
			pick = findWaysMemoization(num, tar - num[index], index - 1, dp) % mod;
		}
		return dp[index][tar] = (pick + notPick) % mod;
	}

	public static int findWaysTabulation(int num[], int tar) {
		int[][] dp = new int[num.length][tar + 1];
		for (int index = 0; index < num.length; index++) {
			dp[index][0] = 1;
		}

		if (num[0] <= tar)
			dp[0][num[0]] = 1;

		for (int index = 1; index < num.length; index++) {
			for (int sum = 1; sum <= tar; sum++) {
				int notPick = dp[index - 1][sum];
				int pick = 0;
				if (num[index] <= sum) {
					pick = dp[index - 1][sum - num[index]];
				}
				dp[index][sum] = (pick + notPick) % mod;
			}
		}
		return dp[num.length - 1][tar];
	}

	public static void main(String[] args) {
        // Example array
        int[] nums = {1, 2, 3, 4, 5};
        // Target sum
        int tar = 10;

        // Test the recursive method
        int resultRecursion = SubsetsCountWithSumK.findWaysRecursion(nums, tar);
        System.out.println("Recursive Method: " + resultRecursion);

        // Test the memoization method
        int resultMemoization = SubsetsCountWithSumK.findWaysMemoization(nums, tar);
        System.out.println("Memoization Method: " + resultMemoization);

        // Test the tabulation method
        int resultTabulation = SubsetsCountWithSumK.findWaysTabulation(nums, tar);
        System.out.println("Tabulation Method: " + resultTabulation);
    }
}
