package com.dsa.matrix;

import java.util.ArrayList;

/**
 * Given a square matrix of size N*N, print the sum of upper and lower
 * triangular elements. Upper Triangle consists of elements on the diagonal and
 * above it. The lower triangle consists of elements on the diagonal and below
 * it.
 */
public class SumOfUpperAndLowerTriangles {

    // Function to calculate the sum of upper and lower triangular elements
    static ArrayList<Integer> sumTriangles(int matrix[][], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int lowerSum = 0; // Initialize the sum of lower triangular elements to 0
        int upperSum = 0; // Initialize the sum of upper triangular elements to 0

        // Traverse the matrix to calculate the sum of upper and lower triangular elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                lowerSum += matrix[i][j]; // Add the elements below or on the diagonal to the lowerSum
            }

            for (int j = i; j < n; j++) {
                upperSum += matrix[i][j]; // Add the elements on or above the diagonal to the upperSum
            }
        }

        result.add(upperSum); // Add the sum of upper triangular elements to the result list
        result.add(lowerSum); // Add the sum of lower triangular elements to the result list

        return result; // Return the result list
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = matrix.length;
        ArrayList<Integer> result = sumTriangles(matrix, n);
        System.out.println("Sum of upper triangular elements: " + result.get(0));
        System.out.println("Sum of lower triangular elements: " + result.get(1));
    }
}
