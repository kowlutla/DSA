/**
  	You are a professional robber planning to rob houses along a street. 
  	Each house has a certain amount of money stashed, the only constraint 
  	stopping you from robbing each of them is that adjacent houses have 
  	security systems connected and it will automatically contact the police 
  	if two adjacent houses were broken into on the same night.
	
	Given an integer array nums representing the amount of money of each house, 
	return the maximum amount of money you can rob tonight without alerting the police.

 

	Example 1:
	Input: nums = [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	Total amount you can rob = 1 + 3 = 4.

	Example 2:
	Input: nums = [2,7,9,3,1]
	Output: 12
	Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	Total amount you can rob = 2 + 9 + 1 = 12.
 */
package com.dsa.dynamic_programming.one_dim_array;

import java.util.Arrays;

public class HouseRobber {

    // Recursive solution starting from the end of the array
    public int robRecursion(int[] nums) {
        return robRecursion(nums, nums.length - 1);
    }

    private int robRecursion(int[] nums, int n) {
        if (n == 0) { // If only one house
            return nums[n];
        }

        if (n < 0) { // Base case for no houses
            return 0;
        }

        // Attempt to rob the current house or skip it
        int take = nums[n] + robRecursion(nums, n - 2); // Rob current house
        int no = robRecursion(nums, n - 1); // Skip current house
        return Math.max(take, no); // Choose the maximum profit
    }

    // Memoization solution
    public int robMemoization(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1); // Fill the memoization array with -1 indicating uncalculated values
        return robMemoization(nums, dp, nums.length - 1);
    }

    private int robMemoization(int[] nums, int[] dp, int n) {
        if (n == 0) {
            return nums[n];
        }

        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) { // If the value has been memoized, return it
            return dp[n];
        }

        // Memoization: store the maximum profit for each house in the dp array
        int take = nums[n] + robMemoization(nums, dp, n - 2); // Rob current house
        int notTake = robMemoization(nums, dp, n - 1); // Skip current house
        return dp[n] = Math.max(take, notTake); // Store and return the maximum profit
    }

    // Tabulation solution
    public int robTabulation(int[] nums) {
		if (nums.length == 1) {
			return nums[nums.length - 1];
		}
        int dp[] = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            // At each house, calculate the maximum profit considering robbing or skipping
            int pick = nums[i] + dp[i - 2]; // Rob current house
            int notPick = dp[i - 1]; // Skip current house
            dp[i] = Math.max(pick, notPick); // Store the maximum profit at the current house
        }
        return dp[nums.length - 1]; // Return the maximum profit after traversing all houses
    }

    // Main method for testing
    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1, 1}; // Example array of house values

        // Test robRecursion method
        System.out.println("Using Recursion: " + robber.robRecursion(nums));

        // Test robMemoization method
        System.out.println("Using Memoization: " + robber.robMemoization(nums));

        // Test robTabulation method
        System.out.println("Using Tabulation: " + robber.robTabulation(nums));
    }
}
