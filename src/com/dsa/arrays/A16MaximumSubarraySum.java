/**
 * 	You are given an array 'arr' of length 'n', consisting of integers.
	A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or more integers from the beginning and 0 or more integers from the end of an array.
	Find the sum of the subarray (including empty subarray) having maximum sum among all subarrays.
	The sum of an empty subarray is 0.

	Example :
	Input: 'arr' = [1, 2, 7, -4, 3, 2, -10, 9, 1]
	Output: 11
	Explanation: The subarray yielding the maximum sum is [1, 2, 7, -4, 3, 2].
	Detailed explanation ( Input/output format, Notes, Images )

	Sample Input 1 :
	9
	1 2 7 -4 3 2 -10 9 1
	Sample Output 1 :
	11
	Explanation for Sample 1 :
	The subarray yielding the maximum sum is [1, 2, 7, -4, 3, 2].
	
	Sample Input 2 :
	6
	10 20 -30 40 -50 60
	Sample Output 2 :
	60
	
	Sample Input 3 :
	3
	-3 -5 -6
	Sample Output 3 :
	0
	The expected time complexity is O(n).
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A16MaximumSubarraySum {
    
    // Private constructor to prevent object creation
    private A16MaximumSubarraySum() {}

    /**
     * Finds the maximum subarray sum in a given array.
     *
     * @param arr The input array
     * @param n   The size of the array
     * @return The maximum subarray sum
     */
    public static long maxSubarraySum(int[] arr, int n) {
        // Initialize variables for tracking the maximum sum and current sum
        long maxSum = Integer.MIN_VALUE;  // Initialize maxSum to the smallest possible integer value
        long currentSum = 0;              // Initialize currentSum to 0

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Add the current element to the current sum
            currentSum += arr[i];

            // If the current sum becomes negative, reset it to 0 (start a new subarray)
            if (currentSum < 0) {
                currentSum = 0;
            }

            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};
        int n = arr.length;

        long maxSubarraySum = maxSubarraySum(arr, n);
        System.out.println("Maximum subarray sum: " + maxSubarraySum);
    }
}
