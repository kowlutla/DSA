/**
	Problem Statement: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. 
	Find how many times the array has been rotated. 
 * 
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SortedArrayRotation {

    // Main method to test the findKRotation function
    public static void main(String[] args) {
        // Test case
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int result = findKRotation(arr);
        System.out.println("Number of rotations: " + result); // Expected Output: 4 (rotated 4 times)
    }

    // Method to find the number of rotations in a sorted rotated array
    public static int findKRotation(int[] arr) {
        // Initialize pointers and variables
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE, index = -1;

        // Perform binary search
        while (low <= high) {
            // If left pointer element is less than or equal to right pointer element
            if (arr[low] <= arr[high]) {
                // Check if the current element is smaller than the answer
                if (arr[low] < ans) {
                    index = low; // Update index to current low pointer
                    ans = arr[low]; // Update answer with current low pointer value
                }
                break; // Exit the loop since the array is sorted
            }

            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                // Check if the current element is smaller than the answer
                if (arr[low] < ans) {
                    ans = arr[low]; // Update answer with current low pointer value
                    index = low; // Update index to current low pointer
                }
                low = mid + 1; // Move left pointer to the right half
            } else {
                // Check if the current element is smaller than the answer
                if (arr[mid] < ans) {
                    ans = arr[mid]; // Update answer with current mid pointer value
                    index = mid; // Update index to current mid pointer
                }
                high = mid - 1; // Move right pointer to the left half
            }
        }
        return index; // Return the index where rotation occurs
    }
}
