/**
 * 	You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
	A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
	Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
	
	Example 1:
	Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
	Output: 3
	Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

	Example 2:
	Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
	Output: 0
	Explanation: All 1s are either on the boundary or can reach the boundary.
	 
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
public class G15NumberOfEnclavesDFS {

	/**
	 * Counts the number of enclaves in the given grid using Depth First Search (DFS).
	 * 
	 * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the grid.
	 * Space Complexity: O(n * m) for the visited array and the recursive stack space.
	 * 
	 * @param grid  The 2D integer grid representing the land.
	 * @return      The number of enclaves in the grid.
	 */
	public static int numberOfEnclaves(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m]; // Visited array to mark visited cells
		int[] deltaRows = {0, -1, 0, 1}; // Delta for rows to check adjacent cells
		int[] deltaCols = {-1, 0, 1, 0}; // Delta for columns to check adjacent cells

		// Check for cells on the first and last row
		for (int col = 0; col < m; col++) {
			if (grid[0][col] == 1 && !visited[0][col]) {
				dfs(grid, 0, col, visited, deltaRows, deltaCols); // Perform DFS traversal
			}
			if (grid[n - 1][col] == 1 && !visited[n - 1][col]) {
				dfs(grid, n - 1, col, visited, deltaRows, deltaCols); // Perform DFS traversal
			}
		}

		// Check for cells on the first and last column
		for (int row = 0; row < n; row++) {
			if (grid[row][0] == 1 && !visited[row][0]) {
				dfs(grid, row, 0, visited, deltaRows, deltaCols); // Perform DFS traversal
			}
			if (grid[row][m - 1] == 1 && !visited[row][m - 1]) {
				dfs(grid, row, m - 1, visited, deltaRows, deltaCols); // Perform DFS traversal
			}
		}

		int result = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (grid[row][col] == 1 && !visited[row][col]) {
					result++; // Increment the result for each unvisited '1' cell
				}
			}
		}

		return result;
	}

	/**
	 * Depth First Search (DFS) to mark visited cells.
	 * 
	 * @param grid        The 2D integer grid representing the land.
	 * @param row         The current row index.
	 * @param col         The current column index.
	 * @param visited     2D array to mark visited cells.
	 * @param deltaRows   Delta for rows to check adjacent cells.
	 * @param deltaCols   Delta for columns to check adjacent cells.
	 */
	private static void dfs(int[][] grid, int row, int col, boolean[][] visited,
			int[] deltaRows, int[] deltaCols) {
		visited[row][col] = true; // Mark the current cell as visited

		for (int delta = 0; delta < 4; delta++) { // Explore all four adjacent cells
			int currentRow = row + deltaRows[delta];
			int currentCol = col + deltaCols[delta];

			// Check if the adjacent cell is within the grid boundaries, unvisited, and contains '1'
			if (currentRow >= 0 && currentRow < grid.length && currentCol >= 0
					&& currentCol < grid[0].length
					&& grid[currentRow][currentCol] == 1
					&& !visited[currentRow][currentCol]) {
				dfs(grid, currentRow, currentCol, visited, deltaRows,
						deltaCols); // Recursively call DFS for the adjacent cell
			}
		}
	}
	
	public static void main(String[] args) {
        // Example grid representing the land
        int[][] grid = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };
        
        // Count the number of enclaves in the grid
        int numberOfEnclaves = G15NumberOfEnclavesDFS.numberOfEnclaves(grid);

        // Print the result
        System.out.println("Number of enclaves: " + numberOfEnclaves);
    }
}
