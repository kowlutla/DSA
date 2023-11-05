package com.dsa.arrays;

/**
 * Given an array A[] of N positive integers. The task is to find the maximum of
 * j - i subjected to the constraint of A[i] < A[j] and i < j.
 */
public class MaximumIndex {

    // Brute-force method to find the maximum difference j - i
    static int maxIndexDiff1(int arr[], int n) {
        int result = 0; // Initialize the result to 0
        for (int i = 0; i < n; i++) { // Iterate through the array
            for (int j = i + 1; j < n; j++) { // Iterate through the remaining elements from i
                if (arr[i] <= arr[j]) { // Check if A[i] is less than or equal to A[j]
                    result = Math.max(result, j - i); // Update the result if j - i is greater
                }
            }
        }
        return result; // Return the maximum difference
    }

    // Optimized method to find the maximum difference j - i
    static int maxIndexDiff(int arr[], int n) {
        int[] min = new int[n]; // Create an array to store the minimum element encountered so far from the left
        int[] max = new int[n]; // Create an array to store the maximum element encountered so far from the right

        min[0] = arr[0]; // Initialize the first element of min array
        for (int i = 1; i < n; i++) { // Iterate through the array from the second element
            min[i] = Math.min(arr[i], min[i - 1]); // Update the min array with the minimum element encountered so far
        }

        max[n - 1] = arr[n - 1]; // Initialize the last element of max array
        for (int i = n - 2; i >= 0; i--) { // Iterate through the array from the second last element
            max[i] = Math.max(arr[i], max[i + 1]); // Update the max array with the maximum element encountered so far
        }

        int i = 0, j = 0; // Initialize two pointers i and j
        int result = 0; // Initialize the result to 0
        // Traverse the arrays and find the maximum difference j - i satisfying the constraints
        while (i < n && j < n) {
            if (min[i] <= max[j]) { // Check if the current elements satisfy the constraints
                result = Math.max(result, (j - i)); // Update the result if j - i is greater
                j++; // Increment j
            } else {
                i++; // Increment i
            }
        }

        return result; // Return the maximum difference
    }
    
    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int n = arr.length;
        System.out.println("Using brute-force method: " + maxIndexDiff1(arr, n));
        System.out.println("Using optimized method: " + maxIndexDiff(arr, n));
    }
    
}
