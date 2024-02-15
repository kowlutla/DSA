/**
 *  Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
	A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
 
	Example 1:
	Input: nums = [1, 2, 5, 3, 2]
	Output: 5
	Explanation: The sequence {1, 2, 5} is
	increasing and the sequence {3, 2} is 
	decreasing so merging both we will get 
	length 5.

	Example 2:
	Input: nums = [1, 11, 2, 10, 4, 5, 2, 1]
	Output: 6
	Explanation: The bitonic sequence 
	{1, 2, 10, 4, 2, 1} has length 6.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP46LongestBitonicSubsequence {

    /**
     * Finds the length of the longest bitonic subsequence (LIS) in an array of integers.
     * A bitonic subsequence is a sequence that is first increasing, then decreasing,
     * with at least one element in each sequence (increasing or decreasing).
     *
     * @param nums The input array of integers.
     * @return The length of the longest bitonic subsequence in the array.
     */
    public static int longestBitonicSequence(int[] nums) {
        int n = nums.length;

        // Create arrays to store increasing and decreasing subsequence lengths for each element:
        int[] dp1 = new int[n];  // Length of increasing subsequence ending at index i
        int[] dp2 = new int[n];  // Length of decreasing subsequence starting at index i

        // Initialize all values to 1, assuming each element itself forms a subsequence of length 1 initially.
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Calculate increasing subsequences (bottom-up)
        for (int current = 0; current < n; current++) {
            for (int prev = 0; prev < current; prev++) {
                // If the current element is greater than the previous element and including it increases the subsequence length, update dp1.
                if (nums[current] > nums[prev] && dp1[prev] + 1 > dp1[current]) {
                    dp1[current] = dp1[prev] + 1;
                }
            }
        }

        // Calculate decreasing subsequences (top-down)
        for (int current = n - 1; current >= 0; current--) {
            for (int ahead = n - 1; ahead > current; ahead--) {
                // If the current element is greater than the ahead element and including it increases the subsequence length, update dp2.
                if (nums[current] > nums[ahead] && dp2[ahead] + 1 > dp2[current]) {
                    dp2[current] = dp2[ahead] + 1;
                }
            }
        }

        // Combine increasing and decreasing lengths to find potential bitonic lengths:
        int[] bitonic = new int[n];
        int max = 1;  // Track the maximum length found so far
        for (int i = 0; i < n; i++) {
            // Calculate potential bitonic subsequence length at index i (minus 1 to avoid double counting the current element).
            bitonic[i] = dp1[i] + dp2[i] - 1;
            // Update max if a longer bitonic subsequence is found.
            max = Math.max(max, bitonic[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 6, 10, 1, 12};
        int length = longestBitonicSequence(nums);
        System.out.println("Length of longest bitonic subsequence: " + length);  // Output: 6
    }
}
