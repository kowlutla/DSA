/**
 * 	Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
	
	Example 1:
	Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
	Output: 6
	Explanation: [1,1,1,0,0,1,1,1,1,1,1]
	Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

	Example 2:
	Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
	Output: 10
	Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
	Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A10MaxConsecutiveOnes2 {

    /**
     * Finds the longest substring of ones with at most K flips allowed.
     * Time complexity: O(N) - iterates through the input array using a sliding window approach.
     * Space complexity: O(1) - uses constant extra space for variables (maxCons, left, right, and k).
     *
     * @param nums The input array containing 0s and 1s.
     * @param k The maximum number of flips allowed.
     * @return The length of the longest substring of ones with at most K flips allowed.
     */
    public int longestOnes(int[] nums, int k) {
        int maxCons = 0; // Stores the longest substring of ones found so far
        int left = 0, right = 0; // Pointers for the sliding window
        int windowFlips = 0; // Stores the number of flips used within the current window

        while (right < nums.length) {
            // Update windowFlips based on the current element in the window
            windowFlips += 1 - nums[right];

            // If flips exceed allowed limit, shrink window from left
            if (windowFlips > k) {
                windowFlips -= 1 - nums[left]; // Remove the flip used by removing leftmost element
                left++;
            } else {
                // Update maxCons if the current window length is greater
                maxCons = Math.max(maxCons, right - left + 1);
            }
            right++; // Always move the right pointer to expand the window
        }

        return maxCons;
    }

    // Main method for testing
    public static void main(String[] args) {
        A10MaxConsecutiveOnes2 obj = new A10MaxConsecutiveOnes2();

        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0};
        int k1 = 3;

        int[] nums2 = {0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0};
        int k2 = 2;

        int maxOnes1 = obj.longestOnes(nums1, k1);
        int maxOnes2 = obj.longestOnes(nums2, k2);

        System.out.println("Longest substring of ones with at most " + k1 + " flips (array 1): " + maxOnes1);
        System.out.println("Longest substring of ones with at most " + k2 + " flips (array 2): " + maxOnes2);
    }
}
