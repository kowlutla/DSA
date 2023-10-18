package com.dsa.mathematical;

/**
 * Given the first 2 terms A and B of a Geometric Series. The task is to find
 * the Nth term of the series.
 */
public class GPTerm {

    /**
     * This method calculates the Nth term of a Geometric Series.
     * @param A The first term of the Geometric Series.
     * @param B The second term of the Geometric Series.
     * @param N The term position to be found in the series.
     * @return The Nth term of the Geometric Series.
     */
    public static double termOfGP(int A, int B, int N) {
        double ratio = (B * 1.0) / A; // Calculate the common ratio of the series
        return (int)(A * Math.pow(ratio, N - 1)); // Calculate the Nth term using the formula for Geometric Series
    }

    /**
     * The main method for testing the termOfGP method.
     */
    public static void main(String[] args) {
        // Test the termOfGP method with different inputs
        int A1 = 2, B1 = 3, N1 = 4; // Expected output: 6.0
        int A2 = 3, B2 = 5, N2 = 3; // Expected output: 8.0

        // Testing termOfGP method
        System.out.println("The " + N1 + "th term of the series with first term " + A1 + " and second term " + B1 + " is: " + termOfGP(A1, B1, N1));
        System.out.println("The " + N2 + "th term of the series with first term " + A2 + " and second term " + B2 + " is: " + termOfGP(A2, B2, N2));

        // Expected output for the provided test cases:
        // The 4th term of the series with first term 2 and second term 3 is: 6.0
        // The 3rd term of the series with first term 3 and second term 5 is: 8.0
    }
}
