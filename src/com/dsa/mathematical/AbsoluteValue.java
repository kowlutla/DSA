package com.dsa.mathematical;

public class AbsoluteValue {
    /**
     * This method calculates the absolute value of an integer 'I'.
     * @param I The integer for which the absolute value is to be calculated.
     * @return The absolute value of the integer.
     */
    public static int absolute(int I) {
        // code here
        if (I < 0) {
            I = I * -1; // Convert the negative value to positive
        }

        return I; // Return the absolute value
    }

    /**
     * The main method for testing the absolute method.
     */
    public static void main(String[] args) {

        // Test the absolute method with different inputs
        int number1 = 5;
        int number2 = -12;
        int number3 = 0;

        // Testing absolute method
        System.out.println("Absolute value of " + number1 + ": " + absolute(number1));
        System.out.println("Absolute value of " + number2 + ": " + absolute(number2));
        System.out.println("Absolute value of " + number3 + ": " + absolute(number3));

        // Expected output for the provided test cases:
        // Absolute value of 5: 5
        // Absolute value of -12: 12
        // Absolute value of 0: 0
    }
}
