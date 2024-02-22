/**
 * 	Given a boolean 2D matrix grid of size n * m. 
 	You have to find the number of distinct islands 
 	where a group of connected 1s (horizontally or 
 	vertically) forms an island. Two islands are considered 
 	to be distinct if and only if one island is not equal 
 	to another (not rotated or reflected).
	
	Example 1:
	Input:
	grid[][] = {{1, 1, 0, 0, 0},
	            {1, 1, 0, 0, 0},
	            {0, 0, 0, 1, 1},
	            {0, 0, 0, 1, 1}}
	Output:
	1
	Explanation:
	grid[][] = {{1, 1, 0, 0, 0}, 
	            {1, 1, 0, 0, 0}, 
	            {0, 0, 0, 1, 1}, 
	            {0, 0, 0, 1, 1}}
	Same colored islands are equal.
	We have 2 equal islands, so we 
	have only 1 distinct island.
	
	Example 2:
	Input:
	grid[][] = {{1, 1, 0, 1, 1},
	            {1, 0, 0, 0, 0},
	            {0, 0, 0, 0, 1},
	            {1, 1, 0, 1, 1}}
	Output:
	3
	Explanation:
	grid[][] = {{1, 1, 0, 1, 1}, 
	            {1, 0, 0, 0, 0}, 
	            {0, 0, 0, 0, 1}, 
	            {1, 1, 0, 1, 1}}
	Same colored islands are equal.
	We have 4 islands, but 2 of them
	are equal, So we have 3 distinct islands.
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author KowlutlaSwamy
 *
 */
public class G16DistinctIslandsDFS {

	/**
	 * Counts the number of distinct islands in the given 2D grid using Depth First Search (DFS).
	 * 
	 * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the grid.
	 * Space Complexity: O(n * m) for the visited array and the set to store distinct islands.
	 * 
	 * @param arr The 2D integer array representing the grid.
	 * @param n   The number of rows in the grid.
	 * @param m   The number of columns in the grid.
	 * @return    The number of distinct islands in the grid.
	 */
	public static int distinctIsland(int[][] arr, int n, int m) {
		boolean[][] visited = new boolean[n][m]; // Visited array to mark visited cells

		Set<ArrayList<String>> set = new HashSet<>(); // Set to store distinct islands
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (!visited[row][col] && arr[row][col] == 1) {
					ArrayList<String> list = new ArrayList<>(); // List to store island coordinates relative to the source
					dfs(arr, row, col, visited, row, col, list); // Perform DFS traversal
					set.add(list); // Add the island coordinates to the set
				}
			}
		}
		return set.size(); // Return the number of distinct islands
	}

	/**
	 * Depth First Search (DFS) to traverse the island and collect its coordinates.
	 * 
	 * @param arr      The 2D integer array representing the grid.
	 * @param row      The current row index.
	 * @param col      The current column index.
	 * @param visited  2D array to mark visited cells.
	 * @param srcRow   The row index of the source cell.
	 * @param srcCol   The column index of the source cell.
	 * @param list     List to store island coordinates relative to the source.
	 */
	private static void dfs(int[][] arr, int row, int col, boolean visited[][],
			int srcRow, int srcCol, ArrayList<String> list) {
		visited[row][col] = true; // Mark the current cell as visited

		// Add the relative coordinates of the current cell to the list
		list.add((Integer.toString(srcRow - row) + " "
				+ Integer.toString(srcCol - col)));

		int[] deltaRows = {-1, 0, 1, 0}; // Delta for rows to check adjacent cells
		int[] deltaCols = {0, -1, 0, 1}; // Delta for columns to check adjacent cells

		for (int delta = 0; delta < 4; delta++) {
			int currentRow = row + deltaRows[delta];
			int currentCol = col + deltaCols[delta];

			// Check if the adjacent cell is within the grid boundaries, unvisited, and part of the island
			if (currentRow >= 0 && currentRow < arr.length && currentCol >= 0
					&& currentCol < arr[0].length
					&& !visited[currentRow][currentCol]
					&& arr[currentRow][currentCol] == 1) {
				dfs(arr, currentRow, currentCol, visited, srcRow, srcCol, list); // Recursively call DFS for the adjacent cell
			}
		}
	}
	
	public static void main(String[] args) {
		// Example grid representing the land
		int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},
				{0, 0, 0, 1, 1}};

		// Get the number of rows and columns in the grid
		int n = grid.length;
		int m = grid[0].length;

		// Count the number of distinct islands in the grid
		int distinctIslands = G16DistinctIslandsDFS.distinctIsland(grid, n, m);

		// Print the result
		System.out.println("Number of distinct islands: " + distinctIslands);
	}
}
