/**
 * 	An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
	You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
	To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
	Return the modified image after performing the flood fill.
	
	Example 1:
	Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
	Output: [[2,2,2],[2,2,0],[2,0,1]]
	Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
	Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

	Example 2:
	Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
	Output: [[0,0,0],[0,0,0]]
	Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 */
package com.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class G9FloodFillBFS {

    // Inner class representing a pair of row and column indices
    static private class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // Function to perform flood fill using Breadth-First Search (BFS)
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length; // Number of rows in the image
        int m = image[0].length; // Number of columns in the image
        boolean visited[][] = new boolean[n][m]; // Array to track visited cells
        Queue<Pair> q = new LinkedList<>(); // Queue for BFS traversal
        int C = image[sr][sc]; // Color of the starting pixel
        q.add(new Pair(sr, sc)); // Add the starting pixel to the queue
        visited[sr][sc] = true; // Mark the starting pixel as visited
        image[sr][sc] = color; // Fill the starting pixel with the new color

        // Perform BFS traversal
        while (!q.isEmpty()) {
            Pair node = q.poll(); // Dequeue a pixel from the queue
            int cRow = node.row; // Current row of the pixel
            int cCol = node.col; // Current column of the pixel

            // Define adjacent row and column indices
            int[] deltaRows = {-1, 1, 0, 0}; // Up, Down, Left, Right
            int[] deltaCols = {0, 0, -1, 1};

            // Explore all four adjacent pixels
            for (int i = 0; i < 4; i++) {
                int newRow = cRow + deltaRows[i]; // New row index
                int newCol = cCol + deltaCols[i]; // New column index

                // Check if the new pixel is within the image boundaries and has the same color as the starting pixel
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && image[newRow][newCol] == C) {
                    visited[newRow][newCol] = true; // Mark the new pixel as visited
                    image[newRow][newCol] = color; // Fill the new pixel with the new color
                    q.add(new Pair(newRow, newCol)); // Enqueue the new pixel for further exploration
                }
            }
        }

        return image; // Return the image after flood fill
    }
    
    public static void main(String[] args) {
        // Example image represented as a 2D array
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        // Starting row and column indices for flood fill
        int sr = 1;
        int sc = 1;

        // New color to be filled
        int newColor = 2;

        // Perform flood fill
        int[][] filledImage = G9FloodFillBFS.floodFill(image, sr, sc, newColor);

        // Display the filled image
        System.out.println("Filled Image:");
        for (int[] row : filledImage) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
