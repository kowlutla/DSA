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

/**
 * @author KowlutlaSwamy
 *
 */
public class G10FloodFillsDFS {

	// Function to perform flood fill using Depth-First Search (DFS)
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int C = image[sr][sc]; // Original color of the starting pixel
		boolean[][] visited = new boolean[image.length][image[0].length]; // Array to track visited cells
		dfs(image, sr, sc, color, C, visited); // Perform DFS from the starting pixel
		return image; // Return the modified image after flood fill
	}

	// Helper function for DFS traversal
	private void dfs(int[][] image, int row, int col, int color, int c,
			boolean[][] visited) {

		image[row][col] = color; // Fill the current pixel with the new color
		visited[row][col] = true; // Mark the current pixel as visited

		// Define adjacent row and column indices
		int[] deltaRows = {-1, 1, 0, 0}; // Up, Down, Left, Right
		int[] deltaCols = {0, 0, -1, 1};

		// Explore all four adjacent pixels
		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRows[i]; // New row index
			int newCol = col + deltaCols[i]; // New column index

			// Check if the new pixel is within the image boundaries and has the same color as the starting pixel
			if (newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length
					&& !visited[newRow][newCol] && image[newRow][newCol] == c) {
				dfs(image, newRow, newCol, color, c, visited); // Recursively call DFS for the new pixel
			}
		}
	}
	
	public static void main(String[] args) {
		// Example image represented as a 2D array
		int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

		// Starting row and column indices for flood fill
		int sr = 1;
		int sc = 1;

		// New color to be filled
		int newColor = 2;

		// Create an instance of G10FloodFillsDFS class
		G10FloodFillsDFS floodFiller = new G10FloodFillsDFS();

		// Perform flood fill
		int[][] filledImage = floodFiller.floodFill(image, sr, sc, newColor);

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
