package com.dsa.mathematical;

/**
 * Given a positive integer N., The task is to find the value of Σi from 1 to N F(i) where function F(i) for the number i is defined as the sum of all divisors of i.
 */
public class SumofAllDivisorsFrom1ToN {

    /**
     * Method to calculate the sum of divisors from 1 to N using the nested loop approach.
     * 
     * @param n the positive integer N
     * @return the sum of divisors from 1 to N
     */
    static long sumOfDivisors1(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            // Loop to find all divisors of i and add them to the sum
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    // If j is a proper divisor of i, add j to the sum
                    if (j != (i / j)) {
                        sum += (i / j);
                    }
                    sum += j;
                }
            }
            // Add the sum to the result for each value of i
            result += sum;
        }
        // Return the final result
        return result;
    }

    /**
     * Method to calculate the sum of divisors from 1 to N using a more efficient approach.
     * 
     * @param n the positive integer N
     * @return the sum of divisors from 1 to N
     */
    static long sumOfDivisors(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            // Use the mathematical formula to find the sum of divisors more efficiently
            result += ((n / i) * i);
        }
        // Return the final result
        return result;
    }

    // Main method with test cases
    public static void main(String[] args) {
        // Test cases
        int n1 = 5; // Expected output: 21
        int n2 = 8; // Expected output: 56

        // Testing sumOfDivisors1 method
        System.out.println("The sum of divisors from 1 to " + n1 + " using the nested loop approach: " + sumOfDivisors1(n1)); // Expected output: 21
        System.out.println("The sum of divisors from 1 to " + n2 + " using the nested loop approach: " + sumOfDivisors1(n2)); // Expected output: 56

        // Testing sumOfDivisors method
        System.out.println("The sum of divisors from 1 to " + n1 + " using the more efficient approach: " + sumOfDivisors(n1)); // Expected output: 21
        System.out.println("The sum of divisors from 1 to " + n2 + " using the more efficient approach: " + sumOfDivisors(n2)); // Expected output: 56
    }
}
