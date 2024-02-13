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

    public static ArrayList<Integer> printingLongestIncreasingSubsequence(int arr[], int n) {
        // Initialize arrays to store length of LIS ending at each index and the previous index in the LIS
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        
        // Initialize all values of dp and hash to 1 (minimum length of LIS is 1)
        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);

        // Iterate through the array to calculate the length of LIS ending at each index
        for (int current = 0; current < arr.length; current++) {
            // Set the default previous index in the LIS to the current index
            hash[current] = current;
            
            // Iterate through the elements before the current element
            for (int prev = 0; prev < current; prev++) {
                // If the current element is greater than the previous and the
                // length of LIS ending at previous element + 1 is greater than the current length of LIS ending at the current element
                if (arr[current] > arr[prev] && dp[prev] + 1 > dp[current]) {
                    // Update the length of LIS ending at the current element
                    dp[current] = dp[prev] + 1;
                    // Update the previous index in the LIS
                    hash[current] = prev;
                }
            }
        }

        // Find the maximum length of LIS and its last index
        int ans = -1;
        int lastIndex = -1;
        for (int i = 0; i < n ; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        // Initialize an ArrayList to store the longest increasing subsequence
        ArrayList<Integer> temp = new ArrayList<>();
        // Add the last element of the LIS to the ArrayList
        temp.add(arr[lastIndex]);

        // Traverse backwards through the LIS using the previous indices until reaching the first element
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // Sort the ArrayList to get the elements in increasing order
        Collections.sort(temp);
        // Return the longest increasing subsequence
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, 4, -1, 0, 6, 2, 3}; // Sample array
        int x = arr.length;

        // Print the longest increasing subsequence
        List<Integer> lis = printingLongestIncreasingSubsequence(arr, x);
        System.out.println("Longest Increasing Subsequence: " + lis);
    }
}
