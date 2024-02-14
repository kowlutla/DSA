/**
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 */
package com.dsa.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP44LargestDivisibleSubset {

    // Finds the largest divisible subset in a sorted array of integers
    public static List<Integer> largestDivisibleSubset(int[] arr) {
        // Initialize variables
        int max = 1;                                           // Max length of the subset found so far
        int n = arr.length;                                     // Number of elements in the array
        int[] hash = new int[n];                                // Stores the index of the previous element in the subset
        int[] dp = new int[n];                                // Stores the length of the longest subset ending at each index

        // Fill dp array with 1, indicating all single-element subsets are valid
        Arrays.fill(dp, 1);

        // Initialize last element in the subset
        int lastIndex = 0;

        // Sort the array to ensure divisibility check order
        Arrays.sort(arr);

        // Iterate through each element in the array
        for (int current = 0; current < n; current++) {
            // Set the current element's index in the hash array
            hash[current] = current;

            // Iterate through all previous elements
            for (int prev = 0; prev < current; prev++) {
                // Check if current element is divisible by previous element
                if (arr[current] % arr[prev] == 0 && dp[prev] + 1 > dp[current]) {
                    // Update length of the subset ending at current element
                    dp[current] = dp[prev] + 1;
                    // Update the index of the previous element in the subset
                    hash[current] = prev;
                }
            }

            // Update max length and last element index if current subset is longer
            if (dp[current] > max) {
                max = dp[current];
                lastIndex = current;
            }
        }

        // Create a list to store the elements of the largest divisible subset
        List<Integer> result = new ArrayList<>();

        // Add the last element of the subset
        result.add(arr[lastIndex]);

        // Backtrack through the subset using the hash array
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }

        // Reverse the list to get the subset in ascending order
        Collections.reverse(result);

        // Return the largest divisible subset
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] arr = {1, 8, 4, 6, 2};
        List<Integer> subset = largestDivisibleSubset(arr);
        System.out.println("Largest divisible subset: " + subset);
    }
}
