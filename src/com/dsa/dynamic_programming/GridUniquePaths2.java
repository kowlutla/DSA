/**
	You are given a grid of n * m having 0 and 1 respectively, 0 denotes space, and 1 denotes obstacle. 
	Geek is located at top-left corner (i.e grid[0][0]) and wants to reach the bottom right corner of the grid. 
	A geek can move either down or right at any point of time. return the total number of ways in which Geek 
	can reach bottom right corner. answer may be large take the modulo by 1e9+7.

	Example:
	Input:
	n = 3, m = 3
	grid= [[0,0,0],[0,1,0],[0,0,0]]
	Output:
	2
	Explanation:
	There is one obstacle in the middle of the 3x3 grid above. There are two ways to reach
	the bottom-right corner:
	1. Right -> Right -> Down -> Down
	2. Down -> Down -> Right -> Right
	
	Example 2:
	Input:
	n = 2, m = 2
	grid = [[0,1],[0,0]]
	Output:
	1
 */
package com.dsa.dynamic_programming;

import java.util.Arrays;

public class GridUniquePaths2 {

    // Recursive approach to calculate the number of unique paths with obstacles
    public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        return uniquePathsWithObstaclesRecursion(obstacleGrid, rows - 1, cols - 1);
    }

    // Helper method for recursive approach
    private int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid, int row, int col) {
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0; // If obstacle or out of bounds, no path
        }
        if (row == 0 && col == 0) {
            return 1; // Reached the destination
        }
        int up = uniquePathsWithObstaclesRecursion(obstacleGrid, row - 1, col);
        int left = uniquePathsWithObstaclesRecursion(obstacleGrid, row, col - 1);
        return up + left; // Total paths is the sum of upward and leftward paths
    }

    // Memoization approach to optimize recursive solution
    public int uniquePathsWithObstaclesMemoization(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int dp[][] = new int[rows][cols];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return uniquePathsWithObstaclesMemoization(obstacleGrid, rows - 1, cols - 1, dp);
    }

    // Helper method for memoization approach
    private int uniquePathsWithObstaclesMemoization(int[][] grid, int row, int col, int[][] dp) {
        if (row < 0 || col < 0 || grid[row][col] == 1) {
            return 0; // If obstacle or out of bounds, no path
        }
        if (row == 0 && col == 0) {
            return 1; // Reached the destination
        }
        if (dp[row][col] != -1) {
            return dp[row][col]; // If already calculated, return the stored value
        }
        int up = uniquePathsWithObstaclesMemoization(grid, row - 1, col, dp);
        int left = uniquePathsWithObstaclesMemoization(grid, row, col - 1, dp);
        return dp[row][col] = up + left; // Store and return the total paths
    }

    // Tabulation approach to calculate unique paths using dynamic programming
    public int uniquePathsWithObstaclesTabulation(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = (grid[i][j] == 1) ? 0 : 1; // Starting cell
                } else {
                    if (grid[i][j] != 1) {
                        int up = (i > 0) ? dp[i - 1][j] : 0; // Paths from above
                        int left = (j > 0) ? dp[i][j - 1] : 0; // Paths from the left
                        dp[i][j] = up + left; // Total paths to reach current cell
                    }
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1]; // Return the total paths for bottom-right cell
    }

    // Space optimized tabulation approach to calculate unique paths
    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int[] previousRow = new int[rows];

        for (int i = 0; i < grid[0].length; i++) {
            int currentRow[] = new int[rows];
            for (int j = 0; j < rows; j++) {
                if (i == 0 && j == 0) {
                    currentRow[j] = (grid[i][j] == 1) ? 0 : 1; // Starting cell
                } else {
                    if (grid[i][j] != 1) {
                        int up = (i > 0) ? previousRow[j] : 0; // Paths from above
                        int left = (j > 0) ? currentRow[j - 1] : 0; // Paths from the left
                        currentRow[j] = up + left; // Total paths to reach current cell
                    }
                }
            }
            previousRow = currentRow; // Update the previous row with current row
        }
        return previousRow[rows - 1]; // Return the total paths for bottom-right cell
    }

    // Main method to test and demonstrate the functionality
    public static void main(String[] args) {
        GridUniquePaths2 obj = new GridUniquePaths2();
        int[][] obstacleGrid = {
            {0, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        };

        System.out.println("Recursive Approach: " + obj.uniquePathsWithObstaclesRecursion(obstacleGrid));
        System.out.println("Memoization Approach: " + obj.uniquePathsWithObstaclesMemoization(obstacleGrid));
        System.out.println("Tabulation Approach: " + obj.uniquePathsWithObstaclesTabulation(obstacleGrid));
        System.out.println("Space Optimized Approach: " + obj.uniquePathsWithObstacles(obstacleGrid));
    }
}
