package com.dsa.mathematical;

public class SquareRootOfNumber {
    /**
     * This method finds the square root of the input number x.
     * @param x The number for which the square root is to be found.
     * @return The square root of x, rounded down to the nearest integer if it is not a perfect square.
     */
    long floorSqrt(long x) {
        long start = 1; // initialize the starting point for the binary search
        long end = x; // initialize the ending point for the binary search

        // Perform binary search to find the square root or the floor of the square root
        while (start <= end) {
            long mid = (start + end) / 2; // find the middle element

            if (mid * mid == x) { // if the middle element is the square root, return it
                return mid;
            }

            if (mid * mid < x) { // if the square of the middle element is less than x, adjust the starting point
                start = mid + 1;
            } else { // if the square of the middle element is greater than x, adjust the ending point
                end = mid - 1;
            }
        }

        // return the value just before the point where the elements started to diverge
        return start - 1;
    }

    /**
     * The main method for testing the floorSqrt method.
     */
    public static void main(String[] args) {
        SquareRootOfNumber squareRootOfNumber = new SquareRootOfNumber();

        // Test the floorSqrt method with different inputs
        long x1 = 16;
        long x2 = 17;
        long x3 = 25;
        long x4 = 10;

        // Testing floorSqrt method
        System.out.println("The square root of " + x1 + " is: " + squareRootOfNumber.floorSqrt(x1));
        System.out.println("The square root of " + x2 + " is: " + squareRootOfNumber.floorSqrt(x2));
        System.out.println("The square root of " + x3 + " is: " + squareRootOfNumber.floorSqrt(x3));
        System.out.println("The square root of " + x4 + " is: " + squareRootOfNumber.floorSqrt(x4));

        // Expected output for the provided test cases:
        // The square root of 16 is: 4
        // The square root of 17 is: 4
        // The square root of 25 is: 5
        // The square root of 10 is: 3
    }
}
