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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author KowlutlaSwamy
 *
 */
public class G16DistinctIslandsBFS {

	private static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	/**
	 * Counts the number of distinct islands in the given 2D grid using Breadth First Search (BFS).
	 * 
	 * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the grid.
	 * Space Complexity: O(n * m) for the visited array and the set to store distinct islands.
	 * 
	 * @param grid The 2D integer array representing the grid.
	 * @return     The number of distinct islands in the grid.
	 */
	public static int distinctIsland(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m];
		Set<ArrayList<String>> set = new HashSet<>(); // Set to store distinct islands

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (!visited[row][col] && grid[row][col] == 1) {
					ArrayList<String> list = new ArrayList<>(); // List to store island coordinates relative to the source
					bfs(grid, list, visited, row, col); // Perform BFS traversal
					set.add(list); // Add the island coordinates to the set
				}
			}
		}

		return set.size(); // Return the number of distinct islands
	}

	/**
	 * Breadth First Search (BFS) to traverse the island and collect its coordinates.
	 * 
	 * @param grid     The 2D integer array representing the grid.
	 * @param list     List to store island coordinates relative to the source.
	 * @param visited  2D array to mark visited cells.
	 * @param row      The row index of the source cell.
	 * @param col      The column index of the source cell.
	 */
	private static void bfs(int[][] grid, ArrayList<String> list, boolean[][] visited,
			int row, int col) {

		int[] deltaRows = {-1, 0, 1, 0}; // Delta for rows to check adjacent cells
		int[] deltaCols = {0, -1, 0, 1}; // Delta for columns to check adjacent cells
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(row, col)); // Add the source cell to the queue
		list.add(Integer.toString(0) + " " + Integer.toString(0)); // Add the relative coordinates of the source cell to the list
		visited[row][col] = true; // Mark the source cell as visited

		while (!q.isEmpty()) {
			Pair node = q.poll(); // Dequeue the cell from the queue

			for (int delta = 0; delta < 4; delta++) {
				int currentRow = node.row + deltaRows[delta]; // Calculate the row index of the adjacent cell
				int currentCol = node.col + deltaCols[delta]; // Calculate the column index of the adjacent cell

				// Check if the adjacent cell is within the grid boundaries, unvisited, and part of the island
				if (currentRow >= 0 && currentRow < grid.length
						&& currentCol >= 0 && currentCol < grid[0].length
						&& !visited[currentRow][currentCol]
						&& grid[currentRow][currentCol] == 1) {
					visited[currentRow][currentCol] = true; // Mark the adjacent cell as visited
					list.add(Integer.toString(currentRow - row) + " "
							+ Integer.toString(currentCol - col)); // Add the relative coordinates of the adjacent cell to the list
					q.add(new Pair(currentRow, currentCol)); // Enqueue the adjacent cell
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Example grid representing the land
		int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},
				{0, 0, 0, 1, 1}};

		// Count the number of distinct islands in the grid
		int distinctIslands = distinctIsland(grid);

		// Print the result
		System.out.println("Number of distinct islands: " + distinctIslands);
	}
}
