package com.dsa.bit_magic;

/**
 * Given a number N and a bit number K, check if Kth index bit of N is set or
 * not. A bit is called set if it is 1. Position of set bit '1' should be
 * indexed starting with 0 from LSB side in binary representation of the number.
 * Note: Index is starting from 0. You just need to return true or false, driver
 * code will take care of printing "Yes" and "No".
 */
public class CheckBit {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit1(int n, int k) {
        // Initialize a variable x as 1
        int x = 1;
        // Loop from 0 to k-1
        for (int i = 0; i < k; i++)
            // Update x as the product of x and 2
            x = x * 2;

        // Check if the bitwise AND of x and n is not 0
        if ((x & n) != 0) {
            // Return true if the Kth bit is set
            return true;
        } else {
            // Return false if the Kth bit is not set
            return false;
        }
    }
    
 // Function to check if Kth bit is set or not using bitwise operations
    static boolean checkKthBit2(int n, int k) {
        // Check if the bitwise AND of n and 2 raised to the power of k is not 0
        if ((n & (1 << k)) != 0) {
            // Return true if the Kth bit is set
            return true;
        }
        // Return false if the Kth bit is not set
        return false;
    }

    // Main method to test the CheckBit functionality
    public static void main(String[] args) {
        // Example usage
        int n = 5;
        int k = 2;
        System.out.println("Is the " + k + "th bit set in " + n + "? " + (checkKthBit2(n, k) ? "Yes" : "No"));
    }
}
