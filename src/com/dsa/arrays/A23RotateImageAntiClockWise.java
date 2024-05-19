/**
 *  Given a square matrix of size N x N. 
	The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space. 
    
    Example 1:
    
    Input:
    N = 3 
    matrix[][] = {{1, 2, 3},
                  {4, 5, 6}
                  {7, 8, 9}}
    Output: 
    Rotated Matrix:
    3 6 9
    2 5 8
    1 4 7
    Example 2:
    
    Input:
    N = 2
    matrix[][] = {{1, 2},
                  {3, 4}}
    Output: 
    Rotated Matrix:
    2 4
    1 3
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */

/**
 * 
 * CLOCKWISE -> Transpose + Reverse Rows
 * ANTI-CLOCKWISE -> Transpose + Reverse Columns
 * 
 * OR
 * 
 * CLOCKWISE -> Reverse Columns + Transpose
 * ANTI-CLOCKWISE -> Reverse Rows + Transpose
 *
 */
public class A23RotateImageAntiClockWise {

    // Method 1: Using an auxiliary matrix
    // Time Complexity: O(N^2), where N is the number of rows/columns in the matrix
    // Space Complexity: O(N^2) for the auxiliary matrix
    public static void rotate1(int[][] matrix, int n) {
        int[][] rotated = new int[n][n]; // Auxiliary matrix to store the rotated result

        // Populate the auxiliary matrix with the rotated values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - j - 1][i] = matrix[i][j];
            }
        }

        // Copy the rotated values back into the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    // Method 2: In-place rotation by first transposing the matrix and then reversing each column
    // Time Complexity: O(N^2), where N is the number of rows/columns in the matrix
    // Space Complexity: O(1) for in-place modification
    public static void rotate2(int[][] matrix, int n) {
        // Transpose the matrix (swap elements across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each column to get the rotated matrix
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }
    }

    // Main method to test the functionality of the above methods
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Test Method 1
        System.out.println("Matrix before rotate1:");
        printMatrix(matrix1);
        rotate1(matrix1, matrix1.length);
        System.out.println("Matrix after rotate1:");
        printMatrix(matrix1);

        // Test Method 2
        System.out.println("Matrix before rotate2:");
        printMatrix(matrix2);
        rotate2(matrix2, matrix2.length);
        System.out.println("Matrix after rotate2:");
        printMatrix(matrix2);
    }

    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
