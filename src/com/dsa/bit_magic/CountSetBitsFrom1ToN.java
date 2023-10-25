package com.dsa.bit_magic;
public class CountSetBitsFrom1ToN {

    // Function to return the sum of count of set bits in the integers from 1 to n
    public static int countSetBits1(int temp) {
        // Initialize a variable to keep track of the count of set bits
        int count = 0;
        // Iterate from 1 to temp
        for (int i = 1; i <= temp; i++) {
            int n = i;
            // Count the set bits for each number from 1 to temp
            while (n > 0) {
                if (n % 2 == 1) {
                    count++;
                }
                n = n / 2;
            }
        }
        // Return the total count of set bits from 1 to temp
        return count;
    }

    // Function to count set bits in the integers from 1 to n using bitwise operations
    public static int countSetBits(int n) {
        // Ignoring 0 as all the bits are unset
        n += 1;
        int count = 0;

        // Counting set bits from 1 to n
        for (int x = 2; x / 2 < n; x = x * 2) {
            // Total count of pairs of 0s and 1s
            int quotient = n / x;
            // Quotient gives the complete count of pairs of 1s
            // Multiplying it with the (current power of 2)/2 will give
            // the count of 1s in the current bit
            count += quotient * x / 2;

            int remainder = n % x;
            // If the count of pairs is odd then we add the remaining 1s
            // which could not be grouped together
            if (remainder > x / 2)
                count += remainder - x / 2;
        }

        // Returning count of set bits
        return count;
    }

    // Main method to test the countSetBits functionality
    public static void main(String[] args) {
        // Example usage
        int n = 10;
        System.out.println("Using countSetBits1: " + countSetBits1(n));
        System.out.println("Using countSetBits: " + countSetBits(n));
    }
}
