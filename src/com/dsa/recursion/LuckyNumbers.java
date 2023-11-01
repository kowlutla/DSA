package com.dsa.recursion;

/**
 * Lucky numbers are subset of integers. Rather than going into much theory, let
 * us see the process of arriving at lucky numbers, Take the set of integers 1,
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,…… First,
 * delete every second number, we get following reduced set. 1, 3, 5, 7, 9, 11,
 * 13, 15, 17, 19,………… Now, delete every third number, we get 1, 3, 7, 9, 13,
 * 15, 19,….…. Continue this process indefinitely…… Any number that does NOT get
 * deleted due to the above process is called “lucky”.
 */
public class LuckyNumbers {

    // Complete the function
    // n: Input n
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n) {
        return isLucky(n, 2);
    }

    private static boolean isLucky(int n, int d) {
        // Check if the divisor is greater than the given number
        if (d > n) {
            return true;
        }
        // Check if the number is divisible by the current divisor
        if (n % d == 0) {
            return false;
        }
        // Calculate the value that has been removed from the sequence
        int temp = n / d;
        // Recur for the updated number and the next divisor
        return isLucky(n - temp, d + 1);
    }

    // Main method to test the isLucky function
    public static void main(String[] args) {
        // Test case 1
        int testNumber1 = 19;
        System.out.println("Is " + testNumber1 + " a lucky number? " + isLucky(testNumber1));
        
        // Test case 2
        int testNumber2 = 20;
        System.out.println("Is " + testNumber2 + " a lucky number? " + isLucky(testNumber2));
    }
}
