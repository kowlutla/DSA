package com.dsa.bit_magic;

/**
 * Given a number N having only one ‘1’ and all other ’0’s in its binary
 * representation, find the position of the only set bit. If there are 0 or more
 * than 1 set bit, the answer should be -1. The position of the set bit '1' should be
 * counted starting with 1 from the LSB side in the binary representation of the number.
 */
public class FirstPositionOfSetBit {

    // Function to find the position of the only set bit
    static int findPosition(int n) {
        // If n is 0, return -1 as there are no set bits
        if (n == 0) {
            return -1;
        }
        
        // If there is more than one set bit, return -1
        if ((n & (n - 1)) != 0) {
            return -1;
        }
        
        // Calculate the position of the set bit using logarithm base 2
        return (int) (Math.log(n) / Math.log(2.0)) + 1;
    }

    // Main method to test the findPosition functionality
    public static void main(String[] args) {
        // Example usage
        int n = 16; // Binary representation: 10000
        int position = findPosition(n);
        
        if (position != -1) {
            System.out.println("Position of the only set bit: " + position);
        } else {
            System.out.println("There is no or more than one set bit.");
        }
    }
}
