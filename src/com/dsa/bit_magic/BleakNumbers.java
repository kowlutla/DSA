package com.dsa.bit_magic;

/**
 * Given an integer, check whether it is Bleak or not.
 * 
 * A number n is called Bleak if it cannot be represented as the sum of a positive
 * number x and the set bit count in x, i.e., x + countSetBits(x) is not equal to n
 * for any non-negative number x.
 */
public class BleakNumbers {

    // Method to check if the given number is Bleak or not
    public int is_bleak(int n) {
        // Find the maximum possible count of set bits for the given number
        int max_csb = (int) (Math.log(n) / Math.log(2)) + 1;
        // Check each number in the given range
        for (int i = n - max_csb; i < n; i++) {
            // Count the set bits for the current number
            int setbits = countSetBits(i);
            // Check if the sum of the current number and its set bits count is equal to n
            if (i + setbits == n) {
                // If the condition is satisfied, the number is not Bleak
                return 0;
            }
        }
        // If the condition is never satisfied, the number is Bleak
        return 1;
    }

    // Method to count the set bits in a number
    private int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    // Main method for testing is_bleak method
    public static void main(String[] args) {
        // Example input
        int n = 7;

        // Create an instance of BleakNumbers class
        BleakNumbers bleakNumbers = new BleakNumbers();

        // Check if the number is Bleak or not
        int result = bleakNumbers.is_bleak(n);

        // Print the result
        if (result == 1) {
            System.out.println(n + " is a Bleak number.");
        } else {
            System.out.println(n + " is not a Bleak number.");
        }
    }
}
