/**
 * You are given an n x n 2D matrix representing an image, 
   rotate the image by 90 degrees (clockwise).
   Example 1:
   Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
   Output: [[7,4,1],[8,5,2],[9,6,3]]

   Example 2:
   Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
   Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
package com.dsa.arrays;

/**
 * @author KowlutlaSwamy
 *
 */
public class A23RotateImageClockwise {

    // Method 1: Using an auxiliary matrix
    // Time Complexity: O(N^2) where N is the number of rows/columns in the matrix
    // Space Complexity: O(N^2) for the auxiliary matrix
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n]; // Auxiliary matrix to store the rotated result

        // Populate the auxiliary matrix with the rotated values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }

        // Copy the rotated values back into the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    // Method 2: In-place rotation by first transposing the matrix and then reversing each row
    // Time Complexity: O(N^2) where N is the number of rows/columns in the matrix
    // Space Complexity: O(1) for in-place modification
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix (swap elements across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get the rotated matrix
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // Helper method to reverse an array
    // Time Complexity: O(N) where N is the length of the array
    // Space Complexity: O(1) for in-place modification
    private static void reverse(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
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
        rotate1(matrix1);
        System.out.println("Matrix after rotate1:");
        printMatrix(matrix1);

        // Test Method 2
        System.out.println("Matrix before rotate2:");
        printMatrix(matrix2);
        rotate2(matrix2);
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
