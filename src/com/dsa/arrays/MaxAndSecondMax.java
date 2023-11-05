package com.dsa.arrays;

import java.util.ArrayList;

/**
 * Given an array arr[] of size N of positive integers which may have
 * duplicates. The task is to find the maximum and second maximum from the
 * array, and both of them should be different from each other, so If no second
 * max exists, then the second max will be -1.
 */
public class MaxAndSecondMax {

    // Method to find the maximum and second maximum elements from the array
    public static ArrayList<Integer> largestAndSecondLargest(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>(); // Create an ArrayList to store the result

        int firstMax = -1; // Initialize the first maximum to -1
        int secondMax = -1; // Initialize the second maximum to -1

        // Traverse the array to find the maximum and second maximum
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstMax) { // If the current element is greater than the first maximum
                secondMax = firstMax; // Update the second maximum to the previous value of the first maximum
                firstMax = arr[i]; // Update the first maximum to the current element
            } else if (arr[i] > secondMax && arr[i] != firstMax) { // If the current element is greater than the second maximum and not equal to the first maximum
                secondMax = arr[i]; // Update the second maximum to the current element
            }
        }
        result.add(firstMax); // Add the first maximum to the result list
        result.add(secondMax); // Add the second maximum to the result list
        return result; // Return the result list
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[] arr = { 10, 5, 8, 20, 12 };
        int n = arr.length;
        ArrayList<Integer> result = largestAndSecondLargest(n, arr);
        System.out.println("The maximum element is: " + result.get(0));
        if (result.get(1) == -1) {
            System.out.println("There is no second maximum.");
        } else {
            System.out.println("The second maximum element is: " + result.get(1));
        }
    }
}
