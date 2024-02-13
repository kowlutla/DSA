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

public class DP43PrintLongestIncreasingSubSequence {

    // Method to print the longest increasing subsequence of an array
    public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
        // Initialize arrays to store length of LIS ending at each index and the previous index in the LIS
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        // Initialize all values of dp to 1 (minimum length of LIS is 1)
        Arrays.fill(dp, 1);
        // Initialize variables to track the maximum length of LIS and the index of its last element
        int max = 1;
        int lastIndex = 0;
        
        // Iterate through the array
        for (int current = 0; current < arr.length; current++) {
            // Iterate through the elements before the current element
            for (int prev = 0; prev < current; prev++) {
                // If the current element is greater than the previous and the length of LIS ending at previous element + 1
                // is greater than the current length of LIS ending at the current element
                if (arr[current] > arr[prev] && dp[prev] + 1 > dp[current]) {
                    // Update the length of LIS ending at the current element
                    dp[current] = dp[prev] + 1;
                    // Update the previous index in the LIS
                    hash[current] = prev;
                }
            }
            // Update the maximum length of LIS and the index of its last element
            if (dp[current] > max) {
                max = dp[current];
                lastIndex = current;
            }
        }

        // Initialize a list to store the elements of the longest increasing subsequence
        List<Integer> result = new ArrayList<>();
        // Add the last element of the LIS to the result list
        // Traverse backwards through the LIS using the previous indices until reaching the first element
        while (hash[lastIndex] != lastIndex) {
        	 result.add(arr[lastIndex]);
        	lastIndex = hash[lastIndex];
        }
        // Reverse the list to get the elements in increasing order
        Collections.reverse(result);
        // Return the longest increasing subsequence
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 0, 6, 2, 3}; // Sample array
        int x = arr.length;

        // Print the longest increasing subsequence
        List<Integer> lis = printingLongestIncreasingSubsequence(arr, x);
        System.out.println("Longest Increasing Subsequence: " + lis);
    }
}
