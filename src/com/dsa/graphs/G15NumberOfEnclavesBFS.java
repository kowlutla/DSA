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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G15NumberOfEnclavesBFS {

	/**
	 * Represents a pair of row and column coordinates.
	 */
	static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	/**
	 * Counts the number of enclaves in the given matrix using Breadth First Search (BFS).
	 * 
	 * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
	 * Space Complexity: O(n * m) for the visited array and the queue.
	 * 
	 * @param n       The number of rows in the matrix.
	 * @param m       The number of columns in the matrix.
	 * @param matrix  The 2D integer matrix representing the land.
	 * @return        The number of enclaves in the matrix.
	 */
	public static int matrixTraps(int n, int m, int[][] matrix) {
		boolean[][] visited = new boolean[n][m]; // Visited array to mark visited cells
		for (int row = 0; row < n; row++) {
			// Look for first column
			if (matrix[row][0] == 1 && !visited[row][0])
				bfs(visited, row, 0, matrix);

			// Look for last column
			if (matrix[row][m - 1] == 1 && !visited[row][m - 1])
				bfs(visited, row, m - 1, matrix);
		}

		for (int col = 0; col < m; col++) {
			// Look for first row
			if (matrix[0][col] == 1 && !visited[0][col])
				bfs(visited, 0, col, matrix);
			// Look for last row
			if (matrix[n - 1][col] == 1 && !visited[n - 1][col])
				bfs(visited, n - 1, col, matrix);
		}
		int result = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (matrix[row][col] == 1 && !visited[row][col]) {
					result++;
				}
			}
		}
		return result;
	}

	/**
	 * Breadth First Search (BFS) to mark visited cells.
	 * 
	 * @param visited     2D array to mark visited cells.
	 * @param row         The current row index.
	 * @param col         The current column index.
	 * @param matrix      The 2D integer matrix representing the land.
	 */
	private static void bfs(boolean[][] visited, int row, int col,
			int[][] matrix) {
		Queue<Pair> q = new LinkedList<>(); // Queue to perform BFS
		int deltaRows[] = {-1, 0, 1, 0}; // Delta for rows to check adjacent cells
		int deltaCols[] = {0, -1, 0, 1}; // Delta for columns to check adjacent cells
		visited[row][col] = true; // Mark the starting cell as visited
		q.add(new Pair(row, col)); // Add the starting cell to the queue
		while (!q.isEmpty()) {
			Pair node = q.poll(); // Dequeue the cell
			for (int delta = 0; delta < 4; delta++) { // Explore all four adjacent cells
				int currentRow = node.row + deltaRows[delta];
				int currentCol = node.col + deltaCols[delta];

				// Check if the adjacent cell is within the matrix boundaries, unvisited, and contains '1'
				if (currentRow >= 0 && currentRow < matrix.length
						&& currentCol >= 0 && currentCol < matrix[row].length
						&& !visited[currentRow][currentCol]
						&& matrix[currentRow][currentCol] == 1) {
					visited[currentRow][currentCol] = true; // Mark the adjacent cell as visited
					q.add(new Pair(currentRow, currentCol)); // Enqueue the adjacent cell
				}
			}
		}
	}
	
	public static void main(String[] args) {
        // Example matrix representing the land
        int[][] matrix = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };
        
        // Dimensions of the matrix
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        // Count the number of enclaves in the matrix
        int numberOfEnclaves = matrixTraps(n, m, matrix);

        // Print the result
        System.out.println("Number of enclaves: " + numberOfEnclaves);
    }
}
