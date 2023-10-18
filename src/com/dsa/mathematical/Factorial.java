package com.dsa.mathematical;

public class Factorial {

    /**
     * This method calculates the factorial of a given number 'N'.
     * @param N The number for which the factorial is to be calculated.
     * @return The factorial of the given number.
     */
    public static long factorial(int N) {
        long result = 1; // Initialize the result as 1

        // Iterate from 1 to N and calculate the factorial
        for (int i = 1; i <= N; i++) {
            result *= i; // Multiply the current result with the current value of 'i'
        }
        return result; // Return the calculated factorial
    }
    
    public static int factorialRec(int n) {
        // If n is 0, the factorial is 1
        if(n == 0) {
            return 1;
        }

        // If n is not 0, recursively compute the factorial
        return n * factorialRec(n - 1);
    }


    /**
     * The main method for testing the factorial method.
     */
    public static void main(String[] args) {
        // Test the factorial method with different inputs
        int number1 = 5;
        int number2 = 0;
        int number3 = 10;

        // Testing factorial method
        System.out.println("Factorial of " + number1 + ": " + factorial(number1));
        System.out.println("Factorial of " + number2 + ": " + factorial(number2));
        System.out.println("Factorial of " + number3 + ": " + factorial(number3));

        // Expected output for the provided test cases:
        // Factorial of 5: 120
        // Factorial of 0: 1
        // Factorial of 10: 3628800
    }
    
    
}
