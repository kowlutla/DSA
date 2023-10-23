package com.dsa.arrays;

/**
 * Given an array of N integers arr[] where each element represents the maximum
 * length of the jump that can be made forward from that element. This means if
 * arr[i] = x, then we can jump any distance y such that y ≤ x. Find the minimum
 * number of jumps to reach the end of the array (starting from the first
 * element). If an element is 0, then you cannot move through that element.
 * 
 * Note: Return -1 if you can't reach the end of the array.
 */
public class MinimumNumberOfJumps {

    // Method to find the minimum number of jumps to reach the end of the array
    static int minJumps(int[] arr) {
        // If the array length is less than or equal to 1, return 0
        if (arr.length <= 1) {
            return 0;
        }

        // If the first element of the array is 0, return -1
        if (arr[0] == 0) {
            return -1;
        }

        // Initialize variables for jumps, current step, and maximum reachable range
        int jumps = 0;
        int step = 0;
        int maxRange = arr[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update the step as the maximum of the current step and the current index plus the value at that index
            step = Math.max(step, i + arr[i]);

            // If the current index is equal to the maximum reachable range, update the maximum reachable range and increment jumps
            if (i == maxRange) {
                maxRange = step;
                jumps++;
            }

            // If the maximum reachable range is greater than or equal to the last index of the array, return jumps + 1
            if (maxRange >= arr.length - 1) {
                return jumps + 1;
            }
        }

        // Return -1 if the end of the array cannot be reached
        return -1;
    }

    // Main method to test the MinimumNumberOfJumps functionality
    public static void main(String[] args) {
        // Example usage
        int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println("Minimum number of jumps required: " + minJumps(arr));
    }
}
