package com.dsa.bit_magic;

/**
 * Given an integer array arr[] of size n which contains only 1 and 0. Your task
 * is to make the array perfect. An array is said to be perfect if for each i
 * from 0 to n-1 arr[i]==arr[n-1-i] is satisfied.
 * 
 * To Make the array perfect you are allowed to do the following operation :
 * 
 * In one operation you can choose two different indexes i and j and set value
 * of both arr[i] and arr[j] to arr[i]^arr[j].
 * 
 * Your task is to make the array perfect in the minimum possible number of
 * operations and return the number of operations.
 */
public class BitMagic {

    // Method to perform the necessary bit manipulation operations
    public static int bitMagic(int n, int[] arr) {
        int count = 0; // Initialize the count variable
        for (int i = 0; i < n / 2; i++) { // Iterate through the first half of the array
            if (arr[i] != arr[n - i - 1]) { // Check if the elements are not symmetrically equal
                count++; // Increment the count
            }
        }

        // Check if the count is even or odd and return the appropriate value
        if (count % 2 == 0) {
            return count / 2;
        }
        return count / 2 + 1;
    }
    
    public static void main(String[] args) {
        // Example usage of the bitMagic method
        int[] arr = {1, 0, 1, 0, 1}; // Example input array
        int n = arr.length; // Size of the array

        // Call the bitMagic method and store the result
        int result = bitMagic(n, arr);

        // Print the result
        System.out.println("Minimum number of operations to make the array perfect: " + result);
    }
}
