/**
 * 	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
 	which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
	
	Example 1:
	Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
	Output: 7
	Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

	Example 2:
	Input: grid = [[1,2,3],[4,5,6]]
	Output: 12
	
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class MinimumPathSum {

    // Recursive approach to calculate minimum path sum
    public static int minPathSumRecursion(int[][] grid) {
        // Call the recursive helper method
        return minPathSumRecursion(grid, grid.length - 1, grid[0].length - 1);
    }

    // Recursive helper method to calculate minimum path sum
    private static int minPathSumRecursion(int[][] grid, int row, int col) {
        // Base case: if out of bounds, return maximum value
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        // Base case: if at the top-left cell, return its value
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        // Calculate the minimum path sum by choosing the minimum of the paths from the top and left
        int up = minPathSumRecursion(grid, row - 1, col);
        int left = minPathSumRecursion(grid, row, col - 1);
        return Math.min(up, left) + grid[row][col];
    }

    // Memoization approach to optimize recursive solution
    public static int minPathSumMemoization(int[][] grid) {
        // Create a memoization table
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        // Call the memoization helper method
        return minPathSumMemoization(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    // Memoization helper method to calculate minimum path sum
    private static int minPathSumMemoization(int[][] grid, int row, int col, int[][] dp) {
        // Base case: if out of bounds, return maximum value
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        // Base case: if at the top-left cell, return its value
        if (row == 0 && col == 0) {
            return grid[row][col];
        }
        // If already calculated, return the stored value
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        // Calculate the minimum path sum by choosing the minimum of the paths from the top and left
        int up = minPathSumMemoization(grid, row - 1, col, dp);
        int left = minPathSumMemoization(grid, row, col - 1, dp);
        return dp[row][col] = Math.min(up, left) + grid[row][col];
    }

 // Tabulation approach to calculate minimum path sum using dynamic programming
    public static int minMathSumTabulation(int[][] grid) {
        // Create a tabulation table
        int[][] dp = new int[grid.length][grid[0].length];

        // Iterate through each cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                // If at the top-left cell, set dp value to the grid value
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                } else {
                    // Calculate the minimum path sum by choosing the minimum of the paths from the top and left
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (row > 0) {
                        up = dp[row - 1][col] + grid[row][col];
                    }
                    if (col > 0) {
                        left = dp[row][col - 1] + grid[row][col];
                    }
                    dp[row][col] = Math.min(up, left);
                }
            }
        }

        // Return the minimum path sum at the bottom-right cell
        return dp[grid.length - 1][grid[0].length - 1];
    }

    // Space optimized tabulation approach to calculate minimum path sum
    public static int minPathSumSpaceOptimization(int[][] grid) {
        // Get the number of rows and columns in the grid
        int rows = grid.length, cols = grid[0].length;
        // Initialize an array to store the values of the previous row
        int previousRow[] = new int[cols];

        // Iterate through each row in the grid
        for (int row = 0; row < rows; row++) {
            // Initialize an array to store the values of the current row
            int[] currentRow = new int[cols];
            // Iterate through each column in the grid
            for (int col = 0; col < cols; col++) {
                // If at the top-left cell, set currentRow value to the grid value
                if (row == 0 && col == 0) {
                    currentRow[col] = grid[row][col];
                } else {
                    // Calculate the minimum path sum by choosing the minimum of the paths from the top and left
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (row > 0) {
                        up = previousRow[col] + grid[row][col];
                    }
                    if (col > 0) {
                        left = currentRow[col - 1] + grid[row][col];
                    }
                    currentRow[col] = Math.min(up, left);
                }
            }
            // Update the previousRow array with the values of the currentRow array
            previousRow = currentRow;
        }

        // Return the minimum path sum at the bottom-right cell
        return previousRow[cols - 1];
    }


    // Main method to test and demonstrate the functionality
    public static void main(String[] args) {
        // Example grid
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 2},
            {4, 2, 1}
        };

        // Print results using different approaches
        System.out.println("Recursive Approach: " + minPathSumRecursion(grid));
        System.out.println("Memoization Approach: " + minPathSumMemoization(grid));
        System.out.println("Tabulation Approach: " + minMathSumTabulation(grid));
        System.out.println("Space Optimization Approach: " + minPathSumSpaceOptimization(grid));
    }
}
