package com.dsa.mathematical;

/**
 * Given three distinct numbers A, B, and C. Find the number with value in the middle (Try to do it with minimum comparisons).
 */
public class MiddleOfThree {

    /**
     * Method to find the middle value among three distinct numbers.
     * 
     * @param A the first number
     * @param B the second number
     * @param C the third number
     * @return the value in the middle
     */
    public static int middle(int A, int B, int C) {
        // Finding the maximum and minimum values among the three numbers
        int max = Math.max(Math.max(A, B), C);
        int min = Math.min(Math.min(A, B), C);
        
        // Return the sum of the three numbers minus the sum of the maximum and minimum, which gives the middle value
        return (A + B + C) - (max + min);
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test cases
        int A1 = 1, B1 = 2, C1 = 3; // Expected output: 2
        int A2 = 12, B2 = 14, C2 = 11; // Expected output: 12

        // Testing middle method
        System.out.println("The middle value of " + A1 + ", " + B1 + ", and " + C1 + " is: " + middle(A1, B1, C1)); // Expected output: 2
        System.out.println("The middle value of " + A2 + ", " + B2 + ", and " + C2 + " is: " + middle(A2, B2, C2)); // Expected output: 12
    }
}
