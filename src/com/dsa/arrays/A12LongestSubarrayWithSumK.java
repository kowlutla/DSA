/**
 * 	You are given an array 'a' of size 'n' and an integer 'k'.
	
	Find the length of the longest subarray of 'a' whose sum is equal to 'k'.
	
	Example :
	Input: ‘n’ = 7 ‘k’ = 3
	‘a’ = [1, 2, 3, 1, 1, 1, 1]
	Output: 3
	
	Explanation: Subarrays whose sum = ‘3’ are:
	[1, 2], [3], [1, 1, 1] and [1, 1, 1]
	
	Here, the length of the longest subarray is 3, which is our final answer.
	Detailed explanation ( Input/output format, Notes, Images )
	
	Sample Input 1 :
	7 3
	1 2 3 1 1 1 1
	Sample Output 1 :
	3
	Explanation Of Sample Input 1 :
	Subarrays whose sum = ‘3’ are:
	[1, 2], [3], [1, 1, 1] and [1, 1, 1]
	Here, the length of the longest subarray is 3, which is our final answer.
	
	Sample Input 2 :
	4 2
	1 2 1 3
	Sample Output 2 :
	1
	
	Sample Input 3 :
	5 2
	2 2 4 1 2 
	Sample Output 3 :
	1
	
	Expected time complexity :
	The expected time complexity is O(n).
	Constraints :
	1 <= 'n' <= 5 * 10 ^ 6
	1 <= 'k' <= 10^18
	0 <= 'a[i]' <= 10 ^ 9

 */
package com.dsa.arrays;

import java.util.HashMap;

/**
 * @author KowlutlaSwamy
 *
 */
public class A12LongestSubarrayWithSumK {

    /**
     * Finds the length of the longest subarray with a given sum K using brute force (nested loops).
     * Time complexity: O(N^2) - iterates through all possible subarrays using nested loops, resulting in N iterations for the outer loop and potentially N iterations for the inner loop in the worst case.
     * Space complexity: O(1) - uses constant extra space for variables (max, n, currentSum).
     *
     * @param a The input array containing integers.
     * @param k The target sum to find a subarray with.
     * @return The length of the longest subarray with sum K.
     */
    public static int longestSubarrayWithSumK1(int[] a, long k) {
        int max = 0;
        int n = a.length;

        // Outer loop iterates over all starting indices of subarrays (N times)
        for (int i = 0; i < n; i++) {
            long currentSum = 0;

            // Inner loop iterates over all subarrays starting at index i (potentially N times)
            for (int j = i; j < n; j++) {
                currentSum += a[j];
                if (currentSum == k) {
                    max = Math.max(max, j - i + 1); // Update max length if current sum is K
                }

                if (currentSum > k) {
                    break; // Stop inner loop if sum exceeds K
                }
            }
        }

        return max;
    }

    /**
     * Finds the length of the longest subarray with a given sum K using a sliding window approach.
     * Time complexity: O(N) - iterates through the input array once using two pointers.
     * Space complexity: O(1) - uses constant extra space for variables (currentSum, left, right, n, maxLength).
     *
     * @param a The input array containing integers.
     * @param k The target sum to find a subarray with.
     * @return The length of the longest subarray with sum K.
     */
    public static int longestSubarrayWithSumK2(int[] a, long k) {

        int currentSum = 0;
        int left = 0;
        int right = 0;
        int n = a.length;
        int maxLength = 0;

        while (right < n) {
            currentSum += a[right]; // Add the current element to the window sum

            if (currentSum < k) {
                right++; // Expand the window by moving the right pointer
            } else if (currentSum == k) {
                maxLength = Math.max(maxLength, right - left + 1); // Update max length if current sum is K
                right++; // Can potentially shrink the window later
            } else {

                while (left <= right && currentSum > k) {
                    currentSum -= a[left]; // Shrink the window by removing elements from the left
                    left++;
                }

                if (currentSum == k) {
                    maxLength = Math.max(maxLength, right - left + 1); // Update max length if current sum is K after shrinking
                }
                right++; // May expand the window again
            }
        }

        return maxLength;
    }

    /**
     * Finds the length of the longest subarray with a given sum K using a HashMap.
     * Time complexity: O(N) - iterates through the input array once.
     * Space complexity: O(N) - uses a HashMap to store cumulative sums and their indices, potentially storing up to N entries in the worst case.
     *
     * @param a The input array containing integers.
     * @param k The target sum to find a subarray with.
     * @return The length of the longest subarray with sum K.
     */
    public static int longestSubarrayWithSumK3(int[] a, long k) {
        HashMap<Long, Integer> map = new HashMap<>(); // HashMap to store cumulative sums and their indices
        long currentSum = 0; // Keeps track of the current sum of elements encountered so far
        int maxLength = 0;  // Stores the maximum length of a subarray with sum K

        for (int i = 0; i < a.length; i++) {
            currentSum += a[i]; // Add the current element to the running sum

            if (currentSum == k) {  // If current sum itself is K, the entire subarray from the beginning has sum K
                maxLength = Math.max(maxLength, i + 1); // Update maxLength with length from beginning to current index (i+1)
            }

            long remainingSum = currentSum - k; // Calculate the sum needed to complete a subarray with sum K from currentSum
            if (map.containsKey(remainingSum)) { // Check if a previous subarray had a sum equal to remainingSum
                maxLength = Math.max(maxLength, i - map.get(remainingSum)); // Update maxLength if the current subarray (from map index to current) is longer
            }

            if (!map.containsKey(currentSum)) { // If currentSum is not already in the map, store it for future potential matches
                map.put(currentSum, i);  // Store currentSum and its index in the map
            }
        }

        return maxLength;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 2, 0};
        long k = 15;

        int len1 = longestSubarrayWithSumK1(arr, k);
        int len2 = longestSubarrayWithSumK2(arr, k);
        int len3 = longestSubarrayWithSumK3(arr, k);

        System.out.println("Length of longest subarray with sum K (brute force): " + len1);
        System.out.println("Length of longest subarray with sum K (sliding window): " + len2);
        System.out.println("Length of longest subarray with sum K (HashMap): " + len3);
    }
}
