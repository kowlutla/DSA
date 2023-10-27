package com.dsa.bit_magic;

/**
 * You are given a binary string s and an integer m. You need to return an
 * integer r. Where r = k%m, k is the binary equivalent of string s.
 */
public class BinaryModulo {

    // Function to compute modulo as specified
    static int modulo(String s, int m) {
        int ans = 0; // Initialize the result
        int power = 1; // Initialize the power variable
        for (int i = s.length() - 1; i >= 0; i--) { // Iterate through the string in reverse
            if (s.charAt(i) == '1') { // If the current character is '1'
                ans += power; // Add the power to the result
                ans %= m; // Take modulo of the result with m
            }
            power *= 2; // Multiply power by 2
            power %= m; // Take modulo of power with m
        }
        return ans; // Return the final computed result
    }

    // Main method to test the modulo function
    public static void main(String[] args) {
        // Sample input
        String binaryString = "1010"; // Sample binary string
        int m = 3; // Sample value of m

        // Output the inputs
        System.out.println("Binary String: " + binaryString);
        System.out.println("Value of m: " + m);

        // Call the modulo function and output the result
        System.out.println("Result: " + modulo(binaryString, m));
    }
}
