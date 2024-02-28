/**
 * 	Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. 
 	If there is no clear path, return -1.
	
	A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell 
	(i.e., (n - 1, n - 1)) such that:
	
	All the visited cells of the path are 0.
	All the adjacent cells of the path are 8-directionally connected 
	(i.e., they are different and they share an edge or a corner).
	The length of a clear path is the number of visited cells of this path.
	
	Example 1:
	Input: grid = [[0,1],[1,0]]
	Output: 2

	Example 2:
	Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
	Output: 4
	
	Example 3:
	Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
	Output: -1
 */
package com.dsa.graphs;

/**
 * @author KowlutlaSwamy
 *
 */
import java.util.LinkedList;
import java.util.Queue;

public class G36ShortestPathInBinaryMaze2 {

    // Pair class to represent coordinates and distance
    private class Pair {
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
     * Finds the shortest path in a binary matrix using BFS.
     * 
     * @param matrix The binary matrix representing the maze.
     * @return The length of the shortest path from top-left to bottom-right, or -1 if no path exists.
     */
    public int shortestPathBinaryMatrix(int[][] matrix) {
        Queue<Pair> q = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix[0][0] == 1) {
            return -1; // No path exists if the starting cell is blocked
        }

        int distance[][] = new int[rows][cols];

        // Initialize distance matrix with maximum values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0; // Starting cell has distance 0

        q.add(new Pair(0, 0, 1)); // Add starting cell to the queue with distance 1

        while (!q.isEmpty()) {
            Pair current = q.poll(); // Dequeue the current cell

            int currentDistance = current.distance;
            int currentRow = current.row;
            int currentCol = current.col;
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return currentDistance; // If reached the bottom-right cell, return the distance
            }

            // Explore all neighboring cells
            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {
                    int newRow = currentRow + deltaRow;
                    int newCol = currentCol + deltaCol;

                    // Check if the neighboring cell is within the matrix boundaries and is not blocked
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && matrix[newRow][newCol] == 0
                            && distance[newRow][newCol] > currentDistance + 1) {
                        distance[newRow][newCol] = 1 + currentDistance; // Update the distance
                        q.add(new Pair(newRow, newCol, currentDistance + 1)); // Enqueue the neighboring cell
                    }
                }
            }
        }
        return -1; // If no path exists to the bottom-right cell
    }
    
    public static void main(String[] args) {
        // Example binary matrix representing the maze
        int[][] matrix = {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {1, 1, 1, 0},
            {1, 1, 1, 0}
        };

        G36ShortestPathInBinaryMaze2 solver = new G36ShortestPathInBinaryMaze2();
        int shortestPathLength = solver.shortestPathBinaryMatrix(matrix);

        if (shortestPathLength != -1) {
            System.out.println("Shortest path length: " + shortestPathLength);
        } else {
            System.out.println("No path exists.");
        }
    }
}
