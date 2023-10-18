package com.dsa.mathematical;

/**
 * A prime number is a number which is only divisible by 1 and itself. Given
 * number N, check if it is prime or not.
 */
public class PrimalityTest {

    /**
     * This method checks whether a given number 'n' is a prime number or not.
     * @param n The number to be checked for primality.
     * @return 'true' if the number is prime, 'false' otherwise.
     */
    public static boolean isPrime(int n) {
        // If n is less than or equal to 1, it is not a prime number
        if (n <= 1) {
            return false;
        }

        // If n is 2, it is a prime number
        if (n == 2) {
            return true;
        }

        // Iterate from 2 to the square root of n to check for factors
        for (int i = 2; i * i <= n; i++) {
            // If 'n' is divisible by 'i', it is not a prime number
            if (n % i == 0) {
                return false;
            }
        }

        // If no factors are found, the number is a prime number
        return true;
    }

    /**
     * The main method for testing the isPrime method.
     */
    public static void main(String[] args) {
        // Test the isPrime method with different inputs
        int number1 = 5; // Prime
        int number2 = 12; // Not prime
        int number3 = 29; // Prime

        // Testing isPrime method
        System.out.println(number1 + " is prime: " + isPrime(number1));
        System.out.println(number2 + " is prime: " + isPrime(number2));
        System.out.println(number3 + " is prime: " + isPrime(number3));

        // Expected output for the provided test cases:
        // 5 is prime: true
        // 12 is prime: false
        // 29 is prime: true
    }
}
