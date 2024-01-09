/**
 * 
 */
package com.dsa.dynamic_programming.one_dim_array;

/**
 * @author KowlutlaSwamy
 *
 */
public class FibonacciNumberInSeries {

    // Method to calculate Fibonacci using recursion
    public static int fibUsingRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fibUsingRecursion(n - 1) + fibUsingRecursion(n - 2);
    }

    // Top-down approach with memoization
    public static int fibUsingMemoization(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibUsingMemoization(n - 1, dp) + fibUsingMemoization(n - 2, dp);
    }

    // Bottom-up approach with tabulation
    public static int fibUsingTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Iterative approach using a loop
    public static int fibUsingGeneralLoop(int n) {
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    // Main method to demonstrate the usage of Fibonacci methods
    public static void main(String[] args) {
        int n = 10; // Change the value of n to compute different Fibonacci numbers
        System.out.println("Fibonacci using recursion: " + fibUsingRecursion(n));

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println("Fibonacci using memoization: " + fibUsingMemoization(n, dp));

        System.out.println("Fibonacci using tabulation: " + fibUsingTabulation(n));

        System.out.println("Fibonacci using general loop: " + fibUsingGeneralLoop(n));
    }
}

