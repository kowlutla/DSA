/**
 * 	A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

	For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
	Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
	
	A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
	
	 
	
	Example 1:
	Input: n = 1
	Output: 5
	Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

	Example 2:
	Input: n = 4
	Output: 400

	Example 3:
	Input: n = 50
	Output: 564908303
 */
package com.dsa.recursion;

/**
 * @author KowlutlaSwamy
 *
 */
public class CountGoodNumbers {

    long mod = 1000000007;

    // Method to count good numbers within a range [1, n]
    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // Calculate the count of even numbers in the range [1, n]
        long odd = n / 2; // Calculate the count of odd numbers in the range [1, n]

        // Calculate counts of good numbers ending in even and odd positions
        long count1 = pow(5, even) % mod; // Good numbers ending in even position
        long count2 = pow(4, odd) % mod;  // Good numbers ending in odd position

        // Calculate the total count of good numbers modulo mod
        return (int) ((count1 * count2) % mod);
    }

    // Method to calculate power with modulo
    public long pow(long x, long y) {
        if (y == 0) {
            return 1; // Base case: x^0 = 1
        }

        // Recursive calculation of x^y using modulo
        long temp = pow(x, y / 2); // Calculate power recursively for y/2
        if (y % 2 == 0) {
            return (temp * temp) % mod; // If y is even, x^y = (x^(y/2))^2
        } else {
            return (((x * temp) % mod) * temp) % mod; // If y is odd, x^y = x * (x^(y/2))^2
        }
    }

    // Main method to demonstrate the calculation of good numbers
    public static void main(String[] args) {
        CountGoodNumbers countGoodNumbers = new CountGoodNumbers();

        // Define the range
        long range = 2;

        // Calculate and print the count of good numbers in the range [1, range]
        int count = countGoodNumbers.countGoodNumbers(range);
        System.out.println("Count of good numbers with length " + range +": "+ count);
    }
}
