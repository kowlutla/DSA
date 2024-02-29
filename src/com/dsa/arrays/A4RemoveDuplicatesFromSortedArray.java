/**
 * 	Given a sorted array a[] of size n, delete all the duplicated elements from a[] & modify the array such that only distinct elements should be present there.
	
	Note:
	1. Don't use set or HashMap to solve the problem.
	2. You must return the modified array size where only distinct elements are present in the array, the driver code will print all the elements of the modified array.
	
	Example 1:
	
	Input:
	N = 5
	Array = {2, 2, 2, 2, 2}
	Output: 
	1
	Explanation: After removing all the duplicates only one instance of 2 will remain i.e. {2} so modify array will contains 2 at first position and you should return 1 
	after modify the array.
	Example 2:
	
	Input:
	N = 4
	Array = {1, 2, 2, 4}
	Output: 3
	Explation: After removing all duplicates modify array will contains {1, 2, 4} at first 3 positions so you should return 3 after modify the array.
 */
package com.dsa.arrays;

import java.util.Arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A4RemoveDuplicatesFromSortedArray {

    // Method to remove duplicates from a sorted array
    // Parameters:
    // - arr: the input integer array
    // - n: the number of elements in the array
    // Returns: the number of distinct elements after removing duplicates
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity as only a few variables are used
    public static int removeDuplicates(int[] arr, int n) {
        if (n == 0 || n == 1) { // If array has 0 or 1 element, no duplicates to remove
            return n; // Return the number of elements
        }

        int distinct = 0; // Index to track distinct elements

        // Iterate through the array
        for (int index = 0; index < n - 1; index++) {
            if (arr[index] != arr[index + 1]) { // If current element is not equal to the next element
                arr[distinct++] = arr[index]; // Store the current element as distinct
            }
        }

        arr[distinct++] = arr[n - 1]; // Store the last element as distinct
        return distinct; // Return the number of distinct elements
    }

    // Main method to test the removeDuplicates method
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 4, 5}; // Sample input sorted array with duplicates
        int n = arr.length; // Length of the input array

        System.out.println("Before removing duplicates: "+ Arrays.toString(arr));
        // Call the removeDuplicates method and print the number of distinct elements
        int distinctCount = removeDuplicates(arr, n);
        System.out.println("Number of distinct elements after removing duplicates: " + distinctCount);
        System.out.println("After removing duplicates: ");
        for(int i=0;i<distinctCount;i++) {
        	System.out.print(arr[i]+" ");
        }
    }
}

