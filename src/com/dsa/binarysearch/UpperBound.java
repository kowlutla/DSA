package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 * 
 * Given an array arr sorted in non-decreasing order and a number x, 
 * this class provides a method to return the index of the upper bound of x.
 * 
 * upper bound: smallest number which is > x
 */
public class UpperBound {
    // Method to find the upper bound of x in the given sorted array arr
    public static int upperBound(int[] arr, int x, int n) {
        // Calls the binary search method to find the upper bound of x
        return binarySearch(arr, 0, n - 1, x);
    }
    
    // Binary search method to find the upper bound of x in the array
    private static int binarySearch(int[] arr, int start, int end, int x) {
        int result = end + 1; // Initialize result as end + 1
        
        // Perform binary search until start is less than or equal to end
        while (start <= end) {
            int mid = start + (end - start) / 2; // Calculate the middle index
            
            // If the middle element is greater than x
            if (arr[mid] > x) {
                result = mid; // Update result to current middle index
                end = mid - 1; // Move to the left half
            } else {
                start = mid + 1; // Move to the right half
            }
        }
        
        return result; // Return the upper bound index of x
    }
    
    // Main method for testing purposes
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int x = 6;
        int n = arr.length;
        
        // Find the upper bound of x in the array arr
        int upperBoundIndex = upperBound(arr, x, n);
        
        // Display the upper bound index of x
        System.out.println("Upper Bound of " + x + " is at index: " + upperBoundIndex);
    }
}
