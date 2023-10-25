package com.dsa.bit_magic;

/**
 * You are given two numbers A and B. The task is to count the number of bits
 * needed to be flipped to convert A to B.
 */
public class BitDifference {
    
    // Function to find the number of bits needed to be flipped to convert A to B
    public static int countBitsFlip1(int a, int b) {

        // Initialize a variable to count the differences
        int dif = 0;
        // Loop until both a and b are greater than 0
        while (a > 0 || b > 0) {
            // Get the rightmost bits of a and b
            int val1 = a & 1;
            int val2 = b & 1;

            // If the bits are different, increment the difference count
            if (val1 != val2)
                dif++;
            // Right shift a and b by 1
            a = a >> 1;
            b = b >> 1;

        }
        // Return the total count of differences
        return dif;
    }

    // Function to find the number of bits needed to be flipped to convert A to B using XOR
    public static int countBitsFlip(int a, int b) {
        // Compute the XOR of a and b
        int xor = a ^ b;
        // If the XOR is 0, return 0 since there are no differing bits
        if (xor == 0) {
            return 0;
        }

        // Initialize a variable to count the differing bits
        int count = 0;
        // Iterate until xor is greater than 0
        while (xor > 0) {
            // Clear the rightmost set bit of xor and increment the count
            xor = xor & (xor - 1);
            count++;
        }

        // Return the total count of differing bits
        return count;
    }

    // Main method to test the countBitsFlip functionality
    public static void main(String[] args) {
        // Example usage
        int a = 5;
        int b = 10;
        System.out.println("Number of bits needed to be flipped: " + countBitsFlip(a, b));
    }
}
