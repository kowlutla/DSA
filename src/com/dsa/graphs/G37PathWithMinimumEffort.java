/**
 * 	You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
 	where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
	A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
	Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

	Example 1:
	Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
	Output: 2
	Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
	This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

	Example 2:
	Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
	Output: 1
	Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

	Example 3:
	Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
	Output: 0
	Explanation: This route does not require any effort.
 */
package com.dsa.graphs;

import java.util.PriorityQueue;

/**
 * @author KowlutlaSwamy
 *
 */
public class G37PathWithMinimumEffort {

    // A class to represent a cell in the grid with its row, column, and current effort to reach it.
    class Pair {
        int row;
        int col;
        int effort; // Renamed for clarity (original: effort)

        public Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    /**
     * Finds the path with the minimum required effort to reach the bottom-right corner of a grid,
     * where effort is the maximum of the current cell's height and the difference in height with the next cell.
     *
     * @param heights: A 2D matrix representing the grid heights.
     * @return The minimum effort required to reach the bottom-right corner, or -1 if no path exists.
     *
     * Time Complexity: O(V * E), where:
     *   - V: Number of cells in the grid (rows * cols).
     *   - E: Number of valid (in-bounds) connections between cells (can be less than V * 4 in sparse grids).
     *
     * Space Complexity: O(V), due to the priority queue and effort matrix used in the algorithm.
     */
    public int minimumEffortPath(int[][] heights) {
        // Use a priority queue to explore cells in order of increasing effort required to reach them.
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.effort - p2.effort);

        int rows = heights.length;
        int cols = heights[0].length;

        // Create a effort matrix to store the minimum effort discovered to reach each cell so far,
        // initialized with infinity values.
        int[][] effort = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                effort[i][j] = (int) 1e9;
            }
        }

        // Set the effort to reach the starting cell (top-left corner) to 0.
        effort[0][0] = 0;
        q.add(new Pair(0, 0, 0));

        // Define movement directions (up, down, left, right).
        int deltaRows[] = {-1, 0, 1, 0};
        int deltaCols[] = {0, -1, 0, 1};

        while (!q.isEmpty()) {
            // Dequeue the cell with the current minimum effort from the queue.
            Pair current = q.poll();

            int currenteffort = current.effort;
            int currentRow = current.row;
            int currentCol = current.col;

            // Check if the bottom-right corner (destination) is reached, return the effort if so.
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return currenteffort;
            }

            // Explore each of the four neighboring cells.
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + deltaRows[i];
                int nextCol = currentCol + deltaCols[i];

                // Check if the new cell is within the grid boundaries.
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    // Calculate the maximum effort required to reach the new cell.
                    int newEffort = Math.max(Math.abs(heights[currentRow][currentCol] - heights[nextRow][nextCol]), currenteffort);

                    // Update the effort matrix and priority queue if a new lower effort is found for the new cell.
                    if (newEffort < effort[nextRow][nextCol]) {
                        effort[nextRow][nextCol] = newEffort;
                        q.add(new Pair(nextRow, nextCol, newEffort));
                    }
                }
            }
        }

        // If the loop finishes without finding a path to the bottom-right corner, no path exists.
        return -1;
    }

    // **Example Usage:**
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        G37PathWithMinimumEffort solution = new G37PathWithMinimumEffort();
        int minEffort = solution.minimumEffortPath(heights);

        if (minEffort == -1) {
            System.out.println("No path found to reach the bottom-right corner.");
        } else {
            System.out.println("Minimum effort required: " + minEffort);
        }
    }
}
