package com.dsa.binarysearch;
import java.util.ArrayList;
import java.util.List;

public class MaxOnesInRowOfMatrix {

    // Method to find the row with the maximum number of 1s in a matrix represented by ArrayLists
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int currentMaxOnes = 0;
        int indexWithMaxOnes = -1;

        // Iterate through each row in the matrix
        for (int i = 0; i < n; i++) {
            // Calculate the number of 1s in the current row
            int onesInCurrentRow = m - getLowerBoundOfOne(matrix.get(i));

            // Update if the number of 1s in the current row is greater than the current maximum
            if (onesInCurrentRow > currentMaxOnes) {
                indexWithMaxOnes = i;
                currentMaxOnes = onesInCurrentRow;
            }
        }

        return indexWithMaxOnes; // Return the index of the row with the most 1s
    }

    // Helper method to find the lower index of 1 in a sorted ArrayList using binary search
    private static int getLowerBoundOfOne(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1;

        // Binary search to find the lower index of 1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) == 1) {
                high = mid - 1; // Adjust the search range
            } else {
                low = mid + 1; // Adjust the search range
            }
        }

        return low; // Return the lower index of 1
    }

    // Example main method to demonstrate the usage of maximumOnesRow method
    public static void main(String[] args) {
        // Example matrix represented by ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(List.of(0, 0, 1, 1)));
        matrix.add(new ArrayList<>(List.of(0, 1, 1, 1)));
        matrix.add(new ArrayList<>(List.of(0, 0, 0, 1)));
        matrix.add(new ArrayList<>(List.of(1, 1, 1, 1)));

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int rowWithMaxOnes = maximumOnesRow(matrix, rows, cols);

        if (rowWithMaxOnes != -1) {
            System.out.println("Row with maximum 1s is: " + rowWithMaxOnes);
        } else {
            System.out.println("Invalid matrix or no 1s found.");
        }
    }
}
