/**
 * 	Given a matrix of size r*c. Traverse the matrix in spiral form.

	Example 1:
	Input:
	r = 4, c = 4
	matrix[][] = {{1, 2, 3, 4},
	           {5, 6, 7, 8},
	           {9, 10, 11, 12},
	           {13, 14, 15,16}}
	Output: 
	1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
	Explanation:
	
	Example 2:
	Input:
	r = 3, c = 4  
	matrix[][] = {{1, 2, 3, 4},
	           {5, 6, 7, 8},
	           {9, 10, 11, 12}}
	Output: 
	1 2 3 4 8 12 11 10 9 5 6 7
	Explanation:
	Applying same technique as shown above, 
	output for the 2nd testcase will be 
	1 2 3 4 8 12 11 10 9 5 6 7.
 */
package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class A24MatrixSpiralOrder {

    /**
     * Method to return the elements of a matrix in spiral order.
     * 
     * @param matrix The input 2D array.
     * @param r The number of rows in the matrix.
     * @param c The number of columns in the matrix.
     * @return A list of integers representing the matrix elements in spiral order.
     */
    public static List<Integer> matrixSpiralOrder(int[][] matrix, int r, int c) {
        int startRow = 0;
        int startCol = 0;
        int endRow = r - 1;
        int endCol = c - 1;
        ArrayList<Integer> result = new ArrayList<>();

        // Loop until the entire matrix is covered in spiral order
        while (startRow <= endRow && startCol <= endCol) {
            // Traverse from left to right along the top row
            for (int col = startCol; col <= endCol; col++) {
                result.add(matrix[startRow][col]);
            }
            startRow++;

            // Traverse from top to bottom along the right column
            for (int row = startRow; row <= endRow; row++) {
                result.add(matrix[row][endCol]);
            }
            endCol--;

            // Traverse from right to left along the bottom row, if there are remaining rows
            if (startRow <= endRow) {
                for (int col = endCol; col >= startCol; col--) {
                    result.add(matrix[endRow][col]);
                }
                endRow--;
            }

            // Traverse from bottom to top along the left column, if there are remaining columns
            if (startCol <= endCol) {
                for (int row = endRow; row >= startRow; row--) {
                    result.add(matrix[row][startCol]);
                }
                startCol++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<Integer> result = matrixSpiralOrder(matrix, matrix.length, matrix[0].length);
        
        System.out.println("Matrix elements in spiral order:"+ result);
    }
}
