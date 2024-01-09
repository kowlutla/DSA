/**
 * 	You are a professional robber planning to rob houses along a street.
   	Each house has a certain amount of money stashed. All houses at this place are arranged 
   	in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
   	adjacent houses have a security system connected, and it will automatically contact 
   	the police if two adjacent houses were broken into on the same night.

	Given an integer array nums representing the amount of money of each house,
	return the maximum amount of money you can rob tonight without alerting the police.
	
	Example 1:
	Input: nums = [2,3,2]
	Output: 3
	Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

	Example 2:
	Input: nums = [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	Total amount you can rob = 1 + 3 = 4.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class HouseRobberII {

    // Main method to choose the best combination of houses to rob
    public int rob(int[] nums) {
        if (nums.length == 1) { // If there's only one house, return its value
            return nums[0];
        }
        // Rob houses in two ranges (0 to nums.length - 2 and 1 to nums.length - 1)
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    // Robbing houses within a specific range using a sliding window approach
    private int rob(int[] nums, int low, int high) {
        int prev1 = nums[low]; // Max profit if only one house
        int prev2 = 0; // Max profit if no houses

        for (int i = low + 1; i <= high; i++) {
            int take = nums[i] + (i > 1 ? prev2 : 0); // Max profit if robbing current house
            int notTake = prev1; // Max profit if not robbing current house
            int current = Math.max(take, notTake); // Choose the max profit

            // Update previous values for the next iteration
            prev2 = prev1;
            prev1 = current;
        }
        return prev1; // Return the maximum profit within the specified range
    }

    // Main method for testing
    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
		int[] nums = {2, 3, 2, 3, 4}; // Example array of house values

        // Test rob method
        System.out.println("Max profit from houses: " + robber.rob(nums));
    }
}
