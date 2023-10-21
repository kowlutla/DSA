package com.dsa.mathematical;

/**
 * You are given an array A of size N. Let us denote S as the sum of all
 * integers present in the array. Among all integers present in the array, find
 * the minimum integer X such that S ≤ N*X.
 * 
 */
public class MinimumInteger {

    /**
     * Finds the minimum integer X from the array A based on the sum of all
     * integers in the array.
     * 
     * @param N the size of the array A
     * @param A the array of integers
     * @return the minimum integer X such that S ≤ N*X
     */
    public static int minimumInteger(int N, int[] A) {
        // Calculate the sum of all elements in the array A
        long sum = 0;
        for (int val : A) {
            sum += val;
        }

        // Initialize result with the maximum possible integer value
        int result = Integer.MAX_VALUE;

        // Iterate through each element in the array A
        for (int i = 0; i < N; i++) {
            // Check if the condition A[i]*N >= sum holds true
            if ((long) A[i] * N >= sum) {
                // If the condition is satisfied, update the result to be the minimum value
                if (A[i] < result) {
                    result = A[i];
                }
            }
        }

        // Return the minimum value
        return result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test case 1
        int N1 = 3;
        int[] A1 = { 1, 3, 2 };
        System.out.println("Minimum Integer for N = " + N1 + ", A = { 1, 3, 2 } is " + minimumInteger(N1, A1));

        // Test case 2
        int N2 = 1;
        int[] A2 = { 3 };
        System.out.println("Minimum Integer for N = " + N2 + ", A = { 3 } is " + minimumInteger(N2, A2));
    }
}
