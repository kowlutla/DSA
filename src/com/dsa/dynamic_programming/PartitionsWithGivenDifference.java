/**
 * Given an array arr, partition it into two subsets(possibly empty) such that their union is the original array. 
 * Let the sum of the element of these two subsets be S1 and S2. 

	Given a difference d, count the number of partitions in which S1 is greater than or equal to S2 and the
	difference S1 and S2 is equal to d. since the answer may be large return it modulo 109 + 7.
	Example 1:
	Input:
	n = 4, d = 3
	arr[] =  { 5, 2, 6, 4}
	Output:
	1
	Explanation:
	There is only one possible partition of this array. Partition : {6, 4}, {5, 2}. 
	The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.

	Example 2:
	Input:
	n = 4, d = 0 arr[] = {1, 1, 1, 1} Output: 6 
	
	Constraint:
	1 <= n <= 500
	0 <= d  <= 2500
	0 <= arr[i] <= 50
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class PartitionsWithGivenDifference {

	private int mod = (int) 1e9 + 7;

	public int countPartitionsRecursion(int n, int d, int arr[]) {
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		// s1-s2 = d
		// s1+s2 = totalSum
		// s1 = totalSum-s2
		// totalSum-s2-s2 = d,
		// -2s2 = d-totalSum
		// s2 = (totalSum-d)/2
		// so find the count of subsets with summ s2

		if (totalSum < d || (totalSum - d) % 2 == 1) {
			return 0;
		}
		int sum = (totalSum - d) / 2;
		return countPartitionsRecursion(arr, n - 1, sum);
	}
	private int countPartitionsRecursion(int[] arr, int index, int sum) {
		if (index == 0) {
			if (sum == 0 && arr[index] == 0)
				return 2;
			if (sum == 0 || arr[index] == sum)
				return 1;
			return 0;
		}
		int notTake = countPartitionsRecursion(arr, index - 1, sum);
		int take = 0;
		if (arr[index] <= sum) {
			take = countPartitionsRecursion(arr, index - 1, sum - arr[index]);
		}
		return (take + notTake) % mod;
	}

	public int countPartitionsMemoization(int n, int d, int arr[]) {
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		// s1-s2 = d
		// s1+s2 = totalSum
		// s1 = totalSum-s2
		// totalSum-s2-s2 = d,
		// - 2s2 = d-totalSum
		// s2 = (totalSum-d)/2
		// so find the count of subsets with summ s2
		if (totalSum < d || (totalSum - d) % 2 == 1) {
			return 0;
		}
		int sum = (totalSum - d) / 2;
		int[][] dp = new int[n][sum + 1];
		for (int a[] : dp) {
			Arrays.fill(a, -1);
		}
		return countPartitionsMemoization(arr, n - 1, sum, dp);
	}

	private int countPartitionsMemoization(int[] arr, int index, int sum,
			int[][] dp) {

		if (index == 0) {
			if (sum == 0 && arr[0] == 0)
				return 2;
			if (sum == 0 || sum == arr[0])
				return 1;
			return 0;
		}
		if (sum < 0) {
			return 0;
		}
		if (dp[index][sum] != -1) {
			return dp[index][sum];
		}
		int notTake = countPartitionsMemoization(arr, index - 1, sum, dp);
		int take = 0;
		if (arr[index] <= sum) {
			take = countPartitionsMemoization(arr, index - 1, sum - arr[index],
					dp);
		}
		return dp[index][sum] = (take + notTake) % mod;
	}
	public int countPartitionsTabulation(int n, int d, int arr[]) {
		int totalSum = 0;
		for (int num : arr) {
			totalSum += num;
		}
		// s1-s2 = d
		// s1+s2 = totalSum
		// s1 = totalSum-s2
		// totalSum-s2-s2 = d,
		// -2s2 = d-totalSum
		// s2 = (totalSum-d)/2
		// so find the count of subsets with summ s2
		if (totalSum < d || (totalSum - d) % 2 == 1) {
			return 0;
		}
		int sum = (totalSum - d) / 2;
		return findWaysTabulation(arr, sum);
	}

	public int findWaysTabulation(int num[], int tar) {
		int[][] dp = new int[num.length][tar + 1];
		if (num[0] == 0) {
			dp[0][0] = 2;
		} else {
			dp[0][0] = 1;
		}
		if (num[0] != 0 && num[0] <= tar) {
			dp[0][num[0]] = 1;
		}
		for (int index = 1; index < num.length; index++) {
			for (int sum = 0; sum <= tar; sum++) {
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
        int[] nums = {1, 1, 2, 3};
        // Given difference
        int d = 1;

        // Create an instance of PartitionsWithGivenDifference
        PartitionsWithGivenDifference partitionCounter = new PartitionsWithGivenDifference();

        // Test the recursive method
        int resultRecursion = partitionCounter.countPartitionsRecursion(nums.length, d, nums);
        System.out.println("Recursive Method: " + resultRecursion);

        // Test the memoization method
        int resultMemoization = partitionCounter.countPartitionsMemoization(nums.length, d, nums);
        System.out.println("Memoization Method: " + resultMemoization);

        // Test the tabulation method
        int resultTabulation = partitionCounter.countPartitionsTabulation(nums.length, d, nums);
        System.out.println("Tabulation Method: " + resultTabulation);
    }
}
