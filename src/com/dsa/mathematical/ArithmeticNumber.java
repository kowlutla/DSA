package com.dsa.mathematical;

public class ArithmeticNumber {
    /**
     * This method determines whether an integer 'B' exists in the arithmetic sequence defined by 'A' and 'C'.
     * @param A The first term of the arithmetic sequence.
     * @param B The integer to be checked.
     * @param C The common difference of the arithmetic sequence.
     * @return 1 if B is present in the sequence, 0 otherwise.
     */
    static int inSequence(int A, int B, int C) {
        if (C == 0) { // if the common difference is 0, check if A and B are equal
            return A == B ? 1 : 0;
        }
        long dif = B - A; // calculate the difference between A and B
        if (dif * C < 0) { // if the difference and the common difference have opposite signs, B cannot be in the sequence
            return 0;
        }
        if (dif % C == 0) { // if the difference is a multiple of the common difference, B is in the sequence
            return 1;
        } else { // otherwise, B is not in the sequence
            return 0;
        }
    }

    /**
     * The main method for testing the inSequence method.
     */
    public static void main(String[] args) {
        // Test the inSequence method with different inputs
        int A1 = 1, B1 = 3, C1 = 2;
        int A2 = 1, B2 = 2, C2 = 3;
        int A3 = 1, B3 = 3, C3 = 0;

        // Testing inSequence method
        System.out.println("Result for A = " + A1 + ", B = " + B1 + ", C = " + C1 + ": " + inSequence(A1, B1, C1));
        System.out.println("Result for A = " + A2 + ", B = " + B2 + ", C = " + C2 + ": " + inSequence(A2, B2, C2));
        System.out.println("Result for A = " + A3 + ", B = " + B3 + ", C = " + C3 + ": " + inSequence(A3, B3, C3));

        // Expected output for the provided test cases:
        // Result for A = 1, B = 3, C = 2: 1
        // Result for A = 1, B = 2, C = 3: 0
        // Result for A = 1, B = 3, C = 0: 0
    }
}
