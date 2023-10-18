package com.dsa.mathematical;

import java.util.ArrayList;

public class QuadraticEquationRoots {

    /**
     * This method computes the roots of a quadratic equation given the coefficients.
     * @param a The coefficient of x^2.
     * @param b The coefficient of x.
     * @param c The constant term.
     * @return An ArrayList containing the roots of the quadratic equation.
     */
    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> result = new ArrayList<>();
        double underRadical = (b * b) - (4.0 * a * c);

        // If the roots are imaginary (complex numbers)
        if (underRadical < 0) {
            result.add(-1); // Indicate that the roots are imaginary
            return result;
        } else {
            // Compute the roots for real numbers
            int root1 = (int) Math.floor((-b + (Math.sqrt(underRadical))) / (2.0 * a));
            int root2 = (int) Math.floor((-b - (Math.sqrt(underRadical))) / (2.0 * a));

            result.add(Math.max(root1, root2)); // Add the larger root to the result
            result.add(Math.min(root1, root2)); // Add the smaller root to the result
            return result; // Return the ArrayList containing the roots
        }
    }

    /**
     * The main method for testing the quadraticRoots method.
     */
    public static void main(String[] args) {
        // Test the quadraticRoots method with different inputs
        int a1 = 1, b1 = -7, c1 = 12; // Roots: 4, 3
        int a2 = 1, b2 = -3, c2 = 2; // Roots: 2, 1
        int a3 = 1, b3 = 2, c3 = 5; // Roots: Imaginary

        // Testing quadraticRoots method
        System.out.println("Roots for equation with coefficients " + a1 + ", " + b1 + ", " + c1 + ": " + quadraticRoots(a1, b1, c1));
        System.out.println("Roots for equation with coefficients " + a2 + ", " + b2 + ", " + c2 + ": " + quadraticRoots(a2, b2, c2));
        System.out.println("Roots for equation with coefficients " + a3 + ", " + b3 + ", " + c3 + ": " + quadraticRoots(a3, b3, c3));

        // Expected output for the provided test cases:
        // Roots for equation with coefficients 1, -7, 12: [4, 3]
        // Roots for equation with coefficients 1, -3, 2: [2, 1]
        // Roots for equation with coefficients 1, 2, 5: [-1]
    }
}
