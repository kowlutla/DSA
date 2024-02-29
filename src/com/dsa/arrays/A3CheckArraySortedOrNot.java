/**
 * 	Given an array arr[] of size N, check if it is sorted in non-decreasing order or not. 
	
	Example 1:
	
	Input:
	N = 5
	arr[] = {10, 20, 30, 40, 50}
	Output: 1
	Explanation: The given array is sorted.
	Example 2:
	
	Input:
	N = 6
	arr[] = {90, 80, 100, 70, 40, 30}
	Output: 0
	Explanation: The given array is not sorted.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A3CheckArraySortedOrNot {

    // Method to check if an array is sorted in non-decreasing order
    // Parameters:
    // - arr: the input integer array
    // - n: the number of elements in the array
    // Returns: true if the array is sorted, false otherwise
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity as only a few variables are used
    public static boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) { // Iterate through the array
            if (arr[i] > arr[i + 1]) { // If the current element is greater than the next element
                return false; // Array is not sorted, return false
            }
        }
        return true; // If loop completes without returning false, array is sorted, return true
    }

    // Main method to test the arraySortedOrNot method
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 10, 15}; // Sample input array
        int n = arr.length; // Length of the input array

        // Call the arraySortedOrNot method and print the result
        System.out.println("Is the array sorted? " + arraySortedOrNot(arr, n));
    }
}
