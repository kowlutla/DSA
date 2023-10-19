package com.dsa.mathematical;

/**
 * Given two numbers 'N' and 'S' , find the largest number that can be formed
 * with 'N' digits and whose sum of digits should be equals to 'S'. Return -1 if
 * it is not possible.
 */
public class LargestNumberPossible {

    /**
     * This method finds the largest number that can be formed with 'N' digits
     * and whose sum of digits should be equals to 'S'.
     * @param N The number of digits.
     * @param S The desired sum of digits.
     * @return The largest number that satisfies the conditions or -1 if not possible.
     */
    static String findLargest(int N, int S) {
        // If there is only one digit and the sum is 0, then the number is 0
        if (S == 0 && N == 1) {
            return "0";
        }

        // If the number of digits is more than one and the sum is 0, it is not possible
        if (S == 0 && N > 1) {
            return "-1";
        }

        // If the sum is not possible with the given number of digits, return -1
        if (9 * N < S) {
            return "-1";
        }

        // Initialize an array to store the digits of the resulting number
        int[] number = new int[N];

        // Construct the largest number based on the sum
        for (int i = 0; i < N; i++) {
            // If the remaining sum is greater than or equal to 9, assign 9
            if (S >= 9) {
                number[i] = 9;
                S -= 9;
            } else { // Otherwise, assign the remaining sum
                number[i] = S;
                S = 0;
            }
        }

        // Convert the array of digits to a string and return the result
        StringBuffer result = new StringBuffer();
        for (int digit : number) {
            result.append(digit);
        }
        return result.toString();
    }

    // Main method for testing the findLargest method
    public static void main(String[] args) {
        // Test cases for the findLargest method
        int N1 = 2, S1 = 9;
        int N2 = 3, S2 = 20;
        int N3 = 1, S3 = 10;

        // Testing findLargest method
        System.out.println("Result for N = " + N1 + ", S = " + S1 + ": " + findLargest(N1, S1));
        System.out.println("Result for N = " + N2 + ", S = " + S2 + ": " + findLargest(N2, S2));
        System.out.println("Result for N = " + N3 + ", S = " + S3 + ": " + findLargest(N3, S3));

        // Expected output for the provided test cases:
        // Result for N = 2, S = 9: 90
        // Result for N = 3, S = 20: 992
        // Result for N = 1, S = 10: -1
    }
}
