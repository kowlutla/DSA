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

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G8FindTheNumberOfIslands {

	// Function to find the number of islands.
	public int numIslandsBFS(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];

		int islands = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (!visited[row][col] && grid[row][col] == '1') {
					islands++;
					bfs(grid, row, col, visited);
				}
			}
		}

		return islands;
	}

	class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
		visited[row][col] = true;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(row, col));
		while (!q.isEmpty()) {
			Pair node = q.poll();
			row = node.row;
			col = node.col;

			for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
				for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {
					int currentRow = deltaRow + row;
					int currentCol = deltaCol + col;
					if (currentRow >= 0 && currentRow < grid.length
							&& currentCol >= 0 && currentCol < grid[row].length) {
						if (!visited[currentRow][currentCol]
								&& grid[currentRow][currentCol] == '1') {
							visited[currentRow][currentCol] = true;
							q.add(new Pair(currentRow, currentCol));
						}
					}
				}
			}
		}
	}
}
