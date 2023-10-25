package com.dsa.bit_magic;

/**
 * Given two numbers M and N. The task is to find the position of the rightmost
 * different bit in the binary representation of numbers.
 */
public class RightmostDifferentBit {

    // Function to find the position of the rightmost different bit
    public static int posOfRightMostDiffBit1(int m, int n) {
        // Find the XOR of the two numbers
        int xor = m ^ n;
        // If the XOR is 0, return -1 since there are no different bits
        if (xor == 0) {
            return -1;
        }
        // Initialize a count variable to keep track of the position
        int count = 0;
        // Iterate until xor becomes 0
        while (xor != 0) {
            // If the rightmost bit is 1, return the position
            if ((xor & 1) == 1) {
                return count + 1;
            }
            // Increment the count
            count++;
            // Right shift xor by 1
            xor = xor >> 1;
        }

        // Return -1 if no different bit is found
        return -1;
    }
    
    // Function to find the position of the rightmost different bit
    public static int posOfRightMostDiffBit2(int m, int n) {
        // Compute the XOR of the two numbers
        int xor = m ^ n;
        // If the XOR is 0, return -1 since there are no different bits
        if (xor == 0) {
            return -1;
        }
        
        // Calculate the position of the rightmost different bit using logarithmic operations
        return (int)(Math.log(xor & -xor) / Math.log(2.0) + 1);
    }

    // Main method to test the posOfRightMostDiffBit functionality
    public static void main(String[] args) {
        // Example usage
        int m = 10;
        int n = 20;
        System.out.println("Position of the rightmost different bit: " + posOfRightMostDiffBit2(m, n));
    }
}
