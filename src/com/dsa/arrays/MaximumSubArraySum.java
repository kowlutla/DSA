package com.dsa.arrays;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array (containing
 * at least one number) which has the maximum sum and return its sum.
 */
public class MaximumSubArraySum {

    // Function to find the maximum sum of a contiguous sub-array
    long maxSubarraySum1(int arr[], int n) {
        // Initialize a variable to store the maximum sum, setting it to the smallest possible value initially
        long maxSum = Integer.MIN_VALUE;

        // Loop through the array
        for (int i = 0; i < n; i++) {
            // Initialize variables for the current sum and the maximum sum at the current index
            int currentSum = arr[i];
            int currentMax = arr[i];

            // Iterate through the sub-array from the current index to the end
            for (int j = i + 1; j < n; j++) {
                // Update the current sum by adding the current element
                currentSum += arr[j];

                // Update the current maximum sum if the current sum is greater
                currentMax = Math.max(currentMax, currentSum);
            }

            // Update the overall maximum sum if the current maximum sum is greater
            maxSum = Math.max(maxSum, currentMax);
        }

        // Return the maximum sum of the contiguous sub-array
        return maxSum;

    }
    
 // Using Kadane's algorithm to find the maximum subarray sum
    long maxSubarraySum2(int arr[], int n){
        // Initialize variables for the current maximum and the overall maximum sum, setting them to the first element of the array initially
        long currentMax = arr[0];
        long maxSum = arr[0];
        
        // Loop through the array starting from the second element
        for(int i=1; i<n; i++){
            // Update the current maximum by taking the maximum of the sum of the current element and the current maximum, or the current element itself
            currentMax = Math.max(currentMax + arr[i], arr[i]);

            // Update the overall maximum sum by taking the maximum of the current maximum and the previous overall maximum
            maxSum = Math.max(maxSum, currentMax);
        }
        
        // Return the maximum sum of the subarray
        return maxSum;
    }
    
    // Main method to test the maximum subarray sum functionality
    public static void main(String[] args) {
        // Example usage
        MaximumSubArraySum obj = new MaximumSubArraySum();
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = arr.length;
        System.out.println("Maximum contiguous sum is " + obj.maxSubarraySum2(arr, n));
    }

}
