/**
 * 	Given an integer array nums, return the length of the longest strictly increasing 
	subsequence
	
	 
	
	Example 1:
	
	Input: nums = [10,9,2,5,3,7,101,18]
	Output: 4
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
	Example 2:
	
	Input: nums = [0,1,0,3,2,3]
	Output: 4
	Example 3:
	
	Input: nums = [7,7,7,7,7,7,7]
	Output: 1
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP41LengthOfLongestIncreasingSubsequence {

    // Method to find length of longest increasing subsequence using recursion
    public static int lengthOfLISRecursion(int[] nums) {
        // Start the recursion from the first element with previous value as the minimum integer value
        return lengthOfLISRecursion(nums, 0, Integer.MIN_VALUE);
    }

    // Recursive method to find length of longest increasing subsequence
    private static int lengthOfLISRecursion(int[] nums, int index, int prev) {
        // Base case: if we reach the end of the array, return 0
        if (index == nums.length) {
            return 0;
        }

        // Calculate length if the current element is not picked
        int notPick = lengthOfLISRecursion(nums, index + 1, prev);

        // Calculate length if the current element is picked
        int pick = 0;
        if (prev == Integer.MIN_VALUE || nums[index] > prev) {
            // If the current element is greater than the previous, it can be picked
            pick = 1 + lengthOfLISRecursion(nums, index + 1, nums[index]);
        }
        // Return the maximum of pick and notPick
        return Math.max(pick, notPick);
    }

    // Method to find length of longest increasing subsequence using memoization
    public static int lengthOfLISMemoization(int arr[]) {
        int n = arr.length;
        // Create a memoization table with dimensions [array length][array length + 1]
        int[][] dp = new int[n][n + 1];
        // Initialize the memoization table with -1
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // Start memoization from the beginning of the array with previous index as -1
        return lengthOfLISMemoization(arr, 0, -1, dp);
    }

    // Memoization method to find length of longest increasing subsequence
    private static int lengthOfLISMemoization(int arr[], int index, int prev, int[][] dp) {
        // Base case: if we reach the end of the array, return 0
        if (index == arr.length) {
            return 0;
        }

        // If result is already computed, return it
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        // Calculate length if the current element is not picked
        int notPick = lengthOfLISMemoization(arr, index + 1, prev, dp);

        // Calculate length if the current element is picked
        int pick = 0;
        if (prev == -1 || arr[index] > arr[prev]) {
            // If the current element is greater than the previous, it can be picked
            pick = 1 + lengthOfLISMemoization(arr, index + 1, index, dp);
        }
        // Return the maximum of pick and notPick and store it in memoization table
        return dp[index][prev + 1] = Math.max(pick, notPick);
    }

    // Method to find length of longest increasing subsequence using tabulation
    public static int lengthOfLISTabulation(int arr[]) {
        int n = arr.length;
        // Create a tabulation table with dimensions [array length + 1][array length + 1]
        int[][] dp = new int[n + 1][n + 1];
        // Iterate through the array backwards
        for (int index = n - 1; index >= 0; index--) {
            // Iterate through the previous index backwards
            for (int prev = index - 1; prev >= -1; prev--) {
                // Calculate length if the current element is not picked
                int notPick = dp[index + 1][prev + 1];
                // Calculate length if the current element is picked
                int pick = 0;
                if (prev == -1 || arr[index] > arr[prev]) {
                    // If the current element is greater than the previous, it can be picked
                    pick = 1 + dp[index + 1][index + 1];
                }
                // Store the maximum of pick and notPick in the tabulation table
                dp[index][prev + 1] = Math.max(pick, notPick);
            }
        }
        // Return the length of longest increasing subsequence
        return dp[0][0];
    }

    // Method to find length of longest increasing subsequence with space optimization
    public static int lengthOfLISSpaceOptimization(int arr[]) {
        int n = arr.length;
        // Initialize arrays to keep track of current and previous results
        int[] ahead = new int[n + 1];
        int[] current = new int[n + 1];

        // Iterate through the array backwards
        for (int index = n - 1; index >= 0; index--) {
            // Iterate through the previous index backwards
            for (int prev = index - 1; prev >= -1; prev--) {
                // Calculate length if the current element is not picked
                int notPick = ahead[prev + 1];
                // Calculate length if the current element is picked
                int pick = 0;
                if (prev == -1 || arr[index] > arr[prev]) {
                    // If the current element is greater than the previous, it can be picked
                    pick = 1 + ahead[index + 1];
                }
                // Store the maximum of pick and notPick in the current array
                current[prev + 1] = Math.max(pick, notPick);
            }
            // Update the ahead array for the next iteration
            ahead = current;
        }
        // Return the length of longest increasing subsequence
        return ahead[0];
    }

    // Method to find length of longest increasing subsequence using a different algorithm
    public static int lengthOfLISAlgorithm2(int arr[]) {
        // Initialize an array to store the length of LIS ending at each index
        int[] dp = new int[arr.length];
        // Initialize all values of dp to 1 (minimum length of LIS is 1)
        Arrays.fill(dp, 1);
        // Initialize max variable to track the maximum length
        int max = 1;
        // Iterate through the array
        for (int current = 0; current < arr.length; current++) {
            // Iterate through the elements before the current element
            for (int prev = 0; prev < current; prev++) {
                // If the current element is greater than the previous, update dp[current]
                if (arr[current] > arr[prev]) {
                    dp[current] = Math.max(dp[current], dp[prev] + 1);
                }
            }
            // Update max with the maximum value of dp[current]
            max = Math.max(dp[current], max);
        }
        // Return the maximum length of LIS
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18}; // Sample array

        // Using recursion
        int lisRecursion = DP41LengthOfLongestIncreasingSubsequence.lengthOfLISRecursion(nums);
        System.out.println("Length of LIS using recursion: " + lisRecursion);

        // Using memoization
        int lisMemoization = DP41LengthOfLongestIncreasingSubsequence.lengthOfLISMemoization(nums);
        System.out.println("Length of LIS using memoization: " + lisMemoization);

        // Using tabulation
        int lisTabulation = DP41LengthOfLongestIncreasingSubsequence.lengthOfLISTabulation(nums);
        System.out.println("Length of LIS using tabulation: " + lisTabulation);

        // Using space optimization
        int lisSpaceOptimization = DP41LengthOfLongestIncreasingSubsequence.lengthOfLISSpaceOptimization(nums);
        System.out.println("Length of LIS using space optimization: " + lisSpaceOptimization);

        // Using a different algorithm
        int lisAlgorithm2 = DP41LengthOfLongestIncreasingSubsequence.lengthOfLISAlgorithm2(nums);
        System.out.println("Length of LIS using a different algorithm: " + lisAlgorithm2);
    }
}
