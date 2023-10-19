package com.dsa.mathematical;

/**
 * Lucky numbers are a subset of integers. Rather than going into much theory,
 * let us see the process of arriving at lucky numbers. Take the set of integers
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,…… First,
 * delete every second number, we get the following reduced set. 1, 3, 5, 7, 9,
 * 11, 13, 15, 17, 19,………… Now, delete every third number, we get 1, 3, 7, 9, 13,
 * 15, 19,….…. Continue this process indefinitely…… Any number that does NOT get
 * deleted due to the above process is called “lucky”.
 * 
 * You are given a number N, you need to tell whether the number is lucky or
 * not. If the number is lucky return 1, otherwise 0.
 */
public class LuckyNumbers {

    /**
     * Method to check if the number is lucky.
     * 
     * @param n the number to be checked
     * @return true if the number is lucky, false otherwise
     */
    public static boolean isLucky(int n) {
        return isLucky(n, 2);
    }

    /**
     * Recursive helper method to check if the number is lucky.
     * 
     * @param n the number to be checked
     * @param d the divisor to check the luckiness of the number
     * @return true if the number is lucky, false otherwise
     */
    public static boolean isLucky(int n, int d) {
        // If divisor exceeds the number, it's a lucky number
        if (d > n)
            return true;
        
        // If the number is divisible by the divisor, it's not lucky
        if (n % d == 0)
            return false;
        
        // Reduce n by the quotient of n and d to simulate the elimination process
        int updatedN = n - n / d; 

        // Recursively check the luckiness of the number with the updated value of n
        return isLucky(updatedN, d + 1);
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test cases for the isLucky method
        int N1 = 5; // Expected output: false
        int N2 = 19; // Expected output: true

        // Testing isLucky method
        System.out.println("Is " + N1 + " a lucky number? " + isLucky(N1)); // Expected output: false
        System.out.println("Is " + N2 + " a lucky number? " + isLucky(N2)); // Expected output: true
    }
}
