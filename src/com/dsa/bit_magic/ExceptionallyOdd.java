package com.dsa.bit_magic;

/**
 * Given an array of N positive integers where all numbers occur even number of
 * times except one number which occurs odd number of times. Find the
 * exceptional number.
 */
public class ExceptionallyOdd {

    // Function to find the element that occurs an odd number of times
    int getOddOccurrence(int[] arr, int n) {
        // Initialize xor to 0
        int xor = 0;
        // Perform XOR of all elements in the array
        for (int num : arr) {
            xor ^= num;
        }
        // Return the element that occurs an odd number of times
        return xor;
    }

    // Main method to test the getOddOccurrence functionality
    public static void main(String[] args) {
        // Example usage
        ExceptionallyOdd exceptionallyOdd = new ExceptionallyOdd();
        int[] arr = { 4, 4, 2, 2, 3, 3, 3, 4, 4 };
        System.out.println("Element that occurs an odd number of times: " + exceptionallyOdd.getOddOccurrence(arr, arr.length));
    }
}
