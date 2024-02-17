/**
 * 	Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.
	
	Example 1:
	
	Input:
	n = 4, m = 4
	M[][] = {{0 1 1 0},
	         {1 1 1 1},
	         {1 1 1 1},
	         {1 1 0 0}}
	Output: 8
	Explanation: For the above test case the
	matrix will look like
	0 1 1 0
	1 1 1 1
	1 1 1 1
	1 1 0 0
	the max size rectangle is 
	1 1 1 1
	1 1 1 1
	and area is 4 *2 = 8.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class Dp55MaximalRectangle {

    /**
     * This method finds the maximum area of a rectangle formed by non-zero elements in a matrix.
     *
     * @param M The input matrix with dimensions n x m.
     * @param n The number of rows in the matrix.
     * @param m The number of columns in the matrix.
     * @return The maximum area of a rectangle formed by non-zero elements.
     */
    public static int maxArea(int M[][], int n, int m) {
        int maxArea = 0;
        int heights[] = new int[m]; // Array to store heights of rectangle pillars for each column.

        // Iterate through each row and update heights based on current cell value.
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (M[row][col] == 0) {
                    heights[col] = 0; // Reset height if current cell is 0.
                } else {
                    heights[col]++; // Increase height if current cell is 1.
                }
            }

            // Calculate maximum area using the current heights and update overall maximum.
            int currentArea = largestarea(heights, m);
            maxArea = Math.max(currentArea, maxArea);
        }

        return maxArea;
    }

    /**
     * This method calculates the maximum area of a rectangle formed by given heights.
     *
     * @param arr The array of heights representing the rectangle pillars.
     * @param n The number of elements in the array.
     * @return The maximum area of a rectangle formed by the given heights.
     */
    private static int largestarea(int arr[], int n) {
        int maxArea = 0;
        int minHeight = Integer.MAX_VALUE;

        // Iterate through each element and calculate area based on minimum height seen so far.
        for (int i = 0; i < n; i++) {
            minHeight = Math.min(minHeight, arr[i]); // Update minimum height.
            maxArea = Math.max(maxArea, minHeight * (i - 1 + 1)); // Calculate area with current height.
        }

        return maxArea;
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 0}};
        int n = 3, m = 4;
        int maxArea = maxArea(M, n, m);
        System.out.println("Maximum area of rectangle: " + maxArea); // Output: 8
    }
}
