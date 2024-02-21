/**
 * 	Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	
	Example 1:
	Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
	Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
	Explanation: Notice that an 'O' should not be flipped if:
	- It is on the border, or
	- It is adjacent to an 'O' that should not be flipped.
	The bottom 'O' is on the border, so it is not flipped.
	The other three 'O' form a surrounded region, so they are flipped.

	Example 2:
	Input: board = [["X"]]
	Output: [["X"]]
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
public class G14SurroundedRegionsDFS {

	/**
	 * Replaces 'O' surrounded by 'X' in the given matrix with 'X'.
	 * 
	 * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
	 * Space Complexity: O(n * m) for the visited array.
	 * 
	 * @param matrix The 2D character matrix.
	 */
	public static void replaceOWithX(char matrix[][]) {
		int n = matrix.length; // Number of rows in the matrix
		int m = matrix[0].length; // Number of columns in the matrix

		boolean[][] visited = new boolean[n][m]; // Visited array to mark visited cells

		int deltaRows[] = {0, -1, 0, 1}; // Delta for rows to check adjacent cells
		int deltaCols[] = {-1, 0, 1, 0}; // Delta for columns to check adjacent cells

		// Check for first and last row
		for (int col = 0; col < m; col++) {
			if (!visited[0][col] && matrix[0][col] == 'O') {
				dfs(matrix, visited, 0, col, deltaRows, deltaCols); // Start DFS from 'O' cell in the first row
			}

			if (!visited[n - 1][col] && matrix[n - 1][col] == 'O') {
				dfs(matrix, visited, n - 1, col, deltaRows, deltaCols); // Start DFS from 'O' cell in the last row
			}
		}

		// check for first and last columns
		for (int row = 0; row < n; row++) {

			if (!visited[row][0] && matrix[row][0] == 'O') {
				dfs(matrix, visited, row, 0, deltaRows, deltaCols); // Start DFS from 'O' cell in the first column
			}

			if (!visited[row][m - 1] && matrix[row][m - 1] == 'O') {
				dfs(matrix, visited, row, m - 1, deltaRows, deltaCols); // Start DFS from 'O' cell in the last column
			}
		}

		// Replace 'O's not visited by 'X'
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (matrix[row][col] == 'O' && !visited[row][col]) {
					matrix[row][col] = 'X'; // Replace 'O' with 'X'
				}
			}
		}
	}

	/**
	 * Depth First Search (DFS) to mark 'O's connected to boundary.
	 * 
	 * @param matrix     The 2D character matrix.
	 * @param visited    2D array to mark visited cells.
	 * @param row        The current row index.
	 * @param col        The current column index.
	 * @param deltaRows  Array containing row delta for adjacent cells.
	 * @param deltaCols  Array containing column delta for adjacent cells.
	 */
	private static void dfs(char[][] matrix, boolean[][] visited, int row,
			int col, int[] deltaRows, int[] deltaCols) {
		visited[row][col] = true; // Mark the current cell as visited
		for (int delta = 0; delta < 4; delta++) { // Explore all four adjacent cells
			int currentRow = row + deltaRows[delta];
			int currentCol = col + deltaCols[delta];

			// Check if the adjacent cell is within the matrix boundaries, unvisited, and contains 'O'
			if (currentRow >= 0 && currentRow < matrix.length && currentCol >= 0
					&& currentCol < matrix[0].length
					&& matrix[currentRow][currentCol] == 'O'
					&& !visited[currentRow][currentCol]) {
				dfs(matrix, visited, currentRow, currentCol, deltaRows,
						deltaCols); // Recursively explore the adjacent cell
			}
		}
	}
	
	 public static void main(String[] args) {
	        // Example matrix containing 'O's and 'X's
	        char[][] matrix = {
	            {'X', 'X', 'X', 'X'},
	            {'X', 'O', 'O', 'X'},
	            {'X', 'X', 'O', 'X'},
	            {'X', 'O', 'X', 'X'}
	        };

	        // Replace 'O's surrounded by 'X's in the matrix with 'X's
	        replaceOWithX(matrix);

	        // Print the updated matrix
	        System.out.println("Updated Matrix:");
	        for (char[] row : matrix) {
	            for (char cell : row) {
	                System.out.print(cell + " ");
	            }
	            System.out.println();
	        }
	    }
}
