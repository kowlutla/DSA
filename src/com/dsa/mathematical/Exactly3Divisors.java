package com.dsa.mathematical;

/**
 * Given a positive integer value N. The task is to find how many numbers less
 * than or equal to N have numbers of divisors exactly equal to 3.
 */
public class Exactly3Divisors {

    /**
     * This method finds the count of numbers less than or equal to N that have exactly 3 divisors.
     * @param N The upper limit to check for numbers with exactly 3 divisors.
     * @return The count of numbers with exactly 3 divisors.
     */
    public static int exactly3Divisors(int N) {
        int count = 0; // Initialize the count as 0
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime(i)) { // If the number is prime, increment the count
                count++;
            }
        }
        return count; // Return the count of numbers with exactly 3 divisors
    }

    /**
     * This method checks whether a given number 'n' is a prime number or not.
     * @param n The number to be checked for primality.
     * @return 'true' if the number is prime, 'false' otherwise.
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // If 'n' is divisible by any number other than 1 and itself, it is not prime
            }
        }
        return true; // If 'n' is not divisible by any number other than 1 and itself, it is prime
    }

    /**
     * The main method for testing the exactly3Divisors method.
     */
    public static void main(String[] args) {
        // Test the exactly3Divisors method with different inputs
        int number1 = 10; // Expected output: 2
        int number2 = 30; // Expected output: 3

        // Testing exactly3Divisors method
        System.out.println("Numbers with exactly 3 divisors less than or equal to " + number1 + ": " + exactly3Divisors(number1));
        System.out.println("Numbers with exactly 3 divisors less than or equal to " + number2 + ": " + exactly3Divisors(number2));

        // Expected output for the provided test cases:
        // Numbers with exactly 3 divisors less than or equal to 10: 2
        // Numbers with exactly 3 divisors less than or equal to 30: 3
    }
}
