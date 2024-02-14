/**
 * 
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DP42PrintLongestIncreasingSubSequence {

	/**
	 * This function finds the longest increasing subsequence (LIS) in an array and returns it as a list.
	 *
	 * @param arr The input array.
	 * @return A list containing the elements of the LIS.
	 */
	public static List<Integer> printingLongestIncreasingSubsequence(int[] arr) {
	    // Initialize the dp array to store the length of the LIS ending at each index.
	    int[] dp = new int[arr.length];
	    Arrays.fill(dp, 1); // Initially, each element forms a subsequence of length 1.

	    // Initialize the hash array to store the index of the previous element in the LIS.
	    int[] hash = new int[arr.length];
	    for (int i = 0; i < arr.length; i++) {
	        hash[i] = i; // Initially, each element points to itself.
	    }

	    // Find the longest increasing subsequence ending at each index.
	    int max = 1;  // Track the maximum length found so far.
	    int lastIndex = 0;  // Index of the last element in the LIS.
	    for (int current = 1; current < arr.length; current++) {
	        for (int prev = 0; prev < current; prev++) {
	            // If the current element is greater than the previous element and
	            // the length of the LIS ending at the previous element + 1 is greater
	            // than the current length, update the length and hash value.
	            if (arr[current] > arr[prev] && dp[prev] + 1 > dp[current]) {
	                dp[current] = dp[prev] + 1;
	                hash[current] = prev;
	            }
	        }

	        // If the length of the LIS ending at the current element is greater than
	        // the maximum length found so far, update the max and lastIndex.
	        if (dp[current] > max) {
	            max = dp[current];
	            lastIndex = current;
	        }
	    }

	    // Reconstruct the LIS using the hash array.
	    List<Integer> result = new ArrayList<>();
	    result.add(arr[lastIndex]); // Add the last element of the LIS.
	    while (lastIndex != hash[lastIndex]) {
	        // Traverse the LIS backwards using the hash values.
	        lastIndex = hash[lastIndex];
	        result.add(arr[lastIndex]);
	    }

	    // Reverse the result to get the LIS in ascending order.
	    Collections.reverse(result);

	    return result;
	}

    public static void main(String[] args) {
        int[] arr = {40, 30, 14, 25, 24, 25, 42, 37, 46, 9, 30, 39}; // Sample array

        // Print the longest increasing subsequence
        List<Integer> lis = printingLongestIncreasingSubsequence(arr);
        System.out.println("Longest Increasing Subsequence: " + lis);
    }
}
