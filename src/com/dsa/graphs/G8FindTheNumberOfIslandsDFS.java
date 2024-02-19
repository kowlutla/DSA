/**
 * 	Given a grid of size n*m (n is the number of rows and m is the number
  	of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.
	
	Note: An island is either surrounded by water or boundary of grid and is formed by connecting 
	adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
	
	Example 1:
	Input:
	grid = {{0,1},{1,0},{1,1},{1,0}}
	Output:
	1
	Explanation:
	The grid is-
	0 1
	1 0
	1 1
	1 0
	All lands are connected.

	Example 2:
	Input:
	grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
	Output:
	2
	Expanation:
	The grid is-
	0 1 1 1 0 0 0
	0 0 1 1 0 1 0 
	There are two islands :- one is colored in blue 
	and other in orange.
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
public class G8FindTheNumberOfIslandsDFS {

    // Function to find the number of islands, with clear comments and explanations.
    public int numIslandsDFS(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m]; // Track visited cells

        int islands = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && grid[row][col] == '1') { // Start DFS if unvisited land cell
                    islands++;
                    dfs(grid, row, col, visited); // Explore the island using DFS
                    System.out.println();
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true; // Mark starting cell as visited
        System.out.print("["+row+","+col+"]\t");

        // Explore adjacent cells in all four directions (up, down, left, right)
        for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
            for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {
                int neighborRow = row + deltaRow;
                int neighborCol = col + deltaCol;

                // Check if the neighbor is within grid bounds, unvisited, and land
                if (isValidCell(neighborRow, neighborCol, grid) && !visited[neighborRow][neighborCol] && grid[neighborRow][neighborCol] == '1') {
                    dfs(grid, neighborRow, neighborCol, visited); // Recursive call to explore neighbor
                }
            }
        }
    }

    // Helper function to check if a cell is within grid bounds
    private boolean isValidCell(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    // Main method to test the code with time and space complexity analysis
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'0', '1', '0', '0', '1'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        G8FindTheNumberOfIslandsDFS solution = new G8FindTheNumberOfIslandsDFS();
        int numIslands = solution.numIslandsDFS(grid);
        System.out.println("Number of islands: " + numIslands); // Output: 3

        // Time complexity analysis:
        // - In the worst case, all cells might be land, leading to DFS exploring each cell once.
        // - Time complexity: O(m * n), where m and n are the grid dimensions.
        // Space complexity analysis:
        // - The visited array uses space proportional to the grid size.
        // - Space complexity: O(m * n) (excluding stack space for recursion).
    }
}
