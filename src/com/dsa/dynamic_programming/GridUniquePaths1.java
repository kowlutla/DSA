/**
 * 	Given a A X B matrix with your initial position at the top-left cell, 
 	find the number of possible unique paths to reach the bottom-right cell of the matrix 
  	from the initial position.

	Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].
	
	Example 1:
	Input:
	A = 2, B = 2
	Output: 2
	Explanation: There are only two unique
	paths to reach the end of the matrix of
	size two from the starting cell of the
	matrix.

	Example 2:
	Input:
	A = 3, B = 4
	Output: 10
	Explanation: There are only 10 unique
	paths to reach the end of the matrix of
	size two from the starting cell of the
	matrix.
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class GridUniquePaths1 {

    // Recursive approach to calculate the number of unique paths
    public static int numberOfPathRecursion(int rows, int cols) {
        return numberOfPathRecursionHelper(rows - 1, cols - 1);
    }

    // Helper method for recursive approach
    private static int numberOfPathRecursionHelper(int row, int col) {
        if (row == 0 && col == 0) {
            return 1; // Base case: reached the top-left cell
        }
        if (row < 0 || col < 0) {
            return 0; // Base case: out of bounds
        }
        // Move either up or left and accumulate the paths
        int up = numberOfPathRecursionHelper(row - 1, col);
        int left = numberOfPathRecursionHelper(row, col - 1);
        return up + left; // Total paths is the sum of upward and leftward paths
    }

    // Memoization approach to optimize recursive solution
    public static int numberOfPathMemoization(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return numberOfPathMemoization(rows - 1, cols - 1, dp);
    }

    // Helper method for memoization approach
    private static int numberOfPathMemoization(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return dp[row][col] = 1; // Base case: reached the top-left cell
        }
        if (row < 0 || col < 0) {
            return 0; // Base case: out of bounds
        }
        if (dp[row][col] != -1) {
            return dp[row][col]; // If already calculated, return the stored value
        }
        // Move either up or left and accumulate the paths
        int up = numberOfPathMemoization(row - 1, col, dp);
        int left = numberOfPathMemoization(row, col - 1, dp);
        return dp[row][col] = up + left; // Store and return the total paths
    }

    // Tabulation approach to calculate unique paths using dynamic programming
    public static int numberOfPathTabulation(int rows, int cols) {
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // Starting cell has only one way to reach (itself)
                } else {
                    int up = i > 0 ? dp[i - 1][j] : 0; // Number of paths from above
                    int left = j > 0 ? dp[i][j - 1] : 0; // Number of paths from the left
                    dp[i][j] = up + left; // Total paths to reach current cell
                }
            }
        }
        return dp[rows - 1][cols - 1]; // Return the total paths for bottom-right cell
    }

    // Space optimized tabulation approach to calculate unique paths
    public static int numberOfPathSpaceOptimization(int rows, int cols) {
        int[] previousRow = new int[rows];
        for (int i = 0; i < cols; i++) {
            int[] currentRow = new int[rows];
            for (int j = 0; j < rows; j++) {
                if (i == 0 && j == 0) {
                    currentRow[j] = 1; // Starting cell has only one way to reach (itself)
                } else {
                    int up = i > 0 ? previousRow[j] : 0; // Number of paths from above
                    int left = j > 0 ? currentRow[j - 1] : 0; // Number of paths from the left
                    currentRow[j] = up + left; // Total paths to reach current cell
                }
            }
            previousRow = currentRow; // Update the previous row with current row
        }
        return previousRow[rows - 1]; // Return the total paths for bottom-right cell
    }

    // Main method to test and demonstrate the functionality
    public static void main(String[] args) {
        int rows = 4; // Example number of rows
        int cols = 7; // Example number of columns

        // Using the recursive approach to find the number of unique paths
        int pathsRecursive = numberOfPathRecursion(rows, cols);
        System.out.println("Number of paths (Recursive): " + pathsRecursive);

        // Using the memoization approach to find the number of unique paths
        int pathsMemoization = numberOfPathMemoization(rows, cols);
        System.out.println("Number of paths (Memoization): " + pathsMemoization);

        // Using the tabulation approach to find the number of unique paths
        int pathsTabulation = numberOfPathTabulation(rows, cols);
        System.out.println("Number of paths (Tabulation): " + pathsTabulation);

        // Using the space-optimized tabulation approach to find the number of unique paths
        int pathsSpaceOptimization = numberOfPathSpaceOptimization(rows, cols);
        System.out.println("Number of paths (Space Optimization): " + pathsSpaceOptimization);
    }
}
