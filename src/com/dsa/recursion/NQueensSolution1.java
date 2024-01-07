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

public class NQueensSolution1 {

    // Method to solve the N-Queens problem
    public List<List<String>> solveNQueens(int n) {
        // Create the chessboard and initialize with empty squares
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int col = 0; // Start solving from the first column
        List<List<String>> result = new ArrayList<>(); // Initialize the result list
        solveNQueens(board, col, n, result); // Start solving using backtracking
        return result; // Return the list of solutions
    }

    // Recursive method to solve N-Queens problem using backtracking
    private void solveNQueens(char[][] board, int col, int n,
                              List<List<String>> result) {
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
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q'; // Place the queen at (row, col)
                solveNQueens(board, col + 1, n, result); // Move to the next column
                board[row][col] = '.'; // Backtrack: Remove the queen from (row, col)
            }
        }
    }

    // Helper method to check if placing a queen at a given position is safe
    private boolean isSafe(char[][] board, int row, int col) {
        // Check if there's a queen in the same row to the left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check the upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the lower diagonal on the left side
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // No conflicts found; it's safe to place a queen at (row, col)
    }

    // Main method for demonstration
    public static void main(String[] args) {
        NQueensSolution1 nQueens = new NQueensSolution1();

        // Define the value of n for the N-Queens problem
        int n = 6;

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

