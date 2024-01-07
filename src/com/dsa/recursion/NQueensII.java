/**
 * 	The n-queens puzzle is the problem of placing n queens on an n x n 
 	chessboard such that no two queens attack each other.

	Given an integer n, return the number of distinct solutions to the n-queens puzzle.

	Example 1:
	Input: n = 4
	Output: 2
	Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

	Example 2:
	Input: n = 1
	Output: 1
 */
package com.dsa.recursion;

/**
 * @author KowlutlaSwamy
 *
 */
public class NQueensII {

    // Method to count the total number of distinct solutions for N-Queens problem
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        
        // Initialize the chessboard with empty squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Arrays to keep track of safe positions for queen placement
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        
        int col = 0;
        // Solve the N-Queens problem using backtracking
        return nQueen(board, col, n, leftRow, upperDiagonal, lowerDiagonal);
    }

    // Recursive method to solve the N-Queens problem using backtracking and count solutions
    private static int nQueen(char[][] board, int col, int n, int[] leftRow,
                              int[] upperDiagonal, int[] lowerDiagonal) {
        // If all queens are placed successfully, return 1 (indicating a valid solution)
        if (col == n) {
            return 1;
        }
        
        int count = 0; // Initialize count of valid solutions for the current column
        
        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && upperDiagonal[row + col] == 0
                    && lowerDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q'; // Place the queen at (row, col)
                leftRow[row] = 1; // Mark the row as used
                upperDiagonal[row + col] = 1; // Mark the upper diagonal as used
                lowerDiagonal[n - 1 + col - row] = 1; // Mark the lower diagonal as used

                // Recur for the next column and add the count of valid solutions
                count += nQueen(board, col + 1, n, leftRow, upperDiagonal,
                        lowerDiagonal);

                // Backtrack: Remove the queen from (row, col) and reset marks
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n - 1 + col - row] = 0;
            }
        }
        return count; // Return the count of valid solutions for the current state
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        int n = 5; // Set the board size
        NQueensII solution = new NQueensII();
        int totalSolutions = solution.totalNQueens(n); // Count the total number of solutions
        System.out.println("Total solutions for " + n + " queens: " + totalSolutions);
    }
}
