/**
 * 	Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.

	Example 1:
	
	Input:
	R = 3, C = 3
	M = [[1, 3, 5], 
	     [2, 6, 9], 
	     [3, 6, 9]]
	Output: 5
	Explanation: Sorting matrix elements gives 
	us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
	 
	
	Example 2:
	
	Input:
	R = 3, C = 1
	M = [[1], [2], [3]]
	Output: 2
	Explanation: Sorting matrix elements gives 
	us {1,2,3}. Hence, 2 is median.
 */
package com.dsa.binarysearch;

/**
 * @author KowlutlaSwamy
 *
 */
public class MedianInRowWiseSortedMatrix {

    // Method to find the median in a row-wise sorted matrix
    public int median(int matrix[][], int R, int C) {
        // Find the minimum and maximum elements in the matrix
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            min = Math.min(min, matrix[i][0]); // Find the minimum element in each row
            max = Math.max(max, matrix[i][C - 1]); // Find the maximum element in each row
        }

        int low = min, high = max;

        // Binary search to find the median
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid value
            int count = 0;

            // Count elements smaller than mid in each row
            for (int i = 0; i < R; i++) {
                count += countSmallerThanMid(matrix[i], mid); // Count elements smaller than mid in the row
            }

            // Adjust the search range based on the count of smaller elements
            if (count <= (R * C) / 2) {
                low = mid + 1; // Median lies in the right half
            } else {
                high = mid - 1; // Median lies in the left half
            }
        }
        return low; // Return the median value
    }

    // Helper method to count elements smaller than a given value in a sorted array
    private int countSmallerThanMid(int[] arr, int val) {
        int low = 0, high = arr.length - 1;

        // Binary search to count elements smaller than the given value
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= val) {
                low = mid + 1; // Move to the right side of mid
            } else {
                high = mid - 1; // Move to the left side of mid
            }
        }
        return low; // Return the count of elements smaller than the given value
    }
    
    public static void main(String[] args) {
        MedianInRowWiseSortedMatrix medianFinder = new MedianInRowWiseSortedMatrix();

        // Example row-wise sorted matrix
        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Find the median of the matrix
        int median = medianFinder.median(matrix, rows, cols);

        System.out.println("Median of the row-wise sorted matrix: " + median);
    }
}
