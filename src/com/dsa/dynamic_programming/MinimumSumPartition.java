/**
 	Given an array arr of size n containing non-negative integers, the task is to divide it 
 	into two sets S1 and S2 such that the absolute difference between their sums is minimum 
 	and find the minimum difference

	Example 1:
	Input: N = 4, arr[] = {1, 6, 11, 5} 
	Output: 1
	Explanation: 
	Subset1 = {1, 5, 6}, sum of Subset1 = 12 
	Subset2 = {11}, sum of Subset2 = 11   
	
	Example 2:
	Input: N = 2, arr[] = {1, 4}
	Output: 3
	Explanation: 
	Subset1 = {1}, sum of Subset1 = 1
	Subset2 = {4}, sum of Subset2 = 4
	
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class MinimumSumPartition {

    // Method to find the minimum difference between two subsets of the given array
    public int minDifference(int nums[], int N) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        // Create a DP table to store intermediate results
        boolean dp[][] = new boolean[nums.length][totalSum + 1];

        // Initialize the first row of the DP table
        for (int index = 0; index < nums.length; index++) {
            dp[index][0] = true;
        }

        // Initialize the first column of the DP table
        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }

        // Iterate through the elements and possible sum values
        for (int index = 1; index < nums.length; index++) {
            for (int sum = 1; sum <= totalSum; sum++) {
                // Calculate whether to take or not take the current element to achieve the target sum
                boolean notTake = dp[index - 1][sum];
                boolean take = false;
                if (nums[index] <= sum) {
                    take = dp[index - 1][sum - nums[index]];
                }
                // Update the DP table with the result
                dp[index][sum] = take | notTake;
            }
        }

        // Initialize the minimum difference variable
        int min = (int) 1e9;

        // Iterate through the possible sum values
        for (int sum = 0; sum <= totalSum; sum++) {
            // If a subset with the sum is possible, calculate the difference between two subsets
            if (dp[nums.length - 1][sum]) {
                int s1 = sum;
                int s2 = totalSum - s1;

                // Update the minimum difference
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }
        // Return the minimum difference
        return min;
    }

    // Main method to test and demonstrate the functionality
    public static void main(String[] args) {
        // Example array
        int[] nums = {1, 6, 11, 5};

        // Get the length of the array
        int N = nums.length;

        // Create an instance of the MinimumSumPartition class
        MinimumSumPartition minSumPartition = new MinimumSumPartition();

        // Find the minimum difference between two subsets
        int result = minSumPartition.minDifference(nums, N);

        // Print the result
        System.out.println("Minimum difference between two subsets: " + result);
    }
}

