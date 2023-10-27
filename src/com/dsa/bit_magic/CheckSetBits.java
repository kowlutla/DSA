package com.dsa.bit_magic;

/**
 * Given a number N. You have to check whether every bit in the binary
 * representation of the given number is set or not.
 */
public class CheckSetBits {
    // Method to check whether every bit in the binary representation of the given number is set or not
    static int isBitSet(int n) {

        // If the number is 0, return 0
        if (n == 0) {
            return 0;
        }

        // Check if the bitwise AND of the number and (number + 1) is 0
        // If it is 0, return 1; otherwise, return 0
        return (n & (n + 1)) == 0 ? 1 : 0;
    }
    
    // Main method for testing the isBitSet method
    public static void main(String[] args) {
        int num = 7; // Example input number

        // Call the isBitSet method and store the result
        int result = isBitSet(num);

        // Print the appropriate message based on the result
        if (result == 0) {
            System.out.println("Number does not contain all set bits.");
        } else {
            System.out.println("Number contains all set bits.");
        }
    }
}
