/**
 * 	A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.
	Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].
	You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
	
	You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
	
	Example 1:
	
	Input: mat = [[1,4],[3,2]]
	Output: [0,1]
	Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
	Example 2:
	
	Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
	Output: [1,1]
	Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class PeakElementII {

    // Using some kind of binary search method
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length; // Get the number of rows in the matrix
        int cols = mat[0].length; // Get the number of columns in the matrix
        int low = 0, high = cols - 1; // Initialize low and high indices for binary search

        // Binary search for the peak element in the matrix column-wise
        while (low <= high) {
            int midColumn = low + (high - low) / 2; // Calculate the middle column
            int maxRowOfMidColumn = getMaxElement(mat, rows, midColumn); // Find the row index of max element in the column
            int right = midColumn == cols - 1 ? -1 : mat[maxRowOfMidColumn][midColumn + 1]; // Get the element on the right side
            int left = midColumn == 0 ? -1 : mat[maxRowOfMidColumn][midColumn - 1]; // Get the element on the left side

            // Check if the current element is a peak
            if (mat[maxRowOfMidColumn][midColumn] > right && mat[maxRowOfMidColumn][midColumn] > left) {
                return new int[]{maxRowOfMidColumn, midColumn}; // Return the peak element coordinates
            } else if (mat[maxRowOfMidColumn][midColumn] < left) {
                high = midColumn - 1; // Adjust the search range to the left side
            } else {
                low = midColumn + 1; // Adjust the search range to the right side
            }
        }
        return new int[]{-1, -1}; // Return if no peak element is found
    }

    // Helper method to find the row index of the maximum element in a column
    private int getMaxElement(int[][] mat, int rows, int currentCol) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;

        // Find the maximum element in the given column
        for (int i = 0; i < rows; i++) {
            if (mat[i][currentCol] > max) {
                max = mat[i][currentCol];
                maxIndex = i; // Store the index of the maximum element
            }
        }
        return maxIndex; // Return the index of the maximum element in the column
    }

    // Brute force solution (look for all elements)
    public int[] findPeakGrid1(int[][] mat) {
        int rows = mat.length; // Get the number of rows in the matrix
        int cols = mat[0].length; // Get the number of columns in the matrix

        // Iterate through each element in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = mat[i][j]; // Current element value
                int left = j == 0 ? -1 : mat[i][j - 1]; // Element on the left side
                int right = j == cols - 1 ? -1 : mat[i][j + 1]; // Element on the right side
                int top = i == 0 ? -1 : mat[i - 1][j]; // Element on the top
                int bottom = i == rows - 1 ? -1 : mat[i + 1][j]; // Element on the bottom

                // Check if the current element is a peak
                if (current > left && current > right && current > top && current > bottom) {
                    return new int[]{i, j}; // Return the peak element coordinates
                }
            }
        }
        return new int[]{-1, -1}; // Return if no peak element is found
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        PeakElementII peakFinder = new PeakElementII();

        int[][] matrix = {
            {1, 3, 2},
            {4, 7, 5},
            {6, 9, 8}
        };

        // Using findPeakGrid method
        int[] peakCoordinates = peakFinder.findPeakGrid(matrix);
        System.out.println("Peak using findPeakGrid: [" + peakCoordinates[0] + ", " + peakCoordinates[1] + "]");

        // Using findPeakGrid1 method
        int[] peakCoordinates1 = peakFinder.findPeakGrid1(matrix);
        System.out.println("Peak using findPeakGrid1: [" + peakCoordinates1[0] + ", " + peakCoordinates1[1] + "]");
    }
}
