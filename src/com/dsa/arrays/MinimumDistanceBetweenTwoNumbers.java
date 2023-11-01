package com.dsa.arrays;

/**
 * You are given an array a, of n elements. Find the minimum index based
 * distance between two distinct elements of the array, x and y. Return -1, if
 * either x or y does not exist in the array.
 */
public class MinimumDistanceBetweenTwoNumbers {

	// First implementation to find the minimum distance between two distinct elements
	int minDist1(int a[], int n, int x, int y) {
		int result = Integer.MAX_VALUE;

		// Iterate through the array
		for (int i = 0; i < n; i++) {
			// Initialize a variable to keep track of the minimum distance
			int min = Integer.MAX_VALUE;

			// Check if the current element is x
			if (a[i] == x) {
				// Search for element y
				for (int j = 0; j < n; j++) {
					if (a[j] == y) {
						// Calculate the minimum distance and update the 'min' variable
						min = Math.min(min, (Math.abs(i - j)));
					}
				}
			}

			// Update the result with the minimum value found
			result = Math.min(result, min);
		}

		// Check if there was a valid distance found, return the result
		if (result != Integer.MAX_VALUE) {
			return result;
		}

		// If no valid distance was found, return -1
		return -1;
	}
	
	// Second implementation to find the minimum distance between two distinct elements
    int minDist(int a[], int n, int x, int y) {
        int result = Integer.MAX_VALUE;

        // Initialize variables to keep track of indices of x and y
        int xIndex = -1, yIndex = -1;
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Find the index of x
            if (a[i] == x) {
                xIndex = i;
            } 
            // Find the index of y
            else if (a[i] == y) {
                yIndex = i;
            }

            // If both x and y are found, calculate the minimum distance and update the result
            if (xIndex != -1 && yIndex != -1) {
                result = Math.min(Math.abs(xIndex - yIndex), result);
            }
        }
        
        // If no valid distance was found, return -1
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    
    // Main method to test the implementations
    public static void main(String[] args) {
        // Create an object of the class
        MinimumDistanceBetweenTwoNumbers obj = new MinimumDistanceBetweenTwoNumbers();

        // Initialize the array and other variables
        int[] arr = { 3, 5, 4, 2, 6, 3, 0, 0, 5, 4 };
        int n = arr.length;
        int x = 2;
        int y = 5;

        // Test the first implementation
        System.out.println("Result using first implementation: " + obj.minDist1(arr, n, x, y));

        // Test the second implementation
        System.out.println("Result using second implementation: " + obj.minDist(arr, n, x, y));
    }

}
