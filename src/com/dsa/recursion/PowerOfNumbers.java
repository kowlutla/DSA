package com.dsa.recursion;

/**
 * Given a number and its reverse. Find that number raised to the power of its
 * own reverse. Note: As answers can be very large, print the result modulo 10^9 + 7.
 */
public class PowerOfNumbers {

    int mod = 1000000007;

    /**
     * This method calculates the power of a number modulo a specified value.
     * @param x The base.
     * @param y The exponent.
     * @return The result of x raised to the power of y modulo the specified value.
     */
    long power(int x, int y) {
        long temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2) % mod;

        if (y % 2 == 0)
            return (temp * temp) % mod;
        else
            return ((x * temp) % mod * temp) % mod;
    }

    /**
     * The main method for testing the power method.
     */
    public static void main(String[] args) {
        PowerOfNumbers powerOfNumbers = new PowerOfNumbers();

        // Test the power method with different inputs
        int base1 = 12, exponent1 = 21; // Expected output: 864354781
        int base2 = 4, exponent2 = 4; // Expected output: 256

        // Testing power method
        System.out.println("The result of " + base1 + " raised to the power of " + exponent1 + " is: " + powerOfNumbers.power(base1, exponent1));
        System.out.println("The result of " + base2 + " raised to the power of " + exponent2 + " is: " + powerOfNumbers.power(base2, exponent2));

        // Expected output for the provided test cases:
        // The result of 12 raised to the power of 21 is: 864354781
        // The result of 4 raised to the power of 4 is: 256
    }
}
