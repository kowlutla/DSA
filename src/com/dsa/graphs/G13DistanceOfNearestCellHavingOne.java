/**
 * 	You have been given a binary matrix 'MAT' containing only 0’s and 1’s of size N x M. 
 	You need to find the distance of the nearest cell having 1 in the matrix for each cell.
	
	The distance is calculated as |i1 – i2| + |j1 – j2|, where i1, j1 are the coordinates of 
	the current cell and i2, j2 are the coordinates of the nearest cell having value 1.
	Note :
	You can only move in four directions which are : Up, Down, Left and Right.
	
	For example :
	If N = 3, M = 4
	and mat[ ][ ] = { 0, 0, 0, 1,
	                  0, 0, 1, 1,
	                  0, 1, 1, 0 }
	then the output matrix will be
	3  2  1  0
	2  1  0  0
	1  0  0  1
	Detailed explanation ( Input/output format, Notes, Images )
	Constraints:
	1 <= T <= 5
	1 <= N <= 2*10^2
	1 <= M <= 2*10^2
	
	Where ‘T’ is the number of test cases, ‘N’ is the number of rows in the matrix and ‘M’ is the number of columns in the matrix.
	Sample Input 1:
	1
	3 4
	0 0 0 1
	0 0 1 1
	0 1 1 0
	Sample Output 1:
	3 2 1 0
	2 1 0 0
	1 0 0 1
	
	Sample Input 2:
	1
	3 3
	1 0 0 
	0 0 1 
	0 1 1
	Sample Output 2:
	0 1 1 
	1 1 0 
	1 0 0
 */
package com.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G13DistanceOfNearestCellHavingOne {

    /**
     * Class representing a pair of coordinates (row, col) and its distance from the source cell.
     */
    private static class Pair {
        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.col = col;
            this.row = row;
            this.distance = distance;
        }
    }

    /**
     * Finds the distance of the nearest cell having value 1 for each cell in the given matrix.
     * 
     * Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the matrix.
     * Space Complexity: O(n * m) for the result matrix and O(n * m) for the visited array and queue.
     * 
     * @param mat The matrix of size n x m containing 0s and 1s.
     * @param n   The number of rows in the matrix.
     * @param m   The number of columns in the matrix.
     * @return    A matrix containing the distances of the nearest cell having value 1 for each cell.
     */
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        // Initialize the queue and visited array with cells having value 1
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat.get(row).get(col) == 1) {
                    visited[row][col] = true;
                    q.add(new Pair(row, col, 0));
                }
                result.get(row).add(0); // Initialize result matrix with 0s
            }
        }

        int deltaRows[] = {0, -1, 0, 1};
        int deltaCols[] = {-1, 0, 1, 0};

        // Perform BFS traversal
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int currentrow = node.row;
            int currentCol = node.col;
            int distance = node.distance;

            // Check adjacent cells
            for (int i = 0; i < 4; i++) {
                int row = currentrow + deltaRows[i];
                int col = currentCol + deltaCols[i];
                // If the adjacent cell is within the bounds and not visited yet
                if (row >= 0 && row < n && col >= 0 && col < m && !visited[row][col]) {
                    visited[row][col] = true; // Mark it as visited
                    result.get(row).set(col, distance + 1); // Update distance in result matrix
                    q.add(new Pair(row, col, distance + 1)); // Add it to the queue
                }
            }
        }
        return result; // Return the result matrix
    }
    public static void main(String[] args) {
        // Example matrix containing 0s and 1s
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(List.of(0, 0, 0, 1)));
        mat.add(new ArrayList<>(List.of(0, 0, 1, 1)));
        mat.add(new ArrayList<>(List.of(0, 1, 1, 0)));

        // Get the number of rows and columns in the matrix
        int n = mat.size();
        int m = mat.get(0).size();

        // Find the distances of the nearest cell having value 1 for each cell
        ArrayList<ArrayList<Integer>> result = G13DistanceOfNearestCellHavingOne.nearest(mat, n, m);

        // Print the result
        System.out.println("Distances of nearest cell having value 1 for each cell:");
        for (ArrayList<Integer> row : result) {
            for (int distance : row) {
                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }
}
