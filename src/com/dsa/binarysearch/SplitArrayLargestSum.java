/**
 * 	Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
	Return the minimized largest sum of the split.
	A subarray is a contiguous part of the array.
	
	Example 1:
	
	Input: nums = [7,2,5,10,8], k = 2
	Output: 18
	Explanation: There are four ways to split nums into two subarrays.
	The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
	Example 2:
	
	Input: nums = [1,2,3,4,5], k = 2
	Output: 9
	Explanation: There are four ways to split nums into two subarrays.
	The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SplitArrayLargestSum {

    // Method to split the array into k subarrays with the largest sum (less efficient approach)
    public int splitArray1(int[] nums, int k) {
        // If the number of subarrays (k) is greater than the length of the array, return -1
        if (k > nums.length) {
            return -1;
        }

        // Calculate the minimum and maximum possible sum of subarrays
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int num : nums) {
            max += num; // Calculate the maximum possible sum of all elements
            min = Math.max(min, num); // Find the minimum element in the array
        }

        // Try different sums from the minimum possible sum to the maximum possible sum
        for (int i = min; i <= max; i++) {
            int parts = getSubArraysCount(nums, i); // Get the count of subarrays with the current sum i
            if (parts <= k) {
                return i; // Return the largest sum if the number of subarrays matches k
            }
        }
        return min; // Return the minimum element if no match is found
    }

    // Method to split the array into k subarrays with the largest sum (more efficient approach using binary search)
    public int splitArray(int[] nums, int k) {
        if (k > nums.length) {
            return -1; // Return -1 if the number of subarrays (k) is greater than the length of the array
        }

        // Calculate the minimum and maximum possible sum of subarrays
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int num : nums) {
            max += num; // Calculate the maximum possible sum of all elements
            min = Math.max(min, num); // Find the minimum element in the array
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int parts = getSubArraysCount(nums, mid); // Get the count of subarrays with the current sum mid
            if (parts <= k) {
                high = mid - 1; // If parts (subarrays count) is less than or equal to k, adjust high
            } else {
                low = mid + 1; // If parts (subarrays count) is greater than k, adjust low
            }
        }
        return low; // Return the minimum largest sum of subarrays that satisfy the condition
    }

    // Helper method to get the count of subarrays with maximum sum less than or equal to a given sum
    private static int getSubArraysCount(int[] nums, int maxSum) {
        int count = 1;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] <= maxSum) {
                currentSum += nums[i]; // Add the current element to the currentSum
            } else {
                count++; // Increase count to indicate a new subarray
                currentSum = nums[i]; // Reset currentSum to the current element
            }
        }
        return count; // Return the count of subarrays with maximum sum less than or equal to maxSum
    }

    // Example usage in a main method
    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        int[] nums = {15, 10, 19, 10, 5, 18, 7};
        int k = 5;

        // Using the less efficient approach
        int result1 = solution.splitArray1(nums, k);
        System.out.println("Using splitArray1 method: " + result1);

        // Using the more efficient approach (binary search)
        int result2 = solution.splitArray(nums, k);
        System.out.println("Using splitArray method: " + result2);
    }
}
