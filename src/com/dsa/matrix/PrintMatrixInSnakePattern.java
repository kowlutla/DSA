package com.dsa.matrix;

import java.util.ArrayList;

/**
 * Given a matrix of size N x N. Print the elements of the matrix in the snake
 */
public class PrintMatrixInSnakePattern {

    // Function to return a list of integers visited in snake pattern in the matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        int l = matrix.length; // Get the size of the matrix (assuming it's a square matrix)
        ArrayList<Integer> snake = new ArrayList<>(); // Create an ArrayList to store the elements in snake pattern

        // Traverse the matrix in a snake pattern
        for (int i = 0; i < l; i++) {
            if (i % 2 == 0) { // If the current row is even, traverse from left to right
                for (int j = 0; j < l; j++) {
                    snake.add(matrix[i][j]); // Add the element to the list
                }
            } else { // If the current row is odd, traverse from right to left
                for (int j = l - 1; j >= 0; j--) {
                    snake.add(matrix[i][j]); // Add the element to the list
                }
            }
        }
        return snake; // Return the list containing elements in snake pattern
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        ArrayList<Integer> result = snakePattern(matrix);
        
        // Print the elements in snake pattern
        System.out.println("Matrix elements in snake pattern: " + result);
    }
}
