/**
	You are given an m x n grid where each cell can have one of three values:
	
	0 representing an empty cell,
	1 representing a fresh orange, or
	2 representing a rotten orange.
	Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
	
	Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
	If this is impossible, return -1.
	
	Example 1:
	Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
	Output: 4

	Example 2:
	Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
	Output: -1
	Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten,
	because rotting only happens 4-directionally.

	Example 3:
	Input: grid = [[0,2]]
	Output: 0
	Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0. 
 */
package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class G10RottingOranges {

	// Inner class representing a pair of (row, col) coordinates and time
	class Pair {
		int row;
		int col;
		int time;

		public Pair(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	// Function to calculate the time required for all oranges to rot
	public int orangesRotting(int[][] grid) {
		int n = grid.length; // Number of rows
		int m = grid[0].length; // Number of columns
		Queue<Pair> q = new LinkedList<>(); // Queue to perform BFS
		int[][] visited = new int[n][m]; // Array to track visited cells
		int fresh = 0; // Count of fresh oranges

		// Initialize the queue and count the fresh oranges
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					visited[i][j] = 2; // Mark rotten oranges as visited
					q.add(new Pair(i, j, 0)); // Add rotten oranges to the queue
				} else if (grid[i][j] == 1) {
					fresh++; // Count fresh oranges
				}
			}
		}

		int deltaRows[] = {0, -1, 0, 1}; // Delta array for row indices
		int deltaCols[] = {-1, 0, 1, 0}; // Delta array for column indices
		int max = 0; // Maximum time taken for all oranges to rot

		// Perform BFS traversal
		while (!q.isEmpty()) {
			Pair node = q.poll(); // Dequeue the current node
			for (int delta = 0; delta < 4; delta++) {
				int neighbourRow = node.row + deltaRows[delta]; // Calculate neighbour row index
				int neighbourCol = node.col + deltaCols[delta]; // Calculate neighbour column index

				// Check if the neighbour is within the grid boundaries, not visited, and a fresh orange
				if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m
						&& visited[neighbourRow][neighbourCol] != 2 && grid[neighbourRow][neighbourCol] == 1) {
					fresh--; // Decrement count of fresh oranges
					visited[neighbourRow][neighbourCol] = 2; // Mark the neighbour as visited
					q.add(new Pair(neighbourRow, neighbourCol, node.time + 1)); // Add neighbour to the queue
					max = Math.max(node.time + 1, max); // Update the maximum time
				}
			}
		}

		return fresh == 0 ? max : -1; // If all oranges have rotted, return the maximum time, otherwise return -1
	}
	
	public static void main(String[] args) {
        // Example grid representing oranges
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 2}
        };

        // Create an instance of G11RottingOranges class
        G10RottingOranges rottingOranges = new G10RottingOranges();

        // Calculate the time required for all oranges to rot
        int time = rottingOranges.orangesRotting(grid);

        // Display the result
        if (time != -1) {
            System.out.println("Time required for all oranges to rot: " + time);
        } else {
            System.out.println("All oranges cannot rot");
        }
    }
}
