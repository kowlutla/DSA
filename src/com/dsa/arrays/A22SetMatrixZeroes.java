/**
 * 	Given an m x n integer matrix matrix, 
 	if an element is 0, set its entire row and column to 0's.

	Example 1:
	Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
	Output: [[1,0,1],[0,0,0],[1,0,1]]

	Example 2:
	Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
	Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A22SetMatrixZeroes {

    // Method 1: Using Integer.MIN_VALUE as a marker
    // Time Complexity: O(N * M), where N is the number of rows and M is the number of columns
    // Space Complexity: O(1) for extra space used
    public void setZeroes1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // First pass: Identify the rows and columns that need to be zeroed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the entire row and column for zeroing
                    makeRowAndCol(matrix, i, j);
                }
            }
        }

        // Second pass: Set the identified cells to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Helper method to mark the entire row and column of the found zero with a marker value
    private void makeRowAndCol(int[][] matrix, int row, int col) {
        // Mark the entire row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = Integer.MIN_VALUE;
            }
        }

        // Mark the entire column
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = Integer.MIN_VALUE;
            }
        }
    }

    // Method 2: Using auxiliary arrays
    // Time Complexity: O(N * M), where N is the number of rows and M is the number of columns
    // Space Complexity: O(N + M) for the rowZeros and colZeros arrays
    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Arrays to keep track of rows and columns that need to be zeroed
        boolean[] rowZeros = new boolean[rows];
        boolean[] colZeros = new boolean[cols];

        // First pass: Identify the rows and columns that need to be zeroed
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    rowZeros[row] = true;  // Mark the row
                    colZeros[col] = true;  // Mark the column
                }
            }
        }

        // Second pass: Zero out marked rows and columns
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rowZeros[row] || colZeros[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    // Main method to test the functionality of the above methods
    public static void main(String[] args) {
        A22SetMatrixZeroes solution = new A22SetMatrixZeroes();

        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        // Test Method 1
        System.out.println("Method 1:");
        solution.setZeroes1(matrix1);
        for (int[] row : matrix1) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Reset matrix for Method 2 testing
        matrix1 = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        // Test Method 2
        System.out.println("Method 2:");
        solution.setZeroes2(matrix1);
        for (int[] row : matrix1) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
