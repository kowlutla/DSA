/**
 * 	Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 
	
	Example 1:
	Input:
	N = 5, D = 2
	arr[] = {1,2,3,4,5}
	Output: 3 4 5 1 2
	Explanation: 1 2 3 4 5  when rotated
	by 2 elements, it becomes 3 4 5 1 2.

	Example 2:
	Input:
	N = 10, D = 3
	arr[] = {2,4,6,8,10,12,14,16,18,20}
	Output: 8 10 12 14 16 18 20 2 4 6
	Explanation: 2 4 6 8 10 12 14 16 18 20 
	when rotated by 3 elements, it becomes 
	8 10 12 14 16 18 20 2 4 6.
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A5A6RotateArrayAntiClockWise {

    // Method to rotate an array by d positions using an iterative approach
    // Parameters:
    // - arr: the input integer array
    // - d: the number of positions to rotate the array by
    // - n: the number of elements in the array
    // Time Complexity: O(n*d) - where n is the number of elements in the array and d is the number of positions to rotate
    // Space Complexity: O(1) - constant space complexity
    public static void rotateArr(int arr[], int d, int n) {
        for (int i = 1; i <= d; i++) { // Iterate d times to perform rotation
            makeOneShift(arr); // Shift the array by one position
        }
    }

    // Helper method to shift the array by one position to the left
    private static void makeOneShift(int[] arr) {
        int temp = arr[0]; // Store the first element temporarily
        for (int i = 0; i < arr.length - 1; i++) { // Iterate through the array
            arr[i] = arr[i + 1]; // Move each element one position to the left
        }
        arr[arr.length - 1] = temp; // Place the stored first element at the end of the array
    }

    // Method to rotate an array by d positions using a reversal approach
    // Parameters:
    // - arr: the input integer array
    // - d: the number of positions to rotate the array by
    // - n: the number of elements in the array
    // Time Complexity: O(n) - linear time complexity where n is the number of elements in the array
    // Space Complexity: O(1) - constant space complexity
    public static void rotateArr1(int arr[], int d, int n) {
        d = d % n; // Normalize d to handle cases where d is greater than n
        reverse(arr, 0, n - 1); // Reverse the entire array
        reverse(arr, 0, n - d - 1); // Reverse the first part of the array
        reverse(arr, n - d, n - 1); // Reverse the second part of the array
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int arr[], int start, int end) {
        while (start < end) { // Loop until start and end indices meet
            int temp = arr[start]; // Swap elements at start and end indices
            arr[start] = arr[end];
            arr[end] = temp;

            start++; // Move start index towards end
            end--; // Move end index towards start
        }
    }

    // Main method to test the rotateArr and rotateArr1 methods
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Sample input array
        int d = 2; // Number of positions to rotate by
        int n = arr.length; // Length of the input array

        // Call the rotateArr method and print the rotated array
        rotateArr(arr, d, n);
        System.out.println("Rotated array using iterative approach:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Reset the array
        arr = new int[]{1, 2, 3, 4, 5};

        // Call the rotateArr1 method and print the rotated array
        rotateArr1(arr, d, n);
        System.out.println("Rotated array using reversal approach:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
