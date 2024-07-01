/**
 * 	Given an array arr[] of size n of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
	Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
	Note:  Return -1 if you can't reach the end of the array.
	
	Examples : 
	Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}, n = 11
	Output: 3 
	Explanation:First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 

	Input: arr = {1, 4, 3, 2, 6, 7}, n = 6
	Output: 2 
	Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
	
	Input: arr = {0, 10, 20}, n = 3
	Output: -1
	Explanation: We cannot go anywhere from the 1st element.
 */
package com.dsa.greedy;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD5JumpGameII {

    /**
     * Recursive method to find the minimum number of jumps needed to reach the end of the array.
     * @param arr the input array
     * @param n the length of the array
     * @return the minimum number of jumps
     */
    static int minJumps1(int[] arr, int n) {
        return minJumps1(arr, n - 1, 0, 0);
    }

    private static int minJumps1(int[] arr, int n, int index, int jumps) {
        if (index >= n) {
            return jumps; // Base case: if index is beyond the array, return the number of jumps
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            // Recursive call to find the minimum jumps from the current index
            min = Math.min(min, minJumps1(arr, n, index + i, jumps + 1));
        }
        return min; // Return the minimum jumps
    }

    /**
     * Dynamic Programming method to find the minimum number of jumps needed to reach the end of the array.
     * @param arr the input array
     * @param n the length of the array
     * @return the minimum number of jumps
     */
    public static int minJumps2(int[] arr, int n) {
        int[][] dp = new int[n][n];

        for (int[] d : dp) {
            Arrays.fill(d, -1); // Initialize the DP array with -1
        }
        minJumps2(arr, n - 1, 0, 0, dp);

        return dp[0][0] == Integer.MAX_VALUE ? -1 : dp[0][0]; // Return the result from the DP array
    }

    private static int minJumps2(int[] arr, int n, int index, int jumps, int[][] dp) {
        if (dp[index][jumps] != -1) {
            return dp[index][jumps]; // Return cached result if it exists
        }

        if (index >= n) {
            return dp[index][jumps] = jumps; // Base case: if index is beyond the array, return the number of jumps
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            if (index + i >= n) {
                min = jumps + 1; // If we can jump beyond the array, count this jump
            } else {
                // Recursive call to find the minimum jumps from the current index
                min = Math.min(min, minJumps2(arr, n, index + i, jumps + 1, dp));
            }
        }
        return dp[index][jumps] = min; // Cache and return the result
    }

    /**
     * Greedy method to find the minimum number of jumps needed to reach the end of the array.
     * @param arr the input array
     * @param n the length of the array
     * @return the minimum number of jumps
     */
    static int minJumps3(int[] arr, int n) {
        int jumps = 0, left = 0, right = 0;

        while (right < n - 1) {
            int longestJumps = 0;

            for (int i = left; i <= right; i++) {
                longestJumps = Math.max(longestJumps, i + arr[i]); // Find the farthest we can jump
            }

            if (longestJumps <= right) {
                return -1; // If we cannot progress, return -1
            }
            left = right + 1; // Update left boundary for the next jump range
            right = longestJumps; // Update right boundary for the next jump range
            jumps++; // Increment the jump counter
        }

        return jumps; // Return the total number of jumps
    }

    /**
     * Optimized Greedy method to find the minimum number of jumps needed to reach the end of the array.
     * @param arr the input array
     * @param n the length of the array
     * @return the minimum number of jumps
     */
    static int minJumps4(int[] arr, int n) {
        if (n == 1) {
            return 0; // If there's only one element, no jumps are needed
        }

        if (arr[0] == 0) {
            return -1; // If the first element is 0, we cannot make any jumps
        }

        int maxRange = arr[0]; // Initialize the maximum range we can reach
        int step = 0, jump = 0;

        for (int i = 0; i < n; i++) {
            step = Math.max(step, i + arr[i]); // Update the farthest we can reach
            if (i == maxRange) {
                maxRange = step; // Update max range when we reach the end of the current range
                jump++; // Increment the jump counter
            }
            if (maxRange >= n - 1) {
                return jump + 1; // If we can reach the end, return the total number of jumps
            }
        }

        return -1; // If we cannot reach the end, return -1
    }
}
