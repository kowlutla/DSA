package com.dsa.bit_magic;

/**
 * Given an array arr[] of N positive integers. Find an integer denoting the
 * maximum XOR subset value in the given array arr[].
 */
public class MaximumSubsetXOR {
    // Method to find the maximum XOR subset value in the given array arr[]
    public static int maxSubsetXOR(int arr[], int n) {
        int index = 0;
        for (int i = 31; i >= 0; i--) {
            int maxElement = Integer.MIN_VALUE;
            int maxIndex = index;

            // Finding the maximum element in the array having the bit set at index i
            for (int j = index; j < n; j++) {
                if (((arr[j] & (1 << i)) != 0) && (arr[j] > maxElement)) {
                    maxElement = arr[j];
                    maxIndex = j;
                }
            }

            // If no element has the bit set at index i, skip to the next iteration
            if (maxElement == Integer.MIN_VALUE) {
                continue;
            }

            // Swapping the element at the current index with the maximum element
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            maxIndex = index;

            // Performing XOR operation on the elements having the bit set at index i
            for (int j = 0; j < n; j++) {
                if ((j != maxIndex) && ((arr[j] & (1 << i)) != 0)) {
                    arr[j] = arr[j] ^ arr[maxIndex];
                }
            }

            index++;
        }

        // Finding the maximum XOR value among the array elements
        int result = 0;
        for (int j = 0; j < n; j++) {
            result ^= arr[j];
        }
        return result;
    }

    // Main method for testing the maxSubsetXOR method
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 13, 3, 8, 6}; // Example input array
        int n = arr.length; // Size of the array

        // Call the maxSubsetXOR method and store the result
        int result = maxSubsetXOR(arr, n);

        // Print the result
        System.out.println("Maximum XOR subset value in the given array: " + result);
    }
}
