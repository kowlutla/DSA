package com.dsa.matrix;

/**
 * https://www.geeksforgeeks.org/problems/predict-the-column/1
 *
 * Given a matrix(2D array) M of size N*N consisting of 0s and 1s only. The task
 * is to find the column with the maximum number of 0s. If more than one column
 * exists, print the one which comes first. If the maximum number of 0s is 0,
 * then return -1.
 */
public class PredictTheColumn {

    // Function to find the column with the maximum number of 0s
    int columnWithMaxZeros(int arr[][], int N) {
        int maxIndex = -1; // Initialize the index of the column with the maximum number of 0s to -1
        int max = -1; // Initialize the maximum count of 0s to -1

        // Traverse each column
        for (int i = 0; i < N; i++) {
            int count = 0; // Initialize the count of 0s in the current column to 0

            // Traverse each row in the current column
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0) {
                    count++; // Increment the count for each 0 in the column
                }
            }

            // Check if the count is not zero and greater than the current maximum
            if (count != 0 && count > max) {
                max = count; // Update the maximum count
                maxIndex = i; // Update the index of the column with the maximum count
            }

            // If the maximum count is equal to the total number of rows, return the current maxIndex
            if (max == N) {
                return maxIndex;
            }
        }

        return maxIndex; // Return the index of the column with the maximum count of 0s
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        PredictTheColumn obj = new PredictTheColumn();
        int[][] matrix = {
            {1, 0, 1},
            {0, 0, 1},
            {0, 1, 1}
        };
        int N = matrix.length;
        int result = obj.columnWithMaxZeros(matrix, N);
        
        // Print the index of the column with the maximum number of 0s
        System.out.println("Column with the maximum number of 0s: " + result);
    }
}
