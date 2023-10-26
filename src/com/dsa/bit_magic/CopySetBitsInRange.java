package com.dsa.bit_magic;

/**
 * Given two numbers X and Y, and a range [L, R] where 1 <= L <= R <= 32. You
 * have to copy the set bits of 'Y' in the range L to R in 'X'. Return this
 * modified X.
 * 
 * Note: Range count will be from Right to Left & start from 1.
 */
public class CopySetBitsInRange {
    
    // Function to copy set bits of 'Y' in the range L to R in 'X'
    static int setSetBit(int x, int y, int l, int r) {
        for (int i = l; i <= r; i++) {
            // Checking if the ith bit is set in 'Y'
            if (((1 << (i - 1)) & y) != 0) {
                // Setting the corresponding bit in 'X' if it's set in 'Y'
                x = (x | (1 << (i - 1)));
            }
        }
        // Returning the modified 'X'
        return x;
    }

    // Main method to test the setSetBit functionality
    public static void main(String[] args) {
        int x = 10; // Example value of X
        int y = 13; // Example value of Y
        int l = 2, r = 3; // Example range values for L and R
        int result = setSetBit(x, y, l, r); // Getting the modified X
        System.out.println("Modified X: " + result); // Printing the modified X
    }
}
