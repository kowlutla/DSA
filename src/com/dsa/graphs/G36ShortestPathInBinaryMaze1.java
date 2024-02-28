/**
 * 	Given a n * m matrix grid where each element can either be 0 or 1. 
 	You need to find the shortest distance between a given source cell 
 	to a destination cell. The path can only be created out of a cell 
 	if its value is 1. 
	
	If the path is not possible between source cell and destination cell, 
	then return -1.
	
	Note : You can move into an adjacent cell if that adjacent cell is 
	filled with element 1. Two cells are adjacent if they share a side. 
	In other words, you can move in one of the four directions, Up, Down, Left and Right. 
	The source and destination cell are based on the zero based indexing. 
	The destination cell should be 1.
	
	Example 1:
	Input:
	grid[][] = {{1, 1, 1, 1},
	            {1, 1, 0, 1},
	            {1, 1, 1, 1},
	            {1, 1, 0, 0},
	            {1, 0, 0, 1}}
	source = {0, 1}
	destination = {2, 2}
	Output:
	3
	Explanation:
	1 1 1 1
	1 1 0 1
	1 1 1 1
	1 1 0 0
	1 0 0 1
	The highlighted part in the matrix denotes the 
	shortest path from source to destination cell.

	Example 2:
	Input:
	grid[][] = {{1, 1, 1, 1, 1},
	            {1, 1, 1, 1, 1},
	            {1, 1, 1, 1, 0},
	            {1, 0, 1, 0, 1}}
	source = {0, 0}
	destination = {3, 4}
	Output:
	-1
	Explanation:
	The path is not possible between source and 
	destination, hence return -1.
 */
package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G36ShortestPathInBinaryMaze1 {

    // A class to represent a cell in the maze with its row, column, and distance from the source.
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
     * Implements Breadth-First Search (BFS) with Dijkstra's approach to find the shortest path through a binary maze.
     *
     * @param matrix: A 2D matrix representing the maze (0s for walls, 1s for paths).
     * @param source: An array containing the source cell's row and column (e.g., [0, 1]).
     * @param destination: An array containing the destination cell's row and column (e.g., [2, 3]).
     * @return The shortest distance from the source to the destination, or -1 if no path exists.
     *
     * Time Complexity: O(V * E), where:
     *   - V: Number of cells in the maze (rows * cols).
     *   - E: Number of valid (unblocked) connections between cells (can be less than V * 4 in sparse mazes).
     *
     * Space Complexity: O(V), due to the queue and distance matrix used in the algorithm.
     */
    public int shortestPath(int[][] matrix, int[] source, int[] destination) {
        // Use a queue to explore cells in a Breadth-First Search manner.
        Queue<Pair> q = new LinkedList<>();

        // Get the dimensions of the maze.
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check if the source cell is a wall, indicating no path exists.
        if (matrix[source[0]][source[1]] == 0) {
            return -1;
        }

        // Create a distance matrix to store the shortest distance discovered for each cell so far,
        // initialized with infinity values.
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }

        // Set the distance of the source cell to 0.
        distance[source[0]][source[1]] = 0;

        // Define arrays representing the four directions (up, down, left, right) for exploring adjacent cells.
        int[] deltaRows = {0, -1, 0, 1};
        int[] deltaCols = {-1, 0, 1, 0};

        // Add the source cell as the starting point with distance 0 to the queue.
        q.add(new Pair(source[0], source[1], 0));

        // BFS loop to explore the maze.
        while (!q.isEmpty()) {
            // Dequeue the current cell from the queue.
            Pair current = q.poll();

            // Extract current distance, row, and column from the current cell.
            int currentDistance = current.distance;
            int currentRow = current.row;
            int currentCol = current.col;

            // Check if the destination cell is reached, return the distance if so.
            if (currentRow == destination[0] && currentCol == destination[1]) {
                return currentDistance;
            }

            // Explore each of the four directions around the current cell.
            for (int i = 0; i < 4; i++) {
                int newRow = currentRow + deltaRows[i];
                int newCol = currentCol + deltaCols[i];

                // Check if the new cell is within the maze boundaries, is a path, and has a potential
                // shorter distance based on the current distance plus 1.
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && matrix[newRow][newCol] == 1 && distance[newRow][newCol] > currentDistance + 1) {
                    // Update the distance of the new cell and add it to the queue for further exploration.
                    distance[newRow][newCol] = currentDistance + 1;
                    q.add(new Pair(newRow, newCol, currentDistance + 1));
                }
            }
        }

        // If the loop finishes without finding the destination, return -1 (no path exists).
        return -1;
    }

    public static void main(String[] args) {
        // Example usage of the shortestPath function

        int[][] maze = {
            {0, 1, 0, 0, 1},
            {0, 1, 0, 1, 1},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
        };

        int[] source = {0, 1}; // Starting point (row, column)
        int[] destination = {4, 4}; // End point (row, column)

        G36ShortestPathInBinaryMaze1 obj = new G36ShortestPathInBinaryMaze1();
        int shortestDistance = obj.shortestPath(maze, source, destination);

        if (shortestDistance == -1) {
            System.out.println("No path found from source to destination.");
        } else {
            System.out.println("Shortest path from source to destination: " + shortestDistance);
        }
    }
}

