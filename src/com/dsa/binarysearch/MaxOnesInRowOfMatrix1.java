/**
 * 	Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

	Example 1:
	
	Input: 
	N = 4 , M = 4
	Arr[][] = {{0, 1, 1, 1},
	           {0, 0, 1, 1},
	           {1, 1, 1, 1},
	           {0, 0, 0, 0}}
	Output: 2
	Explanation: Row 2 contains 4 1's (0-based
	indexing).
	
	Example 2:
	
	Input: 
	N = 2, M = 2
	Arr[][] = {{0, 0}, {1, 1}}
	Output: 1
	Explanation: Row 1 contains 2 1's (0-based
	indexing).
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class MaxOnesInRowOfMatrix1 {

    // Method to find the row with the maximum number of 1s in a binary matrix
    public int rowWithMax1s(int arr[][], int n, int m) {
        int maxOnes = 0;
        int index = -1;

        // Iterate through each row in the matrix
        for (int i = 0; i < n; i++) {
            // Find the lower index of 1 in the current row
            int lowerIndexOfOne = getLowerIndexOfOne(arr[i]);

            // Calculate the count of 1s in the current row
            if (m - lowerIndexOfOne > maxOnes) {
                maxOnes = m - lowerIndexOfOne;
                index = i; // Update the index of the row with max 1s
            }
        }
        return index; // Return the index of the row with the most 1s
    }

    // Helper method to find the lower index of 1 in a sorted array using binary search
    private int getLowerIndexOfOne(int[] arr) {
        int low = 0, high = arr.length - 1;

        // Binary search to find the lower index of 1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                high = mid - 1; // Adjust the search range
            } else {
                low = mid + 1; // Adjust the search range
            }
        }
        return low; // Return the lower index of 1
    }

    // Example main method to demonstrate the usage of rowWithMax1s method
    public static void main(String[] args) {
        MaxOnesInRowOfMatrix1 obj = new MaxOnesInRowOfMatrix1();
        
        // Example binary matrix
        int[][] matrix = {
            {0, 0, 1, 1},
            {0, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 1, 1, 1}
        };
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowWithMax1s = obj.rowWithMax1s(matrix, rows, cols);
        
        if (rowWithMax1s != -1) {
            System.out.println("Row with maximum 1s is: " + rowWithMax1s);
        } else {
            System.out.println("Invalid matrix or no 1s found.");
        }
    }
}
