package com.dsa.recursion;

/**
 * Given the total number of persons n and a number k which indicates that k-1
 * persons are skipped and kth person is killed in circle in a fixed direction.
 * After each operation, the count will start from k+1th person. The task is to
 * choose the safe place in the circle so that when you perform these operations
 * starting from 1st place in the circle, you are the last one remaining and
 * survive.
 */
public class JosephusProblem {

    // Method to find the safe position in the circle according to Josephus problem algorithm
    public static int josephus(int n, int k) {
        // If there is only one person left, return 1
        if (n == 1) {
            return 1;
        }
        // Recursive call to find the next position using the Josephus problem algorithm
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    // Main method to test the JosephusProblem functionality
    public static void main(String[] args) {
        // Example values for the total number of persons and the number k
        int n = 7;
        int k = 3;
        // Calculate the safe position using the Josephus algorithm
        int result = josephus(n, k);
        // Print the safe position
        System.out.println("The safe position in the circle: " + result);
    }
}
