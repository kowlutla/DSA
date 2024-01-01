/**
 * 	Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
 * This matrix has the following properties:
 * 
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	
	Example 1:
	Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
	Output: true

	Example 2:
	Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
	Output: false
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class SearchA2DMatrixII {

    // Start searching from bottom-left element of the matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; // Get the number of rows in the matrix
        int cols = matrix[0].length; // Get the number of columns in the matrix
        int currentRow = rows - 1; // Start from the last row
        int currentColumn = 0; // Start from the first column

        // Traverse the matrix based on the condition
        while (currentRow >= 0 && currentColumn < cols) {
            if (matrix[currentRow][currentColumn] == target) {
                return true; // Found the target
            } else if (matrix[currentRow][currentColumn] < target) {
                currentColumn++; // Move to the right 
            } else {
                currentRow--; // Move upwards 
            }
        }
        return false; // Target not found
    }

    // Start searching from top-right element of the matrix
    public boolean searchMatrix1(int[][] matrix, int target) {
        int rows = matrix.length; // Get the number of rows in the matrix
        int cols = matrix[0].length; // Get the number of columns in the matrix
        int rowIndex = 0; // Start from the first row
        int columnIndex = cols - 1; // Start from the last column

        // Traverse the matrix based on the condition
        while (rowIndex < rows && columnIndex >= 0) {
            if (matrix[rowIndex][columnIndex] == target) {
                return true; // Found the target
            } else if (matrix[rowIndex][columnIndex] < target) {
                rowIndex++; // Move downwards
            } else {
                columnIndex--; // Move to the left 
            }
        }
        return false; // Target not found
    }

    // Search by using binary search on each row
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (isTargetInCurrentRow(matrix[i], target)) {
                return true; // Found the target in the row
            }
        }
        return false; // Target not found in any row
    }

    // Helper method to perform binary search in a single row
    private boolean isTargetInCurrentRow(int[] arr, int target) {
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
    
    // Example main method to demonstrate the usage of searchMatrix methods
    public static void main(String[] args) {
        SearchA2DMatrixII obj = new SearchA2DMatrixII();

        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17},
        };
        int target = 5;

        // Using the searchMatrix method
        boolean found = obj.searchMatrix(matrix, target);
        System.out.println("Using searchMatrix: " + found);

        // Using the searchMatrix1 method
        boolean found1 = obj.searchMatrix1(matrix, target);
        System.out.println("Using searchMatrix1: " + found1);

        // Using the searchMatrix2 method
        boolean found2 = obj.searchMatrix2(matrix, target);
        System.out.println("Using searchMatrix2: " + found2);
    }
}