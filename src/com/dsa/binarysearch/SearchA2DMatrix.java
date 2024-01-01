/**
 * 	You are given an m x n integer matrix matrix with the following two properties:
	Each row is sorted in non-decreasing order.
	The first integer of each row is greater than the last integer of the previous row.
	Given an integer target, return true if target is in matrix or false otherwise.
	
	You must write a solution in O(log(m * n)) time complexity.
	
	Example 1:
	
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
	Output: true
	Example 2:
	
	
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
	Output: false
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SearchA2DMatrix {

    // Search in 2D matrix by assuming it as a 1D array
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; // Get the number of rows in the matrix
        int cols = matrix[0].length; // Get the number of columns in the matrix
        int low = 0, high = rows * cols - 1; // Initialize the low and high indices for binary search

        // Binary search on the transformed 1D array representation of the matrix
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid index of the 1D array
            int currentRow = mid / cols; // Calculate the row index from the mid index in 1D
            int currentCol = mid % cols; // Calculate the column index from the mid index in 1D

            if (matrix[currentRow][currentCol] == target) {
                return true; // Found the target in the 2D matrix
            } else if (matrix[currentRow][currentCol] < target) {
                low = mid + 1; // Adjust the search range
            } else {
                high = mid - 1; // Adjust the search range
            }
        }
        return false; // Target not found in the 2D matrix
    }

    // Search in 2D matrix by searching in each row separately
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            // Check if the target could be in the current row range
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                return isTargetInRow(matrix[i], target); // Perform binary search within the row
            }
        }
        return false; // Target not found in any row
    }

    // Helper method to perform binary search in a single row
    private boolean isTargetInRow(int[] arr, int target) {
        int low = 0, high = arr.length - 1; // Initialize low and high indices for binary search in a row

        // Binary search within the row
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid index in the row
            if (arr[mid] == target) {
                return true; // Found the target in the row
            } else if (arr[mid] < target) {
                low = mid + 1; // Adjust the search range
            } else {
                high = mid - 1; // Adjust the search range
            }
        }
        return false; // Target not found in the row
    }

    // Example main method to demonstrate the usage of the searchMatrix methods
    public static void main(String[] args) {
        SearchA2DMatrix obj = new SearchA2DMatrix();
        
        // Example 2D matrix
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3; // Target value to search for

        // Using the searchMatrix method
        boolean found = obj.searchMatrix(matrix, target);
        System.out.println("Using searchMatrix: " + found);

        // Using the searchMatrix1 method
        boolean found1 = obj.searchMatrix1(matrix, target);
        System.out.println("Using searchMatrix1: " + found1);
    }
}

