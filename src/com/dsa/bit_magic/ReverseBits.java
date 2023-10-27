package com.dsa.bit_magic;

/**
 * Given a 32-bit number X, reverse its binary form and print the answer in
 * decimal.
 */
public class ReverseBits {

    // Function to reverse the bits of the number
    static Long reversedBits1(Long X) {
        long result = 0; // Initialize the result to 0
        for (int i = 0; i < 32; i++) {
            long mask = X & (1 << i); // Mask the bits at each position

            // Reversing the bits and updating the result
            if (i < 16) {
                result = result | mask << (31 - (i << 1));
            } else {
                result = result | mask >> ((i << 1) - 31);
            }
        }
        return result; // Return the reversed bits
    }

    // Function to reverse the bits of the number
    static Long reversedBits(Long X) {
        Long result = 0l; // Initialize the result to 0
        double power = Math.pow(2, 31); // Initialize power to 2^31

        // Reversing the bits and updating the result
        while (X > 0) {
            if (X % 2 == 1) {
                result += (long) power;
            }
            X /= 2;
            power /= 2;
        }

        return result; // Return the reversed bits
    }

    // Main method to test the functions
    public static void main(String[] args) {
        // Example usage
        Long number = 23L; // Example number
        // Testing the two methods
        System.out.println("Using reversedBits1 method: " + reversedBits1(number));
        System.out.println("Using reversedBits method: " + reversedBits(number));
    }
}
