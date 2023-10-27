package com.dsa.bit_magic;

/**
 * Given an array A[] consisting of 0’s and 1’s. A flip operation is one in
 * which you turn 1 into 0 and a 0 into 1. You have to do at most one “Flip”
 * operation of any subarray. Formally, select a range (l, r) in the array A[],
 * such that (0 ≤ l ≤ r < n) holds and flip the elements in this range to get
 * the maximum ones in the final array. You can possibly make zero operations to
 * get the answer. You are asked to return the maximum number of 1 you can get
 * in the array after doing flip operation.
 */
public class MaxOnes {

    // Function to find the maximum number of 1s using the first implementation
    public static int maxOnes1(int a[], int n) {
        int max = 0; // Variable to store the maximum count of 1s after flipping
        int ones = 0; // Variable to count the number of 1s in the original array
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                int current = 1; // Count of 1s after flipping the current 0
                int currentMax = 1; // Maximum count of 1s after flipping the current range
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == 0) {
                        current++; // Increment current count of 1s if the element is 0
                    } else {
                        current--; // Decrement current count of 1s if the element is 1
                    }
                    currentMax = Math.max(current, currentMax); // Update the maximum count
                }
                max = Math.max(max, currentMax); // Update the overall maximum count of 1s
            } else {
                ones++; // Increment the count of 1s if the element is already 1
            }
        }
        return max + ones; // Return the sum of the maximum count and the initial count of 1s
    }

    // Function to find the maximum number of 1s using the second implementation
    public static int maxOnes(int a[], int n) {
        int zero = 0, one = 0, count = 0; // Variables to keep track of 0s, 1s, and maximum count
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero++; // Increment the count of 0s if the element is 0
            } else if (a[i] == 1) {
                one++; // Increment the count of 1s if the element is 1
                if (zero > 0) {
                    zero--; // Decrement the count of 0s if it's greater than 0
                }
            }
            count = Math.max(zero, count); // Update the maximum count based on 0s
        }
        return count + one; // Return the sum of the maximum count and the count of 1s
    }
    
    // Main method to test the maxOnes1 and maxOnes functionality
    public static void main(String[] args) {
        // Example usage
        int[] a = { 1, 1, 0, 1, 0, 1, 1 };
        int n = a.length;
        System.out.println("Maximum number of 1s after flip (Implementation 1): " + maxOnes1(a, n));
        System.out.println("Maximum number of 1s after flip (Implementation 2): " + maxOnes(a, n));
    }
}
