package com.dsa.bit_magic;

/**
 * Given two integers a and b. Find the sum of two numbers without using
 * arithmetic operators.
 */
public class SumOfTwoNumbers {

    // Method to find the sum of two numbers without using arithmetic operators
    static int sum(int a, int b) {
        int add = a ^ b; // Calculate the sum without carrying
        int carry = a & b; // Calculate the carry
        if (carry == 0) { // If there is no carry, return the sum
            return add;
        } else { // If there is a carry, recursively call the sum method with shifted carry
            return sum(add, carry << 1);
        }
    }

    // Main method for testing the sum method
    public static void main(String[] args) {
        // Example input
        int a = 10;
        int b = 5;

        // Compute the sum of a and b using the sum method
        int result = sum(a, b);

        // Print the result
        System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }
}
