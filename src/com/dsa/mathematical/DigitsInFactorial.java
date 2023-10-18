package com.dsa.mathematical;

public class DigitsInFactorial {

    /**
     * This method calculates the number of digits in the factorial of a given number 'n'.
     * @param n The number for which the factorial's digits are to be calculated.
     * @return The number of digits in the factorial of the given number.
     */
    public int digitsInFactorial(int n) {
        // If n is negative, the number of digits is 0
        if (n < 0) {
            return 0;
        }

        // If n is 1, the number of digits is 1
        if (n == 1) {
            return 1;
        }
        
        //use log property: log(a*b)=log(a)+log(b)

        double result = 1;
        // Calculate the sum of logarithms of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            result += (Math.log10(i));
        }

        return (int) result; // Return the integer value of the calculated result
    }

    /**
     * The main method for testing the digitsInFactorial method.
     */
    public static void main(String[] args) {
        DigitsInFactorial digitsInFactorial = new DigitsInFactorial();

        // Test the digitsInFactorial method with different inputs
        int number1 = 5;
        int number2 = 10;
        int number3 = -3;

        // Testing digitsInFactorial method
        System.out.println("Number of digits in factorial of " + number1 + ": " + digitsInFactorial.digitsInFactorial(number1));
        System.out.println("Number of digits in factorial of " + number2 + ": " + digitsInFactorial.digitsInFactorial(number2));
        System.out.println("Number of digits in factorial of " + number3 + ": " + digitsInFactorial.digitsInFactorial(number3));

        // Expected output for the provided test cases:
        // Number of digits in factorial of 5: 3
        // Number of digits in factorial of 10: 7
        // Number of digits in factorial of -3: 0
    }
}
