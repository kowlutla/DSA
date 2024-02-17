/**
 * 	Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
	Example 1:
	Input: matrix =
	[
	  [0,1,1,1],
	  [1,1,1,1],
	  [0,1,1,1]
	]
	Output: 15
	Explanation: 
	There are 10 squares of side 1.
	There are 4 squares of side 2.
	There is  1 square of side 3.
	Total number of squares = 10 + 4 + 1 = 15.

	Example 2:
	Input: matrix = 
	[
	  [1,0,1],
	  [1,1,0],
	  [1,1,0]
	]
	Output: 7
	Explanation: 
	There are 6 squares of side 1.  
	There is 1 square of side 2. 
	Total number of squares = 6 + 1 = 7.
 */
package com.dsa.dynamic_programming;

/**
 * @author KowlutlaSwamy
 *
 */
public class DP56CountSquareSubmatricesWithAllOnes {

    /**
     * This method counts the number of square submatrices containing only 1s in a given matrix.
     *
     * @param N Number of rows in the matrix.
     * @param M Number of columns in the matrix.
     * @param mat The input matrix containing 0s and 1s.
     * @return The number of square submatrices with all 1s.
     */
    public static int countSquares(int N, int M, int mat[][]) {
        int[][] dp = new int[N][M]; // Create a 2D array to store dynamic programming results.
        int result = 0;

        // Fill the DP table using dynamic programming approach.
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                // Base cases: for the first row and column, consider only the current element.
                if (row == 0 || col == 0) {
                    dp[row][col] = mat[row][col];
                } else {
                    // If current element is 1, consider it part of a square only if its neighbors also form a square.
                    // Use minimum size from left, top, or diagonal neighbor squares to determine current square size.
                    if (mat[row][col] == 1) {
                        dp[row][col] = 1 + Math.min(dp[row][col - 1], Math.min(dp[row - 1][col], dp[row - 1][col - 1]));
                    } else {
                        // If current element is 0, no square can be formed here.
                        dp[row][col] = 0;
                    }
                }

                // Add the size of the square ending at this cell to the total count.
                result += dp[row][col];
            }
        }

        return result;
    }

    // Main method to test the code with an example
    public static void main(String[] args) {
        int N = 3, M = 4;
        int[][] mat = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 0}};

        int count = countSquares(N, M, mat);
        System.out.println("Number of square submatrices with all 1s: " + count); // Output: 7
    }
}
