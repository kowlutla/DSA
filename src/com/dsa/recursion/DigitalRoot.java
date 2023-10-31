package com.dsa.recursion;

/**
 * You are given a number n. You need to find the digital root of n. DigitalRoot
 * of a number is the recursive sum of its digits until we get a single digit
 * number.
 */
public class DigitalRoot {

    // Method to find the digital root of a number using recursion
    public static int digitalRoot1(int n) {
        // If the number is less than 10, return the number itself
        if (n < 10) {
            return n;
        }
        // Find the sum of digits and recursively find the digital root
        return digitalRoot(sum(n));
    }

    // Helper method to find the sum of digits of a number using recursion
    private static int sum(int n) {
        // If the number is less than 10, return the number itself
        if (n < 10) {
            return n;
        }
        // Calculate the sum of digits using recursion
        return n % 10 + sum(n / 10);
    }

    // Method to find the digital root of a number without using recursion
    public static int digitalRoot(int n) {
        // If the number is 0, return 0
        if (n == 0) {
            return 0;
        }
        // If the number is divisible by 9, return 9
        if (n % 9 == 0) {
            return 9;
        }
        // Otherwise, return the remainder when the number is divided by 9
        return n % 9;
    }

    // Main method to test the DigitalRoot functionality
    public static void main(String[] args) {
        // Example number to find the digital root
        int number = 456;
        // Calculate the digital root of the given number
        int result = digitalRoot(number);
        // Print the digital root of the number
        System.out.println("Digital Root of " + number + ": " + result);
    }
}
