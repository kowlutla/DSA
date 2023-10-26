package com.dsa.mathematical;

/**
 * Given a number N. Find the minimum number of operations required to reach N
 * starting from 0. You have 2 operations available:
 * 
 * Double the number Add one to the number
 */
public class MinimumOperations {

    // Function to find the minimum number of operations required to reach N
    public int minOperation(int n) {
        int count = 0;
        // Iterate until n is greater than 0
        while (n > 0) {
            // If n is even, perform the operation n/2
            if (n % 2 == 0) {
                n = n / 2;
            } 
            // If n is odd, perform the operation n-1
            else {
                n = n - 1;
            }
            // Increment the count
            count++;
        }

        // Return the count of operations
        return count;
    }

    // Main method to test the minOperation functionality
    public static void main(String[] args) {
        // Example usage
        MinimumOperations minOps = new MinimumOperations();
        int n = 15;
        System.out.println("Minimum number of operations to reach " + n + " starting from 0: " + minOps.minOperation(n));
    }
}
