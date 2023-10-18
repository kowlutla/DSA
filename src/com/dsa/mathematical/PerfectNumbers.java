package com.dsa.mathematical;

public class PerfectNumbers {

    /**
     * This method checks if a number is a perfect number.
     * @param N The number to be checked.
     * @return 1 if the number is perfect, 0 otherwise.
     */
    static int isPerfectNumber(long N) {
        if (N == 1) { // 1 is not a perfect number
            return 0;
        }

        long sum = 1; // Initialize the sum with 1, as 1 is always a divisor
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) { // If i is a divisor of N
                sum += i; // Add i to the sum of divisors
                if (i * i != N) { // If i is not the square root of N (i.e., N is not a perfect square)
                    sum += (N / i); // Add N/i to the sum of divisors as well
                }
            }
        }

        if (sum == N) {
            return 1; // If the sum of divisors is equal to the number itself, it's a perfect number
        } else {
            return 0; // Otherwise, it's not a perfect number
        }
    }

    /**
     * This method checks if a number is a perfect number.
     * @param n The number to be checked.
     * @return 1 if the number is perfect, 0 otherwise.
     */
    public static int isPerfectNumber1(long n) {
        if (n == 1) { // 1 is not a perfect number
            return 0;
        }

        long sum = 1; // Initialize the sum with 1, as 1 is always a divisor
        for (long i = 2; i < n; i++) {
            if (n % i == 0) { // If i is a divisor of n
                sum += i; // Add i to the sum of divisors
            }
        }

        if (sum == n) {
            return 1; // If the sum of divisors is equal to the number itself, it's a perfect number
        } else {
            return 0; // Otherwise, it's not a perfect number
        }
    }

    /**
     * The main method for testing the isPerfectNumber and isPerfectNumber1 methods.
     */
    public static void main(String[] args) {
        // Test the isPerfectNumber method with different inputs
        long N1 = 6;
        long N2 = 28;
        long N3 = 12;

        // Testing isPerfectNumber method
        System.out.println("Result for N = " + N1 + ": " + isPerfectNumber(N1));
        System.out.println("Result for N = " + N2 + ": " + isPerfectNumber(N2));
        System.out.println("Result for N = " + N3 + ": " + isPerfectNumber(N3));

        // Test the isPerfectNumber1 method with different inputs
        long n1 = 6;
        long n2 = 28;
        long n3 = 12;

        // Testing isPerfectNumber1 method
        System.out.println("Result for n = " + n1 + ": " + isPerfectNumber1(n1));
        System.out.println("Result for n = " + n2 + ": " + isPerfectNumber1(n2));
        System.out.println("Result for n = " + n3 + ": " + isPerfectNumber1(n3));

        // Expected output for the provided test cases:
        // Result for N = 6: 1
        // Result for N = 28: 1
        // Result for N = 12: 0
        // Result for n = 6: 1
        // Result for n = 28: 1
        // Result for n = 12: 0
    }
}
