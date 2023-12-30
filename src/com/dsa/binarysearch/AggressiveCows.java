/**
 * Problem Statement: You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls.
	You are also given an integer ‘k’ which denotes the number of aggressive cows.
	You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible.
	Find the maximum possible minimum distance.
	
	Example 1:
	Input Format: N = 6, k = 4, arr[] = {0,3,4,7,10,9}
	Result: 3
	Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. 
	Here the distances between cows are 3, 4, and 3 respectively. 
	We cannot make the minimum distance greater than 3 in any ways.
	
	Example 2:
	Input Format: N = 5, k = 2, arr[] = {4,2,1,3,6}
	Result: 5
	Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}. 
 */
package com.dsa.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    // Method to find the maximum possible minimum distance between cows (less efficient approach)
    public static int aggressiveCows1(int[] stalls, int k) {
        if (stalls.length < k) {
            return -1; // Return -1 if the number of stalls is less than the number of cows
        }
        Arrays.sort(stalls); // Sort the stalls
        int max = stalls[stalls.length - 1] - stalls[0]; // Calculate the maximum possible distance
        int ans = -1;
        for (int i = 1; i <= max; i++) {
            // Check if it's possible to place cows with a minimum distance of i
            if (isPossible(stalls, k, i)) {
                ans = i; // Update the answer if placing cows with distance i is possible
            } else {
                break; // Break the loop if it's not possible for the current distance
            }
        }
        return ans; // Return the maximum possible minimum distance
    }

    // Method to find the maximum possible minimum distance between cows (more efficient approach using binary search)
    public static int aggressiveCows(int[] stalls, int k) {
        if (stalls.length < k) {
            return -1; // Return -1 if the number of stalls is less than the number of cows
        }
        Arrays.sort(stalls); // Sort the stalls
        int max = stalls[stalls.length - 1] - stalls[0]; // Calculate the maximum possible distance
        int low = 1, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if it's possible to place cows with a minimum distance of mid
            if (isPossible(stalls, k, mid)) {
                low = mid + 1;//if possible with distance of 'mid' then don't need to check left as we are seeking for maximum distance
            } else {
                high = mid - 1;//if not possible with distance of 'mid' then not possible with distance greater than mid, so look only in left half
            }
        }
        return high; // Return the maximum possible minimum distance
    }

    // Helper method to check if it's possible to place cows with a minimum distance
    private static boolean isPossible(int[] stalls, int k, int distance) {
        int cows = 1;
        int lastCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCow >= distance) {
                cows++;
                lastCow = stalls[i];
            }
        }
        return cows >= k; // Return true if it's possible to place k cows with the given distance
    }

    // Example usage in a main method
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; // Sample stalls
        int k = 3; // Number of cows

        // Using the less efficient approach
        int result1 = aggressiveCows1(stalls, k);
        System.out.println("Using aggressiveCows1 method: " + result1);

        // Using the more efficient approach (binary search)
        int result2 = aggressiveCows(stalls, k);
        System.out.println("Using aggressiveCows method: " + result2);
    }
}
