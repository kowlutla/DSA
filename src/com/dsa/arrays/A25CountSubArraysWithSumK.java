/**
 * 	Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

	Example 1:
	Input:
	N = 5
	Arr = {10 , 2, -2, -20, 10}
	k = -10
	Output: 3
	Explaination: 
	Subarrays: arr[0...3], arr[1...4], arr[3..4]
	have sum exactly equal to -10.
	
	Example 2:
	Input:
	N = 6
	Arr = {9, 4, 20, 3, 10, 5}
	k = 33
	Output: 2
	Explaination: 
	Subarrays : arr[0...2], arr[2...4] have sum
	exactly equal to 33.
 */
package com.dsa.arrays;

import java.util.HashMap;

public class A25CountSubArraysWithSumK {

    /**
     * Method 1: Brute Force Approach to find the number of subarrays with sum k.
     * Time Complexity: O(N^2), where N is the length of the array.
     * Space Complexity: O(1), no extra space is used except for variables.
     * 
     * @param arr The input array.
     * @param n The length of the array.
     * @param k The target sum for the subarrays.
     * @return The count of subarrays whose sum is equal to k.
     */
    public static int findSubArraySum1(int[] arr, int n, int k) {
        int count = 0;

        // Iterate through each element of the array as the starting point
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // Iterate through each subsequent element to find subarray sums
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // Check if the current subarray sum equals k
                if (sum == k) {
                    count++;
                }
            }
        }

        return count; // Return the total count of subarrays with sum k
    }

    /**
     * Method 2: Optimized Approach using HashMap to find the number of subarrays with sum k.
     * Time Complexity: O(N), where N is the length of the array.
     * Space Complexity: O(N), for the HashMap used to store prefix sums.
     * 
     * @param arr The input array.
     * @param n The length of the array.
     * @param k The target sum for the subarrays.
     * @return The count of subarrays whose sum is equal to k.
     */
    public static int findSubArraySum2(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Initialize the map with the prefix sum of 0 (base case)
        map.put(0, 1);

        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i]; // Update the prefix sum

            // Check if there is a prefix sum that when subtracted from the current prefix sum equals k
            int rem = prefixSum - k;
            count += map.getOrDefault(rem, 0);

            // Update the map with the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the total count of subarrays with sum k
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int n = arr.length;
        int k = -10;

        // Test Method 1
        System.out.println("Count of subarrays with sum " + k + " using brute force: " + findSubArraySum1(arr, n, k));

        // Test Method 2
        System.out.println("Count of subarrays with sum " + k + " using optimized approach: " + findSubArraySum2(arr, n, k));
    }
}
