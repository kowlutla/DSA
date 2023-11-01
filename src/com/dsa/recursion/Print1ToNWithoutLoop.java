package com.dsa.recursion;

/**
 * Print numbers from 1 to N without the help of loops.
 */
public class Print1ToNWithoutLoop {
    
    // Recursive method to print numbers from 1 to N
    public static void printNos(int N) {
        // Base case: if N becomes 0, stop the recursion
        if (N == 0) {
            return;
        }
        // Recursive call to print numbers from 1 to N - 1
        printNos(N - 1);
        // Print the current number
        System.out.print(N + " ");
    }

    // Main method for testing the printNos method
    public static void main(String[] args) {
        // Example input N
        int N = 10;
        // Print numbers from 1 to N using the printNos method
        printNos(N);
    }
}
