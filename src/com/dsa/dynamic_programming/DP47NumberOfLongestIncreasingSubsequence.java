/**
 * 	Given an integer array arr, return the number of longest increasing subsequences.
	
	Notice that the sequence has to be strictly increasing.
	
	Example:
	Input:
	n = 5
	arr = [1,3,5,4,7]
	Output:
	2
	Explanation:
	The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP47NumberOfLongestIncreasingSubsequence {

    /**
     * This method finds the number of longest increasing subsequences (LIS) in an array of integers.
     *
     * @param arr The input array of integers.
     * @return The number of LIS in the array.
     */
    public int NumberofLIS(int[] arr) {
        int N = arr.length;

        // Create arrays to store the length of the LIS ending at each index and the count of LIS with that length.
        int[] dp = new int[N];  // dp[i] stores the length of the LIS ending at index i
        int[] count = new int[N];  // count[i] stores the count of LIS with length dp[i] ending at index i

        // Initialize all values to 1, considering each element itself as a subsequence of length 1.
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1; // Keep track of the maximum LIS length found so far.

        // Iterate through the array to build the LIS and count.
        for (int current = 0; current < N; current++) {
            for (int prev = 0; prev < current; prev++) {
                // If the current element is greater than the previous element and including it increases the LIS length:
                if (arr[current] > arr[prev]) {
                    // If the new LIS length is greater than the current one, update both length and count.
                    if (dp[prev] + 1 > dp[current]) {
                        dp[current] = dp[prev] + 1;
                        count[current] = count[prev]; // Only 1 subsequence with this new length so far.
                    } else if (dp[current] == dp[prev] + 1) { // If new length equals current max:
                        // Increase the count of LIS with this length by the count of LIS ending at the previous element.
                        count[current] += count[prev];
                    }
                }
            }

            // Update the max length if a longer LIS is found.
            max = Math.max(dp[current], max);
        }

        // Count the total number of LIS with the maximum length.
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }

        return result;
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        DP47NumberOfLongestIncreasingSubsequence lis = new DP47NumberOfLongestIncreasingSubsequence();
        int numLIS = lis.NumberofLIS(arr);
        System.out.println("Number of LIS: " + numLIS);  // Output: 4
    }
}
