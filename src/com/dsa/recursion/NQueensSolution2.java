/**
 *  The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

	Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 	
 	Input: n = 4
	Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 
 */
package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolution2 {

    // Method to solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        // Create the chessboard and initialize with empty squares
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Initialize arrays to keep track of safe positions for placing queens
        int col = 0;
        List<List<String>> result = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        
        // Solve N-Queens problem using backtracking
        solveNQueens(board, col, n, result, leftRow, upperDiagonal, lowerDiagonal);
        return result;
    }

    // Recursive method to solve N-Queens problem using backtracking
    private void solveNQueens(char[][] board, int col, int n,
            List<List<String>> result, int[] leftRow, int[] upperDiagonal,
            int[] lowerDiagonal) {
        // If all queens are placed successfully, add the solution to the result list
        if (col == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                sol.add(sb.toString());
            }
            result.add(sol);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            // Check if the position is safe for placing a queen
            if (leftRow[row] == 0 && upperDiagonal[row + col] == 0
                    && lowerDiagonal[n - 1 + col - row] == 0) {
                board[row][col] = 'Q'; // Place the queen at (row, col)
                leftRow[row] = 1; // Mark the row as used
                upperDiagonal[row + col] = 1; // Mark the upper diagonal as used
                lowerDiagonal[n - 1 + col - row] = 1; // Mark the lower diagonal as used
                solveNQueens(board, col + 1, n, result, leftRow, upperDiagonal, lowerDiagonal);
                board[row][col] = '.'; // Backtrack: Remove the queen from (row, col)
                leftRow[row] = 0; // Reset the row as unused
                upperDiagonal[row + col] = 0; // Reset the upper diagonal as unused
                lowerDiagonal[n - 1 + col - row] = 0; // Reset the lower diagonal as unused
            }
        }
    }
    
    // Main method for demonstration
    public static void main(String[] args) {
        NQueensSolution2 nQueens = new NQueensSolution2();

        // Define the value of n for the N-Queens problem
        int n = 4;

        // Obtain and print all possible solutions for the N-Queens problem for n = 4
        List<List<String>> solutions = nQueens.solveNQueens(n);
        for (List<String> solution : solutions) {
            System.out.println("Solution:");
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
