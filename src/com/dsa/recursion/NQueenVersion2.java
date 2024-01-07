/**
 * 	The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
	Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, 
	where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. 
	For eg below figure represents a chessboard [3 1 4 2].
	
	Example 1:
	Input:
	1
	Output:
	[1]
	Explaination:
	Only one queen can be placed 
	in the single cell available.

	Example 2:
	Input:
	4
	Output:
	[2 4 1 3 ] [3 1 4 2 ]
	Explaination:
	These are the 2 possible solutions.
 */
package com.dsa.recursion;

import java.util.ArrayList;

public class NQueenVersion2 {

    // Method to find all possible solutions for the N-Queens problem
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        char[][] board = new char[n][n];

        // Initialize the chessboard with empty squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Initialize the result list
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Arrays to keep track of safe positions for queen placement
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        int col = 0;
        // Solve the N-Queens problem using backtracking
        nQueen(board, col, n, result, leftRow, upperDiagonal, lowerDiagonal);
        return result;
    }

    // Recursive method to solve the N-Queens problem using backtracking
    private static void nQueen(char[][] board, int col, int n,
                               ArrayList<ArrayList<Integer>> result, int[] leftRow,
                               int[] upperDiagonal, int[] lowerDiagonal) {
        // If all queens are placed successfully, add the solution to the result list
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] == 'Q') {
                        // Record the row position of the queen in this column
                        solution.add(j + 1); // Adding 1 to convert 0-indexed position to 1-indexed
                    }
                }
            }
            result.add(solution);
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

                // Recur for the next column
                nQueen(board, col + 1, n, result, leftRow, upperDiagonal, lowerDiagonal);

                // Backtrack: Remove the queen from (row, col) and reset marks
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        int n = 5; // Set the board size
        ArrayList<ArrayList<Integer>> solutions = nQueen(n); // Find all possible solutions
        // Displaying the solutions
        for (ArrayList<Integer> solution : solutions) {
            System.out.println(solution);
        }
    }
}
