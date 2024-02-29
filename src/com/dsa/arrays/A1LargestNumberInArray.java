/**
 * 	Given an array ‘arr’ of size ‘n’ find the largest element in the array.
	Example:
	Input: 'n' = 5, 'arr' = [1, 2, 3, 4, 5]
	Output: 5
	Explanation: From the array {1, 2, 3, 4, 5}, the largest element is 5.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A1LargestNumberInArray {

    // Method to find the largest element in an array
    // Parameters:
    // - arr: the input integer array
    // - n: the number of elements in the array
    // Returns: the largest element in the array
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity
    static int largestElement(int[] arr, int n) {
        int max = arr[0]; // Assume the first element is the largest
        for (int i = 1; i < n; i++) { // Iterate through the array starting from the second element
            if (arr[i] > max) { // If current element is greater than the current maximum
                max = arr[i]; // Update the maximum
            }
        }
        return max; // Return the maximum element found
    }

    // Main method to test the largestElement method
    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 8, 15}; // Sample input array
        int n = arr.length; // Length of the input array

        // Call the largestElement method and print the result
        System.out.println("Largest element in the array: " + largestElement(arr, n));
    }
}
