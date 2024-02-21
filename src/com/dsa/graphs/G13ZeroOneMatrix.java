/**
 * 	Given an m x n binary matrix mat, return the distance of the 
 	nearest 0 for each cell.
	
	The distance between two adjacent cells is 1.
	Example 1:
	Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
	Output: [[0,0,0],[0,1,0],[0,0,0]]

	Example 2:
	Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
	Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class G13ZeroOneMatrix {

    /**
     * Class representing a pair of coordinates (row, col) and its distance from the source cell.
     */
    private static class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    /**
     * Updates the matrix with the distance of each cell from the nearest 0 cell using BFS.
     * 
     * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
     * Space Complexity: O(n * m) for the result matrix and O(n * m) for the visited array and queue.
     * 
     * @param grid The input matrix of size n x m containing 0s and 1s.
     * @return     The matrix updated with the distance of each cell from the nearest 0 cell.
     */
    public static int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Initialize the queue with cells having value 0
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    q.add(new Pair(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        int[] deltaRows = {0, -1, 0, 1};
        int[] deltaCols = {-1, 0, 1, 0};

        // Perform BFS traversal
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int currentRow = node.row;
            int currentCol = node.col;
            int distance = node.distance;

            // Check adjacent cells
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + deltaRows[i];
                int nextCol = currentCol + deltaCols[i];

                // If the adjacent cell is within the bounds and not visited yet
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol]) {
                    q.add(new Pair(nextRow, nextCol, distance + 1)); // Add it to the queue
                    visited[nextRow][nextCol] = true; // Mark it as visited
                    result[nextRow][nextCol] = distance + 1; // Update distance in result matrix
                }
            }
        }
        return result; // Return the result matrix
    }
    
    public static void main(String[] args) {
        // Example matrix containing 0s and 1s
        int[][] matrix = {
            {0, 1, 0, 1},
            {1, 1, 1, 0},
            {0, 1, 0, 0}
        };

        // Update the matrix with distances to the nearest cell containing a 0
        int[][] updatedMatrix = updateMatrix(matrix);

        // Print the updated matrix
        System.out.println("Updated Matrix:");
        for (int[] row : updatedMatrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
